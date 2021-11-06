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
                "root", "11097");
    }

    public void close() throws Exception {
        con.close();
    }
}
