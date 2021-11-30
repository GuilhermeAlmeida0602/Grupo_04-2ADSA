package bandtec.com.br.totemsoluction.persistence;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.util.Conversor;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author vitor
 */
public class DadosMaquinaDao extends Dao {

    public void insertDadosMaquina(Looca looca, Integer fkMaquina) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Conversor conv = new Conversor();
        Memoria memoria = new Memoria();

        open();
        try {
            System.out.println("Realizando registro de totem no banco...");
            stmt = con.prepareStatement("insert into DadosMaquina (fkMaquina, "
                    + "inicializadoSO, tempoDeAtividadeSO, usuarioSO, emUsoCPU, "
                    + "emUsoMEM, disponivelMEM, totalMEM, dataRegistro) "
                    + "values (?,?,?,?,?,?,?,?,?);");

            stmt.setInt(1, fkMaquina);
            stmt.setString(2, String.format("%s", looca.getSistema().getInicializado()));
            stmt.setString(3, Conversor.formatarSegundosDecorridos(looca.getSistema().getTempoDeAtividade())); 
            stmt.setString(4, (looca.getSistema().getPermissao() ? "root" : "usuário padrão"));
            stmt.setInt(5, looca.getProcessador().getUso().intValue());
            stmt.setInt(6, (int) ((memoria.getEmUso() * 100) / memoria.getTotal()) + 1);
            stmt.setInt(7, (int) ((memoria.getDisponivel() * 100) / memoria.getTotal()));
            stmt.setString(8, conv.formatarBytes(memoria.getTotal()));
            stmt.setString(9, dtf.format(LocalDateTime.now()));
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
