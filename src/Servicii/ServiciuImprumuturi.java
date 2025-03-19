package Servicii;
import Clase.Imprumut;
import Clase.Joc;
import Clase.Client;

import java.util.*;

public class ServiciuImprumuturi {
    private Map<Integer, List<Imprumut>> imprumuturi;
    private ServiciuJocuri serviciuJocuri;
    private ServiciuClienti serviciuClienti;
    private ServiciuAudit serviciuAudit;

    public ServiciuImprumuturi(ServiciuJocuri serviciuJocuri, ServiciuClienti serviciuClienti) {
        this.imprumuturi = new HashMap<>();
        this.serviciuJocuri = serviciuJocuri;
        this.serviciuClienti = serviciuClienti;
        this.serviciuAudit = ServiciuAudit.getInstance();
    }

    public void imprumutaJoc(int idClient, int idJoc, String dataImprumut) {
        Joc joc = serviciuJocuri.getJocById(idJoc);
        Client client = serviciuClienti.getClientById(idClient);

        if (joc != null && client != null && serviciuJocuri.esteDisponibil(idJoc)) {
            Imprumut nouImprumut = new Imprumut(idClient, idJoc, dataImprumut, null);
            imprumuturi.putIfAbsent(idClient, new ArrayList<>());
            imprumuturi.get(idClient).add(nouImprumut);
            serviciuJocuri.imprumutaJoc(idJoc);
            System.out.println("Jocul " + joc.getTitlu() + " a fost imprumutat cu succes de " + client.getNume());
            serviciuAudit.logAction("ImprumutaJoc");
        } else {
            System.out.println("Jocul " + (joc != null ? joc.getTitlu() : idJoc) + " nu este disponibil pentru imprumut.");
        }
    }

    public void returneazaJoc(int idClient, int idJoc, String dataReturnare) {
        Joc joc = serviciuJocuri.getJocById(idJoc);
        Client client = serviciuClienti.getClientById(idClient);
        List<Imprumut> listaImprumuturi = imprumuturi.get(idClient);
        if (listaImprumuturi != null) {
            for (Imprumut imprumut : listaImprumuturi) {
                if (imprumut.getIdJoc() == idJoc && imprumut.getStatus().equals("activ")) {
                    imprumut.setDataReturnare(dataReturnare);
                    imprumut.setStatus("returnat");
                    serviciuJocuri.returneazaJoc(idJoc);
                    System.out.println("Jocul " + joc.getTitlu() + " a fost returnat cu succes de " + client.getNume());
                    serviciuAudit.logAction("ReturneazaJoc");
                    return;
                }
            }
        }
        System.out.println("Jocul " + (joc != null ? joc.getTitlu() : idJoc) + " nu poate fi returnat deoarece nu a fost gasit in inregistrarile de imprumut.");
    }
}
