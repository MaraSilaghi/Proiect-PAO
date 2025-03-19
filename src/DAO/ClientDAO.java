package DAO;

import Clase.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    //instanta unica a clasei
    private static ClientDAO instance;

    //constructor privat, pentru a preveni instantierea din exterior
    private ClientDAO() {}

    public static ClientDAO getInstance() {
        if (instance == null) {
            instance = new ClientDAO();
        }
        return instance;
    }

    public void creeazaClient(Client client) {
        //se creeaza o conexiune la baza de date
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Client (nume, prenume, email) VALUES (?, ?, ?)";
            //pentru a executa query-uri predefinite
            //vrem sa obtinem si cheile generate automat (id-urile) - aici, id-ul clientului curent
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            //index + ce inlocuieste semnul intrebarii
            preparedStatement.setString(1, client.getNume());
            preparedStatement.setString(2, client.getPrenume());
            preparedStatement.setString(3, client.getEmail());
            //executam interogararea sql
            preparedStatement.executeUpdate();
            //preluarea id-urilor
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                client.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client citesteClient(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Client WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //setarea valorii pentru placeholder
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String email = resultSet.getString("email");
                return new Client(id, nume, prenume, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Client> citesteClienti() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Client";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String email = resultSet.getString("email");
                clients.add(new Client(id, nume, prenume, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void updateClient(Client client) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Client SET nume = ?, prenume = ?, email = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, client.getNume());
            preparedStatement.setString(2, client.getPrenume());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setInt(4, client.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stergeClient(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Client WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
