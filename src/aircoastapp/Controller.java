package aircoastapp;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enteredButton;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button registredButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField enteredDate_field;

    @FXML
    private TextField outDate_field;

    @FXML
    private TextField insideFly_field;

    @FXML
    private TextField outFly_field;

    @FXML
    private TextField humanS_field;

    @FXML
    void initialize() {
        enteredButton.setOnAction(event -> {
            String loginName = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();

            if(!loginName.equals("") && !loginPassword.equals("")) {
                loginUser(loginName, loginPassword);
            }else
                System.out.println("Entered name and password");
        });

        registredButton.setOnAction(event -> {
            registredButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/aircoastapp/reg.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent load = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(load));
            stage.showAndWait();
        });
    }

    private void loginUser(String loginName, String loginPassword) {

        DataBaseConnector dbConnector = new DataBaseConnector();
        Users users = new Users();
        users.setLoginName(loginName);
        users.setPasswordUser(loginPassword);
        ResultSet result =  dbConnector.getUsers(users);

        int count = 0;

        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            count++;
        }
        if (count >= 1) {
            System.out.println("Created");
        }
    }
}
