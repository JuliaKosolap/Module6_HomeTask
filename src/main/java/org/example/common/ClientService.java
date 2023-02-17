package org.example.common;

import org.example.entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private Connection connection;
    private PreparedStatement createSt;
    private PreparedStatement readByIdSt;
    private PreparedStatement updateNameSt;
    private PreparedStatement deleteSt;
    private PreparedStatement readAllSt;

    public ClientService() {
        try {
            connection = Database.getConnection();
            createSt = connection.prepareStatement("INSERT INTO client (id, name) VALUES (?, ?)");
            readByIdSt = connection.prepareStatement("SELECT name FROM client WHERE id = ?");
            updateNameSt = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?");
            deleteSt = connection.prepareStatement("DELETE FROM client WHERE id = ?");
            readAllSt = connection.prepareStatement("SELECT * from client");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long create(String name) {
        long newId = 0;
        try {
            if (name.length() > 2 && name.length() < 1000) {
                long maxId = getMaxId(connection);
                newId = maxId + 1;
                Client client = new Client(newId, name);
                createSt.setLong(1, client.getId());
                createSt.setString(2, client.getName());
                createSt.executeUpdate();
            } else {
                System.out.println("Provided name is invalid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newId;
    }
    public String getById(long id) {
        String name = null;
        long maxId = getMaxId(connection);
        if (id <= maxId) {
            try {
                readByIdSt.setLong(1, id);
                ResultSet resultSet = readByIdSt.executeQuery();
                while (resultSet.next()) {
                    name = resultSet.getString("name");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("id: " + id + " not found");
        }
        return name;
    }
    public void setName(long id, String name) {
        long maxId = getMaxId(connection);
        try {
            if (name.length() > 2 && name.length() < 1000 && id <= maxId) {
                updateNameSt.setString(1, name);
                updateNameSt.setLong(2, id);
                updateNameSt.executeUpdate();
            } else {
                System.out.println("Provided name is invalid or id was not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteById(long id) {
        long maxId = getMaxId(connection);
        try {
            if (id <= maxId) {
                deleteSt.setLong(1, id);
                deleteSt.executeUpdate();
            } else {
                System.out.println("id: " + id + " not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Client> listAll() {
        List<Client> list = new ArrayList<>();
        try {

            ResultSet resultSet = readAllSt.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Client client = new Client(id, name);
                list.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    private long getMaxId(Connection connection) {
        long maxId = 0;
        try {
            Statement readByMaxId = connection.createStatement();
            ResultSet resultSet = readByMaxId.executeQuery("SELECT id FROM client\n" +
                    "WHERE id = (SELECT  MAX(id) FROM client)");
            while (resultSet.next()) {
                maxId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId;
    }
    public void closeConnectionsAndStatements() {
        try {
            connection.close();
            createSt.close();
            readByIdSt.close();
            updateNameSt.close();
            deleteSt.close();
            readAllSt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
