import Clase.*;
import DAO.*;
import Servicii.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ServiciuClienti serviciuClienti = new ServiciuClienti();
        ServiciuJocuri serviciuJocuri = new ServiciuJocuri();
        ServiciuPromotii serviciuPromotii = new ServiciuPromotii();
        ServiciuImprumuturi serviciuImprumuturi = new ServiciuImprumuturi(serviciuJocuri, serviciuClienti);
        ServiciuFinanciar serviciuFinanciar = new ServiciuFinanciar(serviciuJocuri, serviciuClienti);
        ServiciuRecenzii serviciuRecenzii = new ServiciuRecenzii(serviciuJocuri, serviciuClienti);

        List<Client> clienti = ClientDAO.getInstance().citesteClienti();
        for (Client client : clienti) {
            serviciuClienti.adaugaClient(client);
        }

        List<Joc> jocuri = JocDAO.getInstance().citesteJocuri();
        for (Joc joc : jocuri) {
            serviciuJocuri.adaugaJoc(joc);
        }

        List<Promotie> promotii = PromotieDAO.getInstance().citestePromotii();
        for (Promotie promotie : promotii) {
            serviciuPromotii.adaugaPromotie(promotie);
        }


        List<Achizitie> achizitii = AchizitieDAO.getInstance().citesteAchizitii();
        for (Achizitie achizitie : achizitii) {
            serviciuFinanciar.adaugaAchizitie(achizitie);
        }

        for (Achizitie achizitie : achizitii) {
            Joc joc = JocDAO.getInstance().citesteJoc(achizitie.getIdJoc());
            if (joc != null) {
                double pretOriginal = joc.getPret();
                double pretRedus = serviciuPromotii.aplicaPromotie(joc.getTitlu(), pretOriginal, achizitie.getDataAchizitie());
                if (pretRedus != pretOriginal) {
                    achizitie.setPret(pretRedus);
                    AchizitieDAO.getInstance().updateAchizitie(achizitie);
                }
            }
        }

        AchizitieDAO.getInstance().stergeAchizitie(6);
//        clienti.get(0).setPrenume("Maria");
//        ClientDAO.getInstance().updateClient(clienti.get(0));



        serviciuClienti.afiseazaClienti();
        System.out.println();
        serviciuJocuri.afiseazaJocuri();
        System.out.println();
        serviciuFinanciar.afiseazaAchizitii();
        System.out.println();
        serviciuFinanciar.afiseazaVenituriTotale();
        System.out.println();

        System.out.println("Imprumuturi:");
        serviciuImprumuturi.imprumutaJoc(1, 3, "2024-06-01");
        serviciuImprumuturi.returneazaJoc(1, 3, "2024-06-15");
        serviciuImprumuturi.imprumutaJoc(2, 3, "2024-06-16");
        serviciuImprumuturi.returneazaJoc(1, 2, "2024-06-18");
        serviciuImprumuturi.imprumutaJoc(1, 3, "2024-06-18");

        System.out.println();
        serviciuRecenzii.adaugaRecenzie(3, 1, 5, "Foarte bun!");
        serviciuRecenzii.adaugaRecenzie(3, 4, 4, "Bun!");
        serviciuRecenzii.adaugaRecenzie(2, 3, 4, "Bun!");
        serviciuRecenzii.adaugaRecenzie(2, 5, 3, "Ok!");
        serviciuRecenzii.adaugaRecenzie(2, 3, 5, "Foarte bun!");

        serviciuRecenzii.afiseazaRecenzii(3);
        serviciuRecenzii.calculeazaRatingMediu(3);
        System.out.println();
        serviciuRecenzii.afiseazaRecenzii(2);
        serviciuRecenzii.calculeazaRatingMediu(2);

    }
}
