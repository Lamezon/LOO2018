package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Contas;
import javafx.scene.control.ListView;
import java.util.Optional;

public class AdministradorController {


    @FXML
    protected ListView<Contas> lvLista;



    @FXML
    protected void initialize(){
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if(newScreen.equals("admin")){
                    updateList();
                }
            }
        });
        updateList();
    }

    private void updateList(){
        lvLista.getItems().clear();
        for(Contas c : Contas.all()){
            lvLista.getItems().add(c);

        }
    }

    @FXML
    protected void deletaItem() {
        ObservableList<Contas> ol = lvLista.getSelectionModel().getSelectedItems();
        if (!ol.isEmpty()) {
            Contas c = ol.get(0);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Deseja deletar o item selecionado?");
            alert.setContentText("Você está prestes a deleta o seguinte item: " + c.toString());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                c.delete();
                updateList();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Informação");
            alert.setHeaderText("Nenhuma conta selecionada :(");
            alert.setContentText("Selecione algum item da lista para fazer a remoção.");
            alert.showAndWait();
        }
    }
    @FXML
    protected void editaItem() {
        ObservableList<Contas> ol = lvLista.getSelectionModel().getSelectedItems();
        if (!ol.isEmpty()) {

            Contas c = ol.get(0);
            Main.changeScreen("logged", c);
        }

    }
    public void sairTela(){

        Main.changeScreen("login");
    }
}
