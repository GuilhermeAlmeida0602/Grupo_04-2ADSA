/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandtec.com.br.totemsoluction.persistence;

import bandtec.com.br.totemsoluction.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class UsuarioDao extends Dao {
    
        public Usuario autentificacaoDeUsuario(Usuario usuario) throws Exception {
        open();
        /*Abertura da conexão com banco de dados*/
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
        /*Fechamento da conexão com banco de dados*/
        return u;
    }
}
