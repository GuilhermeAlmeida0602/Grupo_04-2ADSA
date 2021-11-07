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
                "root", "senha");
    }
//    public void open() throws Exception {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        con = DriverManager.getConnection("jdbc:sqlserver://infosystems-server.database.windows.net:1433;database=infoSystems;user=infosystems-bd@infosystems-server;password={};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
//    }

    public void close() throws Exception {
        con.close();

    }
}
