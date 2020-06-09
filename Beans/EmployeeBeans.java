package Beans;

import javafx.beans.property.SimpleStringProperty;

public class EmployeeBeans {

    private String id, name, email, address, username, dept, password, dept_name;
    private SimpleStringProperty col_id, col_name, col_email, col_address, col_username, col_dept, col_password,col_dept_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    
    
    
    
    
    ////////////////////

    public String getCol_id() {
        return col_id.get();
    }

    public void setCol_id(String col_id) {
        this.col_id =new  SimpleStringProperty(col_id);
    }

    public String getCol_name() {
        return col_name.get();
    }

    public void setCol_name(String col_name) {
        this.col_name =new SimpleStringProperty (col_name);
    }

    public String getCol_email() {
        return col_email.get();
    }

    public void setCol_email(String col_email) {
        this.col_email =new  SimpleStringProperty(col_email);
    }

    public String getCol_address() {
        return col_address.get();
    }

    public void setCol_address(String col_address) {
        this.col_address =new SimpleStringProperty( col_address);
    }

    public String getCol_username() {
        return col_username.get();
    }

    public void setCol_username(String col_username) {
        this.col_username = new  SimpleStringProperty(col_username);
    }

    public String getCol_dept() {
        return col_dept.get();
    }

    public void setCol_dept(String col_dept) {
        this.col_dept = new SimpleStringProperty(col_dept);
    }

    public String getCol_password() {
        return col_password.get();
    }

    public void setCol_password(String col_password) {
        this.col_password =new SimpleStringProperty( col_password);
    }

    public String getCol_dept_name() {
        return col_dept_name.get();
    }

    public void setCol_dept_name(String col_dept_name) {
        this.col_dept_name = new SimpleStringProperty (col_dept_name);
    }
             
}
