/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class DeptClass  implements Person {

    @Override
    public void show(Object obj) { 
        List<Beans.DeptBeans> ubArray = new ArrayList<>();
        String query = "SELECT * FROM `tb_dept` "; 
        Statement st = null;
        ResultSet rs = null;
        Beans.DeptBeans dbeans; 
        try {
            st = (Statement) connection.Connect.con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                dbeans = new Beans.DeptBeans();
                dbeans.setCol_id(String.valueOf(rs.getInt("id"))); 
                dbeans.setCol_dept_name(rs.getString("dept_name").substring(0, 1).toUpperCase() + rs.getString("dept_name").substring(1));  
                ubArray.add(dbeans);
            }
            Controller.MainPanelController.Dept_List.clear();
            ObservableList<Beans.DeptBeans> data = FXCollections.observableArrayList(ubArray);
            Controller.MainPanelController.Dept_List = data;
        } catch (SQLException ex) {
            Logger.getLogger(SingletonClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
