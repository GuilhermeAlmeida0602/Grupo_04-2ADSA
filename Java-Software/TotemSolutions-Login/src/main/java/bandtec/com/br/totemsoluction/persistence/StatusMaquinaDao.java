package bandtec.com.br.totemsoluction.persistence;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author vitor
 */
public class StatusMaquinaDao extends Dao {

    public void insertStatusMaquina(Integer fkMaquina, String status) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        open();
        try {
            System.out.println("Realizando registro de totem no banco...");
            stmt = con.prepareStatement("insert into StatusMaquina (fkMaquina, "
                    + "statusMaq, dataStatus) values (?,?,?);");
            stmt.setInt(1, fkMaquina);
            stmt.setString(2, status);
            stmt.setString(3, dtf.format(LocalDateTime.now()));
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Registro realizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um problema no registro - Status Máquina");
            ex.printStackTrace();
        } finally {
            close();
        }
    }
    
    public void updateReiniciar(Integer fkMaquina, String status) throws Exception {
        try {
            open();
            stmt = con.prepareStatement(
                    "update StatusMaquina set statusMaq=? where fkMaquina=?");
            stmt.setString(1, status);
            stmt.setInt(2, fkMaquina);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }
}
