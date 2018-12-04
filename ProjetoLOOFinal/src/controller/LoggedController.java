package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Contas;

public class LoggedController {


    private Contas contaAtual;
    @FXML
    private TextField tfNomeUsuario;

    @FXML
    private TextField tfNomePet;

    @FXML
    private ComboBox combo_especie;
    @FXML
    private ComboBox combo_data;


    public void realizaCadastro() {
        try {


            if(combo_especie.getValue()==null){
                throw new RuntimeException("Por favor selecione um valor para a espécie");
            }
            if(combo_data.getValue()==null){
                throw new RuntimeException("Por favor selecione um valor para a espécie");
            }

            if (tfNomeUsuario.getText().isEmpty()) {
                throw new RuntimeException("O atributo Nome do Usuário não pode ser vazio");
            }
            if (tfNomePet.getText().isEmpty()) {
                throw new RuntimeException("O atributo Nome do Pet não pode ser vazio");
            }
            if(contaAtual!=null) {
                contaAtual.setNomeUsuario(tfNomeUsuario.getText());
                contaAtual.setNomePet(tfNomePet.getText());
                contaAtual.setComboData(combo_data);
                contaAtual.setEspecie(combo_especie);
                contaAtual.save();
            }else {
                Contas c = new Contas(tfNomeUsuario.getText(), tfNomePet.getText(), (ComboBox) combo_especie.getValue(), (ComboBox)combo_data.getValue());
                c.save();

                Main.changeScreen("cadastro");
            }
        } catch (NumberFormatException number) {

        } catch (RuntimeException texto) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Erro de informação no nome");
            alert.setContentText(texto.getMessage());
            alert.showAndWait();
        }

    }

    public void cancelaCadastro() {

        Main.changeScreen("login");
    }

    @FXML
    protected void initialize() {
        combo_especie.getItems().add("Cachorro");
        combo_especie.getItems().add("Gato");
        combo_especie.getItems().add("Lhama");
        combo_especie.getItems().add("Reptiliano");

        combo_data.getItems().add(2018);
        combo_data.getItems().add(2017);
        combo_data.getItems().add(2016);
        combo_data.getItems().add(2015);
        combo_data.getItems().add(2014);
        combo_data.getItems().add(2013);
        combo_data.getItems().add(2012);
        combo_data.getItems().add(2011);
        combo_data.getItems().add(2010);
        combo_data.getItems().add(1842);
        Main.addOnChangeScreenListener(new Main.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData){
                if (newScreen.equals("logged")){
                    if(userData!=null){

                        contaAtual = (Contas)userData;
                        tfNomeUsuario.setText(contaAtual.getNomeUsuario());
                        tfNomePet.setText(contaAtual.getNomePet());
                    }else{
                        contaAtual=null;
                        tfNomeUsuario.setText("");
                        tfNomePet.setText("");
                    }
                }
            }
        });
    }

}
