package bandtec.com.br.totemsoluction.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// @author vitor
public class Dao {

    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    public void open() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosystems",
<<<<<<< HEAD
                "root", "@Fan3farra");
=======
                "root", "11097");
>>>>>>> d7e4e29f74125573b1af65c9f4783c8b8ad2ccb5
    }
//    public void open() throws Exception {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        con = DriverManager.getConnection("jdbc:sqlserver://infosystems-server.database.windows.net:1433;database=infoSystems;user=infosystems-bd@infosystems-server;password={};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
//    }

    public void close() throws Exception {
        con.close();

    }
}
