package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private static Stage stage;
    private static Scene loginScene;
    private static Scene LoggedScene;
    private static Scene AdminScene;
    private static Scene CadastroScene;
    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;
        primaryStage.setTitle("Trabalho LOO");
        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("../view/LoginScreen.fxml"));
        loginScene = new Scene (fxmlLogin, 640, 400);
        Parent fxmlLogged = FXMLLoader.load(getClass().getResource("../view/LoggedScreen.fxml"));
        LoggedScene = new Scene (fxmlLogged, 640, 400);
        Parent fxmlAdmin = FXMLLoader.load(getClass().getResource("../view/AdministradorScreen.fxml"));
        AdminScene = new Scene (fxmlAdmin, 640, 400);
        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("../view/CadastroCompleto.fxml"));
        CadastroScene = new Scene (fxmlCadastro, 640, 400);


        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void changeScreen(String scr, Object userData){
        switch (scr){
            case "login":
                stage.setScene(loginScene);
                notifyAllListeners("login", userData );
                break;
            case "logged":
                stage.setScene(LoggedScene);
                notifyAllListeners("logged", userData );
                break;
            case "admin":
                stage.setScene(AdminScene);
                notifyAllListeners("admin", userData );
                break;
            case "cadastro":
                stage.setScene(CadastroScene);
                notifyAllListeners("cadastro", userData );
                break;
        }
    }

    public static void changeScreen(String scr){
        changeScreen(scr, null);
    }


    public static void main(String[] args) {
        launch(args);
    }

    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen{
        void onScreenChanged(String newScreen, Object userData);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Object userData){
        for(OnChangeScreen l:listeners)
            l.onScreenChanged(newScreen, userData);

    }

}
