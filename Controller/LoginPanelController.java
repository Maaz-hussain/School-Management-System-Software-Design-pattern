package Controller;

import Beans.EmployeeBeans;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginPanelController extends Application implements Initializable {

    Scene scene;
    Screen screen = Screen.getPrimary();
    javafx.geometry.Rectangle2D bounds = screen.getBounds();

    public static void main(String[] args) {
        connection.Connect.connects();

        launch(args);
    }
    @FXML
    private AnchorPane panee;
    @FXML
    private AnchorPane pane_credetnials;
    @FXML
    private Button btn_login;
    @FXML
    private TextField field_username;
    @FXML
    private Label lbl_err;
    @FXML
    private PasswordField field_password;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/LoginPanel.fxml"));
        scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("School Management Sys");
        stage.setScene(scene);
        stage.show();
        stage.toFront();
        stage.setMinWidth(bounds.getWidth()/2);
        stage.setMinHeight(bounds.getHeight()/2);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            lbl_err.setVisible(false);
 
    }

    @FXML
    private void btn_login_onclick(MouseEvent event) {
        Singleton.SingletonClass object = Singleton.SingletonClass.getInstance();
        Beans.EmployeeBeans ebeans = new EmployeeBeans();
        ebeans.setName(field_username.getText());
        ebeans.setPassword(field_password.getText());
        if(!(object.loginVerifier(ebeans).isEmpty())){
            
            loadUI("MainPanel"); 
        }else{
            lbl_err.setVisible(true);
        lbl_err.setText("Wrong Credentials! Please Try Again.");
        }
    }
 
    void loadUI(String ui) {
        try {
            AnchorPane pnlOne = FXMLLoader.load(this.getClass().getResource("/Views/" + ui + ".fxml"));
            panee.getChildren().setAll(pnlOne);
        } catch (IOException ex) {
            Logger.getLogger(LoginPanelController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
