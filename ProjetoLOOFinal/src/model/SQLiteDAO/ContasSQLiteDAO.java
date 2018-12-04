package model.SQLiteDAO;

import javafx.fxml.FXML;
import model.Contas;
import javafx.scene.control.ComboBox;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContasSQLiteDAO extends SQLiteBase {
    public ContasSQLiteDAO() {
        open();
        try {
            PreparedStatement stm = conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS Contas (id_Contas INTEGER  PRIMARY KEY AUTOINCREMENT,"
                            + "nome_usuario TEXT," + "nome_pet TEXT," + "combo_especie TEXT,"+" combo_data TEXT);");
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void create(Contas c) {
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Contas(nome_usuario, nome_pet, combo_especie, combo_data) VALUES(?,?,?,?)");
            stm.setString(1, c.getNomeUsuario());
            stm.setString(2, c.getNomeUsuario());
            stm.setString(3, String.valueOf(c.getEspecie()));
            stm.setString(4, String.valueOf(c.getComboData()));

            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           close();
        }
    }

    public List<Contas> all() {
        ArrayList<Contas> result = new ArrayList<>();
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Contas ORDER BY id_Contas ASC;");

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Contas c= new Contas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                result.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result;

    }

    public void update(Contas c) {
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("UPDATE Contas SET " +
                    "nome_usuario = ?," + "nome_pet = ?,"
                    + "combo_especie = ?" + "combo_data" + " WHERE id_Contas = ?;");
            stm.setString(1, c.getNomeUsuario());
            stm.setString(2, c.getNomePet());
            stm.setObject(3, c.getEspecie());
            stm.setObject(4, c.getComboData());
            stm.setInt(5, c.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void delete(Contas c) {
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("DELETE FROM Contas WHERE id_Contas = ?;");
            stm.setInt(1, c.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public Contas find(int pk) {
        Contas result = null;
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Contas WHERE id_Contas = ?;");

            stm.setInt(1, pk);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Contas c = new Contas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                result = c;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }


}