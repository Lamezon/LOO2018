package model;

import javafx.scene.control.ComboBox;
import model.SQLiteDAO.ContasSQLiteDAO;

import java.util.List;

public class Contas {
    private Integer id_Contas;
    private String nomeUsuario;
    private String nomePet;
    private ComboBox combo_especie;
    private ComboBox combo_data;


    public Contas(int id_Contas, String nomeUsuario, String nomePet, ComboBox combo_especie, ComboBox combo_data) {
        this.id_Contas = id_Contas;
        this.nomeUsuario = nomeUsuario;
        this.nomePet = nomePet;
        this.combo_especie = combo_especie;
        this.combo_data = combo_especie;
    }

    public Contas(String nomeUsuario, String nomePet, ComboBox combo_especie, ComboBox combo_data) {
        this.nomeUsuario = nomeUsuario;
        this.nomePet = nomePet;
        this.combo_especie = combo_especie;
        this.combo_data = combo_data;
    }



    public ComboBox getEspecie() {

        return combo_especie;
    }

    public void setEspecie(ComboBox especie) {
        this.combo_especie = combo_especie;
    }

    public ComboBox getComboData() {
        return combo_data;
    }

    public void setComboData(ComboBox comboData) {
        this.combo_data = comboData;
    }


    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public int getId() {
        return id_Contas;
    }

    @Override
    public String toString() {
        return id_Contas + "\t\t\t\t" + getNomeUsuario() + "\t\t\t\t\t" + getNomePet() + "\t\t\t\t   " + getEspecie() +
                "\t\t\t\t\t\t"+ getComboData();
    }

    private static ContasSQLiteDAO dao = new ContasSQLiteDAO();


    public void save() {
        if (id_Contas!=null && dao.find(id_Contas) != null) {
            dao.update(this);
        } else {
            dao.create(this);
        }


    }

    public void delete() {
        if (dao.find(id_Contas) != null) {
            dao.delete(this);
        }

    }

    public static List<Contas> all() {
        return dao.all();
    }
}
