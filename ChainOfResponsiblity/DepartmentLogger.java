 
package ChainOfResponsiblity;
 
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartmentLogger   extends AbstractLogger{

  public DepartmentLogger(int level){
      this.level = level;
   }
    @Override
    protected void Add(Object obj) {
        Beans.DeptBeans dbeans = (Beans.DeptBeans) obj;
        try {System.out.println("dept inserted");
            String query = "INSERT INTO tb_dept (`dept_name`) VALUES( '" + dbeans.getDept_name()+"')";
            Statement st = null;
            st = (Statement) connection.Connect.con.createStatement();
            if (st.executeUpdate(query) == 1) {
                System.out.println("dept inserted");
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
