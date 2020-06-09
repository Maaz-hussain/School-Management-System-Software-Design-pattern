package Singleton;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SingletonClass {


    private static SingletonClass instance = new SingletonClass();

    private SingletonClass() {
    }


    public static SingletonClass getInstance() {
        return instance;
    }

    public ObservableList<Beans.EmployeeBeans> loginVerifier(Beans.EmployeeBeans empBeans) { 
        List<Beans.EmployeeBeans> ubArray = new ArrayList<>();
        String query = "SELECT * FROM `tb_employee` WHERE name='"+empBeans.getName()+"' AND password='"+empBeans.getPassword()+"' LIMIT 1";
         System.out.println(""+query);
        Statement st = null;
        ResultSet rs = null;
        Beans.EmployeeBeans eBeans;
        try {
            st = (Statement) connection.Connect.con.createStatement();
            rs = st.executeQuery(query); 
            while (rs.next()) {
                eBeans = new Beans.EmployeeBeans();
                eBeans.setName(rs.getString("name").substring(0, 1).toUpperCase() + rs.getString("name").substring(1));
                eBeans.setId(String.valueOf(rs.getInt("id"))); 
                ubArray.add(eBeans); 
            }
            ObservableList<Beans.EmployeeBeans> data = FXCollections.observableArrayList(ubArray);
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(SingletonClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
}
