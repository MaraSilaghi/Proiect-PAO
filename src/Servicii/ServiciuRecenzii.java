package Servicii;
import Clase.Client;
import Clase.Joc;
import Clase.Recenzie;
import Servicii.ServiciuAudit;

import java.util.ArrayList;
import java.util.List;

public class ServiciuRecenzii {
    private List<Recenzie> recenzii;
    private ServiciuJocuri serviciuJocuri;
    private ServiciuClienti serviciuClienti;

    private ServiciuAudit serviciuAudit;

    public ServiciuRecenzii(ServiciuJocuri serviciuJocuri, ServiciuClienti serviciuClienti) {
        this.serviciuJocuri = serviciuJocuri;
        this.serviciuClienti = serviciuClienti;
        this.recenzii = new ArrayList<>();
        this.serviciuAudit = ServiciuAudit.getInstance();
    }

    public void adaugaRecenzie(int idJoc, int idClient, int rating, String text) {
        Recenzie nouaRecenzie = new Recenzie(idJoc, idClient, rating, text);
        recenzii.add(nouaRecenzie);
        serviciuAudit.logAction("AdaugaRecenzie");
    }

    public void afiseazaRecenzii(int idJoc) {
        if (recenzii.isEmpty()) {
            System.out.println("Nu sunt recenzii inregistrate.");
        } else {
            Joc joc = serviciuJocuri.getJocById(idJoc);
            System.out.println("Recenzii pentru " + joc.getTitlu() + ":");
            for (Recenzie recenzie : recenzii) {
                if(recenzie.getIdJoc() == idJoc){
                    Client client = serviciuClienti.getClientById(recenzie.getIdClient());
                    System.out.println(client.getNume()+ " " + client.getPrenume() +
                            " - Rating: " + recenzie.getRating() + " - '" + recenzie.getText()+"'");
                }
            }
        }
        serviciuAudit.logAction("AfiseazaRecenzii");
    }

    public void calculeazaRatingMediu(int idJoc) {
        double sumaRatings = 0;
        int nrRecenzii = 0;
        Joc joc = serviciuJocuri.getJocById(idJoc);
        for (Recenzie recenzie : recenzii) {
            if (recenzie.getIdJoc() == idJoc) {
                sumaRatings += recenzie.getRating();
                nrRecenzii++;
            }
        }
        if (nrRecenzii > 0)
            System.out.println("Rating-ul mediu pentru " + joc.getTitlu() + " este " + (sumaRatings / nrRecenzii));
        else
            System.out.println("Jocul " + joc.getTitlu() + " nu are nicio recenzie.");
        serviciuAudit.logAction("CalculeazaRatingMediu");
    }
}
