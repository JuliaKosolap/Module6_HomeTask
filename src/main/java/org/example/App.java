package org.example;

import org.example.common.ClientService;
import org.example.entities.Client;
import org.flywaydb.core.Flyway;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./org/example", "sa", null).load();
        flyway.migrate();

        ClientService service = new ClientService();
        long id1 = service.create("Julia Hunter");
        System.out.println(id1);
        String name = service.getById(5);
        System.out.println(name);
        service.setName(4, "Klara Cetkin");
        System.out.println(service.getById(4));
        service.deleteById(12);
        List<Client> clients = service.listAll();
        System.out.println(clients);
        service.closeConnectionsAndStatements();
    }
}
