/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsiblity;

import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maazh
 */
public class EmployeeLogger extends AbstractLogger{

  public EmployeeLogger(int level){
      this.level = level;
   }
    @Override
    protected void Add(Object obj) {
        Beans.EmployeeBeans ebeans = (Beans.EmployeeBeans) obj;
        try {
            String query = "INSERT INTO tb_employee (`name`,`address`,`email`, `password`,`username`,`dept`) VALUES( '"
                    + ebeans.getName()+ "','" + ebeans.getAddress()+ "','" + ebeans.getEmail()+ "','" + ebeans.getPassword()+ "','" + ebeans.getUsername()+ "'," + ebeans.getDept()+ ")";
            Statement st = null;
            st = (Statement) connection.Connect.con.createStatement();
            if (st.executeUpdate(query) == 1) {
                System.out.println("inserted Emplyee");
            } else {

            }
        } catch (SQLException ex) {
            System.out.println("Data Is Not Inserted");
            if (ex.getErrorCode() == 1062) {

            } else {
                Logger.getLogger(StudentLogger.class.getName()).log(Level.SEVERE, null, ex + " error code " + String.valueOf(ex.getErrorCode()));
            }
        }
    }

}
