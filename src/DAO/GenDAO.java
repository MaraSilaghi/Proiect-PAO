package DAO;

import Clase.Gen;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenDAO {
    private static GenDAO instance;

    private GenDAO() {}

    public static GenDAO getInstance() {
        if (instance == null) {
            instance = new GenDAO();
        }
        return instance;
    }

    public void creeazaGen(Gen gen) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Gen (nume, descriere) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, gen.getNume());
            preparedStatement.setString(2, gen.getDescriere());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                gen.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Gen citesteGen(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Gen WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String descriere = resultSet.getString("descriere");
                return new Gen(id, nume, descriere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Gen> citesteGenuri() {
        List<Gen> genuri = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Gen";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nume = resultSet.getString("nume");
                String descriere = resultSet.getString("descriere");
                genuri.add(new Gen(id, nume, descriere));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genuri;
    }

    public void updateGen(Gen gen) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Gen SET nume = ?, descriere = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gen.getNume());
            preparedStatement.setString(2, gen.getDescriere());
            preparedStatement.setInt(3, gen.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stergeGen(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Gen WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
