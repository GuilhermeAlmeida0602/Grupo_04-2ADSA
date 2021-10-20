/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandtec.com.br.totemsoluction.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author vitor
 */
public class Dao {

    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    public void open() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosystems",
                "root", "@Fan3farra");
    }

    public void close() throws Exception {
        con.close();

    }
}
