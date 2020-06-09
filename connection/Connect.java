package connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {

    public static Connection con;
    public static Connection conn = null;

    public static void connects() {

        try {
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String URL = "jdbc:mysql://localhost:3306/school_db";

            //  Database credentials
            String USER = "root";
            String PASSWORD = "root";
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection Established");

        } catch (Exception ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void connectSQL() {

        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=lab1;integratedSecurity=true;";
            String user = "";
            String pass = "";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
