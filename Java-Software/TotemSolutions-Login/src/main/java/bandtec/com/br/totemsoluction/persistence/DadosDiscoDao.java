package bandtec.com.br.totemsoluction.persistence;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

// @author vitor
public class DadosDiscoDao extends Dao {

    public void insertDadosDisco(Looca looca, Integer fkDisco) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        DiscosGroup grupo = looca.getGrupoDeDiscos();
        List<Volume> volumes = grupo.getVolumes();
        var disponivel = (volumes.get(0).getDisponivel() * 100) / volumes.get(0).getTotal();

        open();
        try {
            System.out.println("Realizando registro do disco no banco...");
            stmt = con.prepareStatement("insert into DadosDisco (fkDisco, "
                    + "discoDisponivelHD, dataRegistroDados) values (?,?,?);");

            stmt.setInt(1, fkDisco);
            stmt.setInt(2, (int) disponivel);
            stmt.setString(3, dtf.format(LocalDateTime.now()));

            stmt.executeUpdate();
            stmt.close();
            System.out.println("Registro realizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um problema no registro - DadosDisco");
            ex.printStackTrace();
        } finally {
            close();
        }
    }
}
