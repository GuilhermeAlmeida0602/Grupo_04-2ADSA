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
        stmt = con.prepareStatement("select fkEmpresa, login, senha from "
                + "usuario where login=? and senha= ?;");
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
            // Avisando para o usuario que a máquina está sendo monitorada
            slack.startService();

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return u;
   
    }

//    public void loginUsuario(LoginPage usuario) throws Exception {
//
//        // Abertura da conexão com banco de dados
//        open();
//
//        try {
//            System.out.println("Iniciando a verificação do login do usuário no BD...\n");
//            stmt = con.prepareStatement("select * from usuario where login = ? and senha = ?;");
//            stmt.setString(1, usuario.getLogin());
//            stmt.setString(2, usuario.getSenha());
//            ResultSet rs = stmt.executeQuery();
//
//            if (!rs.next()) {
//                JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos!", "Erro!", JOptionPane.ERROR_MESSAGE);
//                return;
//            } 
//            usuario.setVisible(false);
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos!", "Erro!", JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
//        } finally {
//            close();
//        }
//
//        // Fechamento da conexão com banco de dados
//        close();
//
//        try {
//
//            // Avisando para o usuario que a máquina está sendo monitorada
//            slack.startService();
//            new ProcessosTelaInicial().setVisible(true);
//
//        } catch (IOException | InterruptedException ex) {
//            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}
