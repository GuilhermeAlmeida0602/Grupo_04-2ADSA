package bandtec.com.br.totemsoluction.persistence;

import bandtec.com.br.totemsoluction.entity.Maquina;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.util.Conversor;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class ProcessosMaquinaDao extends Dao {

    public void insertProcessosMaquina(Looca looca, Integer fkMaquina) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ProcessosGroup processosGroup = looca.getGrupoDeProcessos();
        List<Processo> processos = processosGroup.getProcessos();
        Conversor conv = new Conversor();

        for (Integer i = 0; i < processos.size(); i++) {
            open();
            try {
                System.out.println("Realizando registro de totem no banco...");
                stmt = con.prepareStatement("insert into processosMaquina (fkMaquina, "
                        + "processo, pid, usoCPU, usoMemoria, encerrarProcessos, dataProcesso) values (?,?,?,?,?,?,?);");
                stmt.setInt(1, fkMaquina);
                stmt.setString(2, processos.get(i).getNome());
                stmt.setInt(3, processos.get(i).getPid());
                stmt.setInt(4, processos.get(i).getUsoCpu().intValue());
                stmt.setDouble(5, processos.get(i).getUsoMemoria());
                stmt.setInt(6, 0);
                stmt.setString(7, dtf.format(LocalDateTime.now()));
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Registro realizado com sucesso!");
            } catch (SQLException ex) {
                System.out.println("Ocorreu um problema no registro - Dados Máquina");
                ex.printStackTrace();
            } finally {
                close();
            }
        }
    }

    public List<String> encerraProcessos(Integer fkMaquina) throws Exception {
        open();
        List<String> listaProcessos = new ArrayList<>();
        try {
            /*Abertura da conexão com banco de dados*/
            stmt = con.prepareStatement("select processo from processosMaquina "
                    + "where encerrarProcessos = 1 and fkMaquina = ?;");
            stmt.setInt(1, fkMaquina);
            rs = stmt.executeQuery();
            /*Execução da instrução no banco - parte importante*/
            while (rs.next()) {
                String p = rs.getString(1);
                listaProcessos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /*Fechamento da conexão com banco de dados*/
            close();
        }
        return listaProcessos;
    }

    public void limparProcessos(Integer fkMaquina) throws Exception {
        open();
        try {
            /*Abertura da conexão com banco de dados*/
            stmt = con.prepareStatement("delete from processosMaquina "
                    + "where fkMaquina=?;");
            stmt.setInt(1, fkMaquina);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void deletarProcessos(Integer fkMaquina, String processo) throws Exception {
        open();
        try {
            /*Abertura da conexão com banco de dados*/
            stmt = con.prepareStatement("delete from processosMaquina "
                    + "where processo = ? and fkMaquina =?;");
            stmt.setString(1, processo);
            stmt.setInt(2, fkMaquina);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

}
