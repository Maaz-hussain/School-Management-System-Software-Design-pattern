 
package Factory;

import Singleton.SingletonClass;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeClass implements Person{
    
    @Override
    public void show(Object obj) {
        // Beans.StudentsBeans sbeans=(StudentsBeans) obj;
        List<Beans.EmployeeBeans> ubArray = new ArrayList<>();
        String query = "SELECT e.*,d.dept_name AS dept_name FROM `tb_employee` e LEFT JOIN tb_dept d ON e.dept=d.id ";
        System.out.println("" + query);
        Statement st = null;
        ResultSet rs = null;
        Beans.EmployeeBeans ebeans;
        //        System.out.println(""+query);
        try {
            st = (Statement) connection.Connect.con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ebeans = new Beans.EmployeeBeans();
                ebeans.setCol_id(String.valueOf(rs.getInt("id")));
                ebeans.setCol_name(rs.getString("name").substring(0, 1).toUpperCase() + rs.getString("name").substring(1));
                ebeans.setCol_address(rs.getString("address").substring(0, 1).toUpperCase() + rs.getString("address").substring(1));
                ebeans.setCol_email(rs.getString("email").substring(0, 1).toUpperCase() + rs.getString("email").substring(1));
                ebeans.setCol_password(rs.getString("password").substring(0, 1).toUpperCase() + rs.getString("password").substring(1));
                ebeans.setCol_username(rs.getString("username").substring(0, 1).toUpperCase() + rs.getString("username").substring(1));
                ebeans.setCol_dept_name(rs.getString("dept_name").substring(0, 1).toUpperCase() + rs.getString("dept_name").substring(1));
                ebeans.setDept(String.valueOf(rs.getInt("dept")));  
                ubArray.add(ebeans);
            }
            Controller.MainPanelController.Employee_List.clear();
            ObservableList<Beans.EmployeeBeans> data = FXCollections.observableArrayList(ubArray);
            Controller.MainPanelController.Employee_List = data;
        } catch (SQLException ex) {
            Logger.getLogger(SingletonClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

  
