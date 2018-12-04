package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML private PasswordField tfSenha;
    @FXML private TextField tfConta;
    @FXML private Button btnEntrar;



    public void entrarConta(ActionEvent e) {

        if(tfConta.getText().equals("admin") && tfSenha.getText().equals("admin")){
            Main.changeScreen("admin", null);
        }

        else {
            if(tfConta.getText().equals("matheus")&&tfSenha.getText().equals("123")) {
                Main.changeScreen("logged", null);
            }else{

                if(!tfConta.getText().equals("matheus")){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERRO");
                    alert.setHeaderText("Erro de Login!");
                    alert.setContentText("O login digitado no campo de usuário está incorreto!");
                    alert.showAndWait();
                }else{
                    if(!tfSenha.getText().equals("123")){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERRO");
                        alert.setHeaderText("Erro de Senha!");
                        alert.setContentText("A senha digitada no campo de senha está incorreta!");
                        alert.showAndWait();
                    }
                }
            }
        }
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        assert btnEntrar != null : "fx:id=\"btnEntrar\" was not injected: check your FXML file 'LoginScreen.fxml'.";
        assert tfConta != null : "fx:id=\"tfConta\" was not injected: check your FXML file 'LoginScreen.fxml'.";
        assert tfSenha != null : "fx:id=\"tfPassword\" was not injected: check your FXML file 'LoginScreen.fxml'.";

    }
}
