
package Beans;
 
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class DeptBeans {

    String id, dept_name;
    SimpleStringProperty col_id, col_dept_name;
    
    public ObservableList<Beans.EmployeeBeans> empList;

    public void add(Beans.EmployeeBeans e) {
        empList.add(e);
    }

    public void remove(Beans.EmployeeBeans e) {
        empList.remove(e);
    }

    public ObservableList<Beans.EmployeeBeans> empList() {
        return empList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getCol_id() {
        return col_id.get();
    }

    public void setCol_id(String col_id) {
        this.col_id = new SimpleStringProperty(col_id);
    }

    public String getCol_dept_name() {
        return col_dept_name.get();
    }

    public void setCol_dept_name(String col_dept_name) {
        this.col_dept_name = new SimpleStringProperty(col_dept_name);
    }
    

}
