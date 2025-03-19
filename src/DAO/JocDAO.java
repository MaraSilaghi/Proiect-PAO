package DAO;

import Clase.Joc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JocDAO {
    private static JocDAO instance;

    private JocDAO() {}

    public static JocDAO getInstance() {
        if (instance == null) {
            instance = new JocDAO();
        }
        return instance;
    }

    public void creeazaJoc(Joc joc) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Joc (titlu, idGen, creator, pret, disponibil) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, joc.getTitlu());
            preparedStatement.setInt(2, joc.getIdGen());
            preparedStatement.setString(3, joc.getCreator());
            preparedStatement.setDouble(4, joc.getPret());
            preparedStatement.setBoolean(5, joc.isDisponibil());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                joc.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Joc citesteJoc(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Joc WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String titlu = resultSet.getString("titlu");
                int idGen = resultSet.getInt("idGen");
                String creator = resultSet.getString("creator");
                double pret = resultSet.getDouble("pret");
                boolean disponibil = resultSet.getBoolean("disponibil");
                return new Joc(id, titlu, idGen, creator, pret, disponibil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Joc> citesteJocuri() {
        List<Joc> jocuri = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Joc";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titlu = resultSet.getString("titlu");
                int idGen = resultSet.getInt("idGen");
                String creator = resultSet.getString("creator");
                double pret = resultSet.getDouble("pret");
                boolean disponibil = resultSet.getBoolean("disponibil");
                jocuri.add(new Joc(id, titlu, idGen, creator, pret, disponibil));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jocuri;
    }

    public void updateJoc(Joc joc) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Joc SET titlu = ?, idGen = ?, creator = ?, pret = ?, disponibil = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, joc.getTitlu());
            preparedStatement.setInt(2, joc.getIdGen());
            preparedStatement.setString(3, joc.getCreator());
            preparedStatement.setDouble(4, joc.getPret());
            preparedStatement.setBoolean(5, joc.isDisponibil());
            preparedStatement.setInt(6, joc.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stergeJoc(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Joc WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
