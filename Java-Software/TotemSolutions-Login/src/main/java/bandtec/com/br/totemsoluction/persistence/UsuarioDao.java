package bandtec.com.br.totemsoluction.persistence;

import bandtec.com.br.totemsoluction.LoginPage;
import bandtec.com.br.totemsoluction.ProcessosTelaInicial;
import bandtec.com.br.totemsoluction.entity.Usuario;
import bandtec.com.br.totemsoluction.slack.MensagensSlack;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

// @author vitor
public class UsuarioDao extends Dao {

    MensagensSlack slack = new MensagensSlack();

    public Usuario autentificacaoDeUsuario(Usuario usuario) throws Exception {

        // Abertura da conexão com banco de dados
        open();

        System.out.println("Iniciando autentificação no banco...");
        stmt = con.prepareStatement("select fkEmpresa, emailUsuario, senhaUsuario from "
                + "Usuario where emailUsuario=? and senhaUsuario= ?;");
        stmt.setString(1, usuario.getLogin());
        stmt.setString(2, usuario.getSenha());
        rs = stmt.executeQuery();
        /*Execução da instrução no banco - parte importante*/
        Usuario u = null;
        while (rs.next()) {
            u = new Usuario();
            u.setFkEmpresa(rs.getInt(1));
            u.setLogin(rs.getString(2));
            u.setSenha(rs.getString(3));
        }
        close();
        // Fechamento da conexão com banco de dados

        try {
            // Avisando para o usuario que a máquina está sendo monitoradoka
            slack.startService();

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;

    }
}
