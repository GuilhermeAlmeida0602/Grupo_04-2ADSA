package bandtec.com.br.totemsoluction.persistence;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.util.Conversor;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        for ( Integer i = 0; i < processos.size(); i++) {
            open();
            try {
                System.out.println("Realizando registro de totem no banco...");
                stmt = con.prepareStatement("insert into processosMaquina (fkMaquina, "
                        + "processo, pid, usoCPU, usoMemoria, dataProcesso) values (?,?,?,?,?,?);");
                stmt.setInt(1, fkMaquina);
                stmt.setString(2, processos.get(i).getNome());
                stmt.setInt(3, processos.get(i).getPid());
                stmt.setInt(4, processos.get(i).getUsoCpu().intValue());
                stmt.setDouble(5, processos.get(i).getUsoMemoria());
                stmt.setString(6, dtf.format(LocalDateTime.now()));
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
    
    
//    public void insertProcessosMaquina(Looca looca, Integer fkMaquina) throws Exception {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        ProcessosGroup processosGroup = looca.getGrupoDeProcessos();
//        List<Processo> processos = processosGroup.getProcessos();
//
//        for ( Integer i = 0; i < processos.size(); i++) {
//            open();
//            try {
//                System.out.println("Realizando registro de totem no banco...");
//                stmt = con.prepareStatement("insert into processosMaquina (fkMaquina, "
//                        + "processo, pid, dataProcesso) values (?,?,?,?);");
//                stmt.setInt(1, fkMaquina);
//                stmt.setString(2, processos.get(i).getNome());
//                stmt.setInt(3, processos.get(i).getPid());
//                stmt.setString(4, dtf.format(LocalDateTime.now()));
//                stmt.executeUpdate();
//                stmt.close();
//                System.out.println("Registro realizado com sucesso!");
//            } catch (SQLException ex) {
//                System.out.println("Ocorreu um problema no registro - Dados Máquina");
//                ex.printStackTrace();
//            } finally {
//                close();
//            }
//        }
//    }
}
