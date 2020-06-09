 package Beans;

import javafx.beans.property.SimpleStringProperty;

 public class StudentsBeans {
     private String id,fname,lname,address,contact,email,date_of_join;
     private SimpleStringProperty col_id,col_fname,col_lname,col_address,col_contact,col_email,col_date_of_join;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_of_join() {
        return date_of_join;
    }

    public void setDate_of_join(String date_of_join) {
        this.date_of_join = date_of_join;
    }

    public String getCol_id() {
        return col_id.get();
    }

    public void setCol_id(String col_id) {
        this.col_id = new SimpleStringProperty(col_id);
    }

    public String getCol_fname() {
        return col_fname.get();
    }

    public void setCol_fname(String col_fname) {
        this.col_fname = new SimpleStringProperty(col_fname);
    }

    public String getCol_lname() {
        return col_lname.get();
    }

    public void setCol_lname(String col_lname) {
        this.col_lname =new SimpleStringProperty( col_lname);
    }

    public String getCol_address() {
        return col_address.get();
    }

    public void setCol_address(String col_address) {
        this.col_address =new SimpleStringProperty( col_address);
    }

    public String getCol_contact() {
        return col_contact.get();
    }

    public void setCol_contact(String col_contact) {
        this.col_contact = new SimpleStringProperty(col_contact);
    }

    public String getCol_email() {
        return col_email.get();
    }

    public void setCol_email(String col_email) {
        this.col_email = new SimpleStringProperty(col_email);
    }

    public String getCol_date_of_join() {
        return col_date_of_join.get();
    }

    public void setCol_date_of_join(String col_date_of_join) {
        this.col_date_of_join = new SimpleStringProperty(col_date_of_join);
    }
     
     
}
