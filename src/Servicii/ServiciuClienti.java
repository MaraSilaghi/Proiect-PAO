package Servicii;

import Clase.Client;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ServiciuClienti {
    private Set<Client> clienti;
    private ServiciuAudit serviciuAudit;

    public ServiciuClienti() {
        this.clienti = new TreeSet<>(Comparator.comparing(Client::getNume));
        this.serviciuAudit = ServiciuAudit.getInstance();
    }

    public void adaugaClient(Client client) {
        clienti.add(client);
        serviciuAudit.logAction("AdaugaClient");
    }

    public void afiseazaClienti() {
        if (clienti.isEmpty()) {
            System.out.println("Nu sunt clienti inregistrati.");
        } else {
            System.out.println("Clientii magazinului sunt:");
            for (Client client : clienti) {
                System.out.println(client.getNume() + ' ' + client.getPrenume());
            }
        }
        serviciuAudit.logAction("AfiseazaClienti");
    }

    public Client getClientById(int id) {
        for (Client client : clienti) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
}
