package DAO;

import Clase.Promotie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromotieDAO {
    private static PromotieDAO instance;

    private PromotieDAO() {}

    public static PromotieDAO getInstance() {
        if (instance == null) {
            instance = new PromotieDAO();
        }
        return instance;
    }

    public void creeazaPromotie(Promotie promotie) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Promotie (nume, descriere, procentReducere, dataInceput, dataSfarsit, numeJoc) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, promotie.getNume());
            preparedStatement.setString(2, promotie.getDescriere());
            preparedStatement.setInt(3, promotie.getProcentReducere());
            preparedStatement.setString(4, promotie.getDataInceput());
            preparedStatement.setString(5, promotie.getDataSfarsit());
            preparedStatement.setString(6, promotie.getNumeJoc());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                promotie.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Promotie citestePromotie(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Promotie WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String descriere = resultSet.getString("descriere");
                int procentReducere = resultSet.getInt("procentReducere");
                String dataInceput = resultSet.getString("dataInceput");
                String dataSfarsit = resultSet.getString("dataSfarsit");
                String numeJoc = resultSet.getString("numeJoc");
                return new Promotie(id, nume, descriere, procentReducere, dataInceput, dataSfarsit, numeJoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Promotie> citestePromotii() {
        List<Promotie> promotii = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Promotie";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nume = resultSet.getString("nume");
                String descriere = resultSet.getString("descriere");
                int procentReducere = resultSet.getInt("procentReducere");
                String dataInceput = resultSet.getString("dataInceput");
                String dataSfarsit = resultSet.getString("dataSfarsit");
                String numeJoc = resultSet.getString("numeJoc");
                promotii.add(new Promotie(id, nume, descriere, procentReducere, dataInceput, dataSfarsit, numeJoc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotii;
    }

    public void updatePromotie(Promotie promotie) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Promotie SET nume = ?, descriere = ?, procentReducere = ?, dataInceput = ?, dataSfarsit = ?, numeJoc = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, promotie.getNume());
            preparedStatement.setString(2, promotie.getDescriere());
            preparedStatement.setInt(3, promotie.getProcentReducere());
            preparedStatement.setString(4, promotie.getDataInceput());
            preparedStatement.setString(5, promotie.getDataSfarsit());
            preparedStatement.setString(6, promotie.getNumeJoc());
            preparedStatement.setInt(7, promotie.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stergePromotie(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Promotie WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
