package Factory;

import Beans.StudentsBeans;
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

public class StudentsClass implements Person {

    @Override
    public void show(Object obj) { 
        List<Beans.StudentsBeans> ubArray = new ArrayList<>();
        String query = "SELECT * FROM `tb_student` ";
        System.out.println("" + query);
        Statement st = null;
        ResultSet rs = null;
        Beans.StudentsBeans sbeans;
        //        System.out.println(""+query);
        try {
            st = (Statement) connection.Connect.con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                sbeans = new Beans.StudentsBeans();
                sbeans.setCol_id(String.valueOf(rs.getInt("id")));
                sbeans.setCol_fname(rs.getString("fname").substring(0, 1).toUpperCase() + rs.getString("fname").substring(1));
                sbeans.setCol_lname(rs.getString("lname").substring(0, 1).toUpperCase() + rs.getString("lname").substring(1));
                sbeans.setCol_address(rs.getString("address").substring(0, 1).toUpperCase() + rs.getString("address").substring(1));
                sbeans.setCol_contact(rs.getString("contact").substring(0, 1).toUpperCase() + rs.getString("contact").substring(1));
                sbeans.setCol_email(rs.getString("email").substring(0, 1).toUpperCase() + rs.getString("email").substring(1));
                sbeans.setCol_date_of_join(rs.getString("date_of_join"));

                ubArray.add(sbeans);
            }
            Controller.MainPanelController.Students_List.clear();
            ObservableList<Beans.StudentsBeans> data = FXCollections.observableArrayList(ubArray);
            Controller.MainPanelController.Students_List = data;
        } catch (SQLException ex) {
            Logger.getLogger(SingletonClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
