package Controller;

import Beans.DeptBeans;
import Beans.EmployeeBeans;
import Beans.StudentsBeans;
import ChainOfResponsiblity.AbstractLogger;
import ChainOfResponsiblity.DepartmentLogger;
import ChainOfResponsiblity.EmployeeLogger;
import ChainOfResponsiblity.StudentLogger;
import Factory.PersonFactory;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MainPanelController implements Initializable {

    @FXML
    private TableView<Beans.StudentsBeans> tb_students;
    @FXML
    private TableColumn<?, ?> col_std_id;
    @FXML
    private TableColumn<?, ?> col_std_fname;
    @FXML
    private TableColumn<?, ?> col_std_lname;
    @FXML
    private TableColumn<?, ?> col_std_address;
    @FXML
    private TableColumn<?, ?> col_std_contact;
    @FXML
    private TableColumn<?, ?> col_std_email;
    @FXML
    private TableColumn<?, ?> col_student_doj;
    @FXML
    private TextField field_student_fname;
    @FXML
    private TextField field_student_lname;
    @FXML
    private TextField field_student_address;
    @FXML
    private TextField field_student_contact;
    @FXML
    private TextField field_student_email;
    @FXML
    private Button btn_student_submit;
    @FXML
    private Button btn_student_refresh;
    @FXML
    private TableView<EmployeeBeans> tb_employee;
    @FXML
    private TableColumn<?, ?> col_emp_id;
    @FXML
    private TableColumn<?, ?> col_emp_name;
    @FXML
    private TableColumn<?, ?> col_emp_email;
    @FXML
    private TableColumn<?, ?> col_emp_password;
    @FXML
    private TableColumn<?, ?> col_emp_username;
    @FXML
    private TableColumn<?, ?> col_emp_dept;
    @FXML
    private TableColumn<?, ?> col_emp_address;
    @FXML
    private TextField field_emp_fname;
    @FXML
    private TextField field_emp_email;
    @FXML
    private TextField field_emp_password;
    @FXML
    private TextField field_emp_username;
    @FXML
    private TextField field_emp_address;
    @FXML
    private Button btn_emp_submit;
    @FXML
    private Button btn_emp_refresh;
    @FXML
    private ComboBox<String> combo_emp_dept;
    @FXML
    private TextField field_dept_name;
    public static ObservableList<Beans.StudentsBeans> 
            Students_List = FXCollections.observableArrayList();
    public static ObservableList<Beans.EmployeeBeans> 
            Employee_List = FXCollections.observableArrayList();
    public static ObservableList<Beans.DeptBeans> 
            Dept_List = FXCollections.observableArrayList();
    @FXML
    private TableView<Beans.DeptBeans> tb_dept;
    @FXML
    private Button btn_dept_submit;
    @FXML
    private Button btn_combo_dept_refresh;
    @FXML
    private ComboBox<String> combo_sbd_dept_combo;
    @FXML
    private TableView<Beans.EmployeeBeans> tb_sbd;
    @FXML
    private TableColumn<?, ?> col_sdb_id;
    @FXML
    private TableColumn<?, ?> col_sdb_name;
    @FXML
    private TableColumn<?, ?> col_sdb_email;
    @FXML
    private TableColumn<?, ?> col_sdb_password;
    @FXML
    private TableColumn<?, ?> col_sdb_username;
    @FXML
    private TableColumn<?, ?> col_sdb_address;

    ///////////////////////////////////ChainOfResponsiblity////////////////////////////////////////////////////////////////////////////////
    private static ChainOfResponsiblity.AbstractLogger getChainOfLoggers() {
        AbstractLogger std = new StudentLogger(AbstractLogger.STUDENT);
        AbstractLogger emp = new EmployeeLogger(AbstractLogger.EMPLOYEE);
        AbstractLogger dept = new DepartmentLogger(AbstractLogger.DEPT);
        std.setNextLogger(emp);
        emp.setNextLogger(dept);
        return std;
    }
    AbstractLogger loggerChain = getChainOfLoggers();
    //////////////////////////////////ChainOfResponsiblity End/////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////Factory /////////////////////////////////////////////////////////////////////////////////
    Factory.PersonFactory personFactory = new PersonFactory();
    //////////////////////////////////Factory End/////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Button btn_dept_refresh;
    @FXML
    private TableColumn<?, ?> col_dept_id;
    @FXML
    private TableColumn<?, ?> col_dept_name;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
        initComboDept();

    }
   //////////////////////////////////Students start /////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void tb_students_onclick(MouseEvent event) {
    }

    @FXML
    private void btn_student_submit_onclick(MouseEvent event) {
        Beans.StudentsBeans stdb = new StudentsBeans();
        stdb.setFname(field_student_fname.getText());
        stdb.setLname(field_student_lname.getText());
        stdb.setAddress(field_student_address.getText());
        stdb.setContact(field_student_contact.getText());
        stdb.setEmail(field_student_email.getText());
        
        loggerChain.logMessage(AbstractLogger.STUDENT, "Adding student. ", stdb);

    }

    @FXML
    private void btn_student_refresh_onclick(MouseEvent event) { 
        Factory.Person std = personFactory.getPerson("student");
        std.show(std);
        col_std_fname.setCellValueFactory(new PropertyValueFactory<>("col_fname"));
        col_std_lname.setCellValueFactory(new PropertyValueFactory<>("col_lname"));
        col_std_contact.setCellValueFactory(new PropertyValueFactory<>("col_contact"));;
        col_std_address.setCellValueFactory(new PropertyValueFactory<>("col_address"));
        col_std_email.setCellValueFactory(new PropertyValueFactory<>("col_email"));
        col_std_id.setCellValueFactory(new PropertyValueFactory<>("col_id"));
        col_student_doj.setCellValueFactory(new PropertyValueFactory<>("col_date_of_join"));

        tb_students.setItems(Students_List);
    }
       //////////////////////////////////Students  End/////////////////////////////////////////////////////////////////////////////////

     //////////////////////////////////Emp  Start/////////////////////////////////////////////////////////////////////////////////


    @FXML
    private void tb_employee_onclick(MouseEvent event) {

    }

    @FXML
    private void btn_emp_submit_onclick(MouseEvent event) {

        Beans.EmployeeBeans etdb = new EmployeeBeans();
        String deptId = combo_emp_dept.getValue().split(" - ")[0];
        etdb.setName(field_emp_fname.getText());
        etdb.setEmail(field_emp_email.getText());
        etdb.setPassword(field_emp_password.getText());
        etdb.setUsername(field_emp_username.getText());
        etdb.setAddress(field_emp_address.getText());
        etdb.setDept(deptId);

        loggerChain.logMessage(AbstractLogger.EMPLOYEE, "Adding Employee. ", etdb);
    }

    @FXML
    private void btn_emp_refresh_onclick(MouseEvent event) {

        Factory.Person std = personFactory.getPerson("employee");
        std.show(std);

        col_emp_email.setCellValueFactory(new PropertyValueFactory<>("col_email"));
        col_emp_name.setCellValueFactory(new PropertyValueFactory<>("col_name"));
        col_emp_address.setCellValueFactory(new PropertyValueFactory<>("col_address"));;
        col_emp_username.setCellValueFactory(new PropertyValueFactory<>("col_username"));
        col_emp_dept.setCellValueFactory(new PropertyValueFactory<>("col_dept_name"));
        col_emp_password.setCellValueFactory(new PropertyValueFactory<>("col_password"));
        col_emp_id.setCellValueFactory(new PropertyValueFactory<>("col_id"));

        tb_employee.setItems(Employee_List);

    }

    void initComboDept() {
        combo_emp_dept.getItems().clear();
        String query = "SELECT * FROM `tb_dept`  ";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = (Statement) connection.Connect.con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                combo_emp_dept.getItems().add(String.valueOf(rs.getInt("id")) + " - " + rs.getString("dept_name"));
            }
            combo_emp_dept.getSelectionModel().selectFirst();
        } catch (SQLException ex) {
            Logger.getLogger(MainPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   //////////////////////////////////Emp  End/////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void tb_dept_onclick(MouseEvent event) {
    }

    @FXML
    private void btn_dept_submit_onclick(MouseEvent event) {
        Beans.DeptBeans deptb = new DeptBeans();
        deptb.setDept_name(field_dept_name.getText());

        loggerChain.logMessage(AbstractLogger.DEPT, "Adding Dept. ", deptb);
    }

    @FXML
    private void btn_combo_dept_refresh_onclick(MouseEvent event) {
        initComboDept();
    }

    void init() {
        //////////////////////////////////Composite  Start/////////////////////////////////////////////////////////////////////////////////

        ArrayList<Beans.DeptBeans> dbeansList = new ArrayList<Beans.DeptBeans>();
        combo_sbd_dept_combo.getItems().clear();
        String query = "SELECT * FROM `tb_dept`  ";
        Statement st = null;
        ResultSet rs = null;
        Beans.DeptBeans dbeans;

        try {
            st = (Statement) connection.Connect.con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                dbeans = new DeptBeans();
                dbeans.empList = FXCollections.observableArrayList();
                combo_sbd_dept_combo.getItems().add(String.valueOf(rs.getInt("id")) + " - " + rs.getString("dept_name"));
                dbeans.setId(String.valueOf(rs.getInt("id")));
                dbeans.setDept_name(rs.getString("dept_name"));
                String queryE = "SELECT e.*,d.dept_name AS dept_name FROM `tb_employee` e LEFT JOIN tb_dept d ON e.dept=d.id WHERE e.dept= " + dbeans.getId() + " ;";
                Statement ste = null;
                ResultSet rse = null;
                Beans.EmployeeBeans ebeans = new EmployeeBeans();
                try {
                    ste = (Statement) connection.Connect.con.createStatement();
                    rse = ste.executeQuery(queryE);
                    while (rse.next()) {
                        ebeans = new Beans.EmployeeBeans();
                        ebeans.setCol_id(String.valueOf(rse.getInt("id")));
                        ebeans.setCol_name(rse.getString("name").substring(0, 1).toUpperCase() + rse.getString("name").substring(1));
                        ebeans.setCol_address(rse.getString("address").substring(0, 1).toUpperCase() + rse.getString("address").substring(1));
                        ebeans.setCol_email(rse.getString("email").substring(0, 1).toUpperCase() + rse.getString("email").substring(1));
                        ebeans.setCol_password(rse.getString("password").substring(0, 1).toUpperCase() + rse.getString("password").substring(1));
                        ebeans.setCol_username(rse.getString("username").substring(0, 1).toUpperCase() + rse.getString("username").substring(1));
                        ebeans.setCol_dept_name(rse.getString("dept_name").substring(0, 1).toUpperCase() + rse.getString("dept_name").substring(1));
                        ebeans.setDept(String.valueOf(rse.getInt("dept")));
                        dbeans.add(ebeans);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MainPanelController.class.getName()).log(Level.SEVERE, null, ex);
                }
                dbeansList.add(dbeans);

            }
            combo_sbd_dept_combo.getSelectionModel().selectFirst();
        } catch (SQLException ex) {
            Logger.getLogger(MainPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }

        combo_sbd_dept_combo.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String val) {
                col_sdb_email.setCellValueFactory(new PropertyValueFactory<>("col_email"));
                col_sdb_name.setCellValueFactory(new PropertyValueFactory<>("col_name"));
                col_sdb_address.setCellValueFactory(new PropertyValueFactory<>("col_address"));;
                col_sdb_username.setCellValueFactory(new PropertyValueFactory<>("col_username"));
                col_sdb_password.setCellValueFactory(new PropertyValueFactory<>("col_password"));
                col_sdb_id.setCellValueFactory(new PropertyValueFactory<>("col_id"));
                tb_sbd.setItems(dbeansList.get(combo_sbd_dept_combo.getSelectionModel().getSelectedIndex()).empList());
            }
        });
           //////////////////////////////////Composite  End/////////////////////////////////////////////////////////////////////////////////
    }

    @FXML
    private void tb_sbd_onclick(MouseEvent event) {

    }

    @FXML
    private void btn_dept_refresh_onclick(MouseEvent event) {
          Factory.Person dept = personFactory.getPerson("dept");
        dept.show(dept);
        col_dept_id.setCellValueFactory(new PropertyValueFactory<>("col_id"));
        col_dept_name.setCellValueFactory(new PropertyValueFactory<>("col_dept_name")); 

        tb_dept.setItems(Dept_List);
    }
}
