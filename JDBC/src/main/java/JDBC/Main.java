package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*from  w  w  w.  j  a va2  s.  c  om*/
public class Main {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost/gestione_guasti";
  static final String USER = "manuel";
  static final String PASS = "manuel2";

  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      String sql = "SELECT * FROM `guasto` WHERE 1";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
    	String codice_guasto = rs.getString("codice_guasto");
    	String nome_guasto = rs.getString("nome_guasto");
        String descrizione = rs.getString("descrizione");
       

        System.out.print("ID: " + codice_guasto);
        System.out.print(", Age: " + nome_guasto);
        System.out.print(", First: " + descrizione);
        
      }
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException se) {
      se.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (stmt != null)
          stmt.close();
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        se.printStackTrace();
      }
    }
  }
}