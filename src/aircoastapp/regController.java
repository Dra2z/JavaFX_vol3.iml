package aircoastapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class regController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpName;

    @FXML
    private Button registerButton;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpLogin;

    @FXML
    private TextField signUpPass;

    @FXML
    private TextField signUpEmail;


    @FXML
    void initialize() {


        registerButton.setOnAction(event -> {

                    signUpNewUser();

                });


    }

    private void signUpNewUser() {
        DataBaseConnector dbConnector = new DataBaseConnector();

        String firstName = signUpName.getText();
        String lastName = signUpLastName.getText();
        String loginName = signUpLogin.getText();
        String passwordUser = signUpPass.getText();
        String emailUser = signUpEmail.getText();

        Users users = new Users(firstName, lastName, loginName, passwordUser, emailUser);

        dbConnector.signUpUser(users);
    }
}
