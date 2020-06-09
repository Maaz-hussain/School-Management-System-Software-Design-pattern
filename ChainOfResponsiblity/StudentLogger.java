/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsiblity;

import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maazh
 */
public class StudentLogger extends AbstractLogger {

    public StudentLogger(int level) {
        this.level = level;
    }

    @Override
    protected void Add(Object obj) {
        Beans.StudentsBeans sbeans = (Beans.StudentsBeans) obj;
        try {
            String query = "INSERT INTO tb_student (`fname`,`lname`,`address`, `contact`,`email`,`date_of_join`) VALUES( '"
                    + sbeans.getFname() + "','" + sbeans.getLname() + "','" + sbeans.getAddress() + "','" + sbeans.getContact() + "','" + sbeans.getEmail() + "','" + generateDate() + "')";
            Statement st = null;
            st = (Statement) connection.Connect.con.createStatement();
            if (st.executeUpdate(query) == 1) {
                System.out.println("inserted studented");
            } else {

            }
        } catch (SQLException ex) {
            System.out.println("InsertSec Data Is Not Inserted");
            if (ex.getErrorCode() == 1062) {

            } else {
                Logger.getLogger(StudentLogger.class.getName()).log(Level.SEVERE, null, ex + " error code " + String.valueOf(ex.getErrorCode()));
            }
        }
    }

    public static String generateDate() {
        LocalDate dt = LocalDate.parse(LocalDate.now().toString());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter.format(dt);
    }

    public static String generateTime() {
        LocalTime dt = LocalTime.parse(LocalTime.now().toString());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return formatter.format(dt);
    }
}
