package Servicii;

import Clase.Achizitie;
import Clase.Client;
import Clase.Joc;
import Servicii.ServiciuAudit;

import java.util.ArrayList;
import java.util.List;

public class ServiciuFinanciar {
    private List<Achizitie> achizitii;
    private ServiciuJocuri serviciuJocuri;
    private ServiciuClienti serviciuClienti;

    private ServiciuAudit serviciuAudit;

    public ServiciuFinanciar(ServiciuJocuri serviciuJocuri, ServiciuClienti serviciuClienti) {
        this.achizitii =  new ArrayList<>();
        this.serviciuJocuri = serviciuJocuri;
        this.serviciuClienti = serviciuClienti;
        this.serviciuAudit = ServiciuAudit.getInstance();
    }

    public void adaugaAchizitie(Achizitie achizitie) {
        achizitii.add(achizitie);
        serviciuAudit.logAction("AdaugaAchizitie");
    }


    public void afiseazaAchizitii() {
        if (achizitii.isEmpty()) {
            System.out.println("Nu sunt achizitii inregistrate.");
        } else {
            System.out.println("Achizitiile clientilor sunt:");
            for (Achizitie achizitie : achizitii) {
                //preluam jocul si clientul fiecarei achizitii astfel incat sa le afisam folosind nume, prenume si titlu
                Joc joc = serviciuJocuri.getJocById(achizitie.getIdJoc());
                Client client = serviciuClienti.getClientById(achizitie.getIdClient());
                System.out.println(client.getNume() + " " + client.getPrenume() + " - " + joc.getTitlu()  + " - " + achizitie.getPret());
            }
        }
        serviciuAudit.logAction("AfiseazaAchizitii");
    }

    public void afiseazaVenituriTotale() {
        double venituriTotale = 0;
        for (Achizitie achizitie : achizitii) {
            venituriTotale += achizitie.getPret();
        }
        System.out.println("Veniturile totale ale magazinului sunt: " + venituriTotale);
        serviciuAudit.logAction("AfiseazaVenituriTotale");
    }
}
