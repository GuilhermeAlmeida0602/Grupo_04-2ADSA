package bandtec.com.br.totemsoluction.persistence;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.util.Conversor;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author vitor
 */
public class DiscoDao extends Dao {

    public void insertInfoDisco(Looca looca, Integer fkMaquina) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DiscosGroup grupo = looca.getGrupoDeDiscos();
        List<Disco> discos = grupo.getDiscos();
        List<Volume> volumes = grupo.getVolumes();

        for (Integer i = 0; i < discos.size(); i++) {
            open();
            try {
                System.out.println("Realizando registro do disco no banco...");
                stmt = con.prepareStatement("insert into Disco (fkMaquina, nome, modelo, tamanho, qtdLeitura,"
                        + "bytesLeitura, qtdEscritas, tipo, montagem, dataDeRegistro) "
                        + " values (?,?,?,?,?,?,?,?,?,?);");
                
                stmt.setInt(1, fkMaquina);
                stmt.setString(2, discos.get(i).getNome());
                stmt.setString(3, discos.get(i).getModelo());
                stmt.setString(4, Conversor.formatarBytes(discos.get(i).getTamanho()));
                stmt.setString(5, Conversor.formatarBytes(discos.get(i).getLeituras()));
                stmt.setString(6, Conversor.formatarBytes(discos.get(i).getBytesDeLeitura()));
                stmt.setString(7, Conversor.formatarBytes(discos.get(i).getEscritas()));
                stmt.setString(8, volumes.get(i).getTipo());
                stmt.setString(9, volumes.get(i).getPontoDeMontagem());
                stmt.setString(10, dtf.format(LocalDateTime.now()));
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Registro realizado com sucesso!");
            } catch (SQLException ex) {
                System.out.println("Ocorreu um problema no registro");
                ex.printStackTrace();
            } finally {
                close();
            }
        }
    }

    public Integer buscaId(Looca looca, Integer fkMaquina) throws Exception {
        DiscosGroup grupo = looca.getGrupoDeDiscos();
        List<Volume> volumes = grupo.getVolumes();
        open();
        /*Abertura da conexão com banco de dados*/
        stmt = con.prepareStatement("select idDisco from Disco where montagem = ? and fkMaquina = ?");
        stmt.setString(1, volumes.get(0).getPontoDeMontagem());
        stmt.setInt(2, fkMaquina);
        rs = stmt.executeQuery();
        /*Execução da instrução no banco - parte importante*/
        Integer idDisco = null;
        while (rs.next()) {
            idDisco = rs.getInt(1);
        }
        close();
        /*Fechamento da conexão com banco de dados*/
        return idDisco;
    }
}
