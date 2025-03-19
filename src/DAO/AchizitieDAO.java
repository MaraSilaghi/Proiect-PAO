package DAO;

import Clase.Achizitie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AchizitieDAO {
    private static AchizitieDAO instance;

    private AchizitieDAO() {}

    public static AchizitieDAO getInstance() {
        if (instance == null) {
            instance = new AchizitieDAO();
        }
        return instance;
    }

    public void creeazaAchizitie(Achizitie achizitie) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Achizitie (idClient, idJoc, dataAchizitie, pret) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, achizitie.getIdClient());
            preparedStatement.setInt(2, achizitie.getIdJoc());
            preparedStatement.setString(3, achizitie.getDataAchizitie());
            preparedStatement.setDouble(4, achizitie.getPret());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                achizitie.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Achizitie citesteAchizitie(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Achizitie WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int idClient = resultSet.getInt("idClient");
                int idJoc = resultSet.getInt("idJoc");
                String dataAchizitie = resultSet.getString("dataAchizitie");
                double pret = resultSet.getDouble("pret");
                return new Achizitie(id, idClient, idJoc, dataAchizitie, pret);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Achizitie> citesteAchizitii() {
        List<Achizitie> achizitii = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Achizitie";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idClient = resultSet.getInt("idClient");
                int idJoc = resultSet.getInt("idJoc");
                String dataAchizitie = resultSet.getString("dataAchizitie");
                double pret = resultSet.getDouble("pret");
                achizitii.add(new Achizitie(id, idClient, idJoc, dataAchizitie, pret));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return achizitii;
    }

    public void updateAchizitie(Achizitie achizitie) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Achizitie SET idClient = ?, idJoc = ?, dataAchizitie = ?, pret = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, achizitie.getIdClient());
            preparedStatement.setInt(2, achizitie.getIdJoc());
            preparedStatement.setString(3, achizitie.getDataAchizitie());
            preparedStatement.setDouble(4, achizitie.getPret());
            preparedStatement.setInt(5, achizitie.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stergeAchizitie(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Achizitie WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
