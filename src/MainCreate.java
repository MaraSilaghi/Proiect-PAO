import Clase.*;
import DAO.*;

public class MainCreate{
    public static void main(String[] args) {

        Client client1 = new Client("Ion", "Popescu", "ion.popescu@biblioteca.com");
        Client client2 = new Client("Cristian", "Nedelcu", "cristian.nedelcu@biblioteca.com");
        Client client3 = new Client("Ana", "Ionescu", "ana.ionescu@biblioteca.com");
        Client client4 = new Client("Vlad", "Ganea", "vlad.ganea@biblioteca.com");
        Client client5 = new Client("Mihai", "George", "mihai.george@biblioteca.com");
        ClientDAO.getInstance().creeazaClient(client1);
        ClientDAO.getInstance().creeazaClient(client2);
        ClientDAO.getInstance().creeazaClient(client3);
        ClientDAO.getInstance().creeazaClient(client4);
        ClientDAO.getInstance().creeazaClient(client5);

        Gen gen1 = new Gen("Action", "Action games");
        Gen gen2 = new Gen("Puzzle", "Puzzle games");
        Gen gen3 = new Gen("RPG", "Role-playing games");
        Gen gen4 = new Gen("Strategy", "Strategy games");
        Gen gen5 = new Gen("Simulation", "Simulation games");
        GenDAO.getInstance().creeazaGen(gen1);
        GenDAO.getInstance().creeazaGen(gen2);
        GenDAO.getInstance().creeazaGen(gen3);
        GenDAO.getInstance().creeazaGen(gen4);
        GenDAO.getInstance().creeazaGen(gen5);


        Joc joc1 = new Joc("Portal 2", gen1.getId(), "Valve", 50);
        Joc joc2 = new Joc("The Witness", gen2.getId(), "Jonathan Blow", 40);
        Joc joc3 = new Joc("Half-Life 2", gen1.getId(), "Valve", 60);
        Joc joc4 = new Joc("The Witcher 3", gen3.getId(), "CD Projekt Red", 70);
        Joc joc5 = new Joc("Civilization VI", gen4.getId(), "Firaxis Games", 30);
        Joc joc6 = new Joc("SimCity", gen5.getId(), "Maxis", 20);
        JocDAO.getInstance().creeazaJoc(joc1);
        JocDAO.getInstance().creeazaJoc(joc2);
        JocDAO.getInstance().creeazaJoc(joc3);
        JocDAO.getInstance().creeazaJoc(joc4);
        JocDAO.getInstance().creeazaJoc(joc5);
        JocDAO.getInstance().creeazaJoc(joc6);

        Promotie promotie1 = new Promotie("Reducere de vara", "Reducere de 20%", 20, "2024-05-01", "2024-05-31", "Portal 2");
        Promotie promotie2 = new Promotie("Reducere de iarna", "Reducere de 25%", 25, "2024-12-01", "2024-12-31", "The Witcher 3");
        Promotie promotie3 = new Promotie("Reducere de toamna", "Reducere de 15%", 15, "2024-09-01", "2024-09-30", "The Witness");
        Promotie promotie4 = new Promotie("Reducere de primavara", "Reducere de 10%", 10, "2024-03-01", "2024-03-31", "Civilization VI");
        Promotie promotie5 = new Promotie("Reducere de weekend", "Reducere de 5%", 5, "2024-06-01", "2024-06-02", "SimCity");
        PromotieDAO.getInstance().creeazaPromotie(promotie1);
        PromotieDAO.getInstance().creeazaPromotie(promotie2);
        PromotieDAO.getInstance().creeazaPromotie(promotie3);
        PromotieDAO.getInstance().creeazaPromotie(promotie4);
        PromotieDAO.getInstance().creeazaPromotie(promotie5);


        Achizitie achizitie1 = new Achizitie(client1.getId(), joc1.getId(), "2024-05-23", joc1.getPret());
        Achizitie achizitie2 = new Achizitie(client1.getId(), joc2.getId(), "2024-06-15", joc2.getPret());
        Achizitie achizitie3 = new Achizitie(client2.getId(), joc3.getId(), "2024-07-07", joc3.getPret());
        Achizitie achizitie4 = new Achizitie(client3.getId(), joc4.getId(), "2024-12-10", joc4.getPret());
        Achizitie achizitie5 = new Achizitie(client3.getId(), joc5.getId(), "2024-08-20", joc5.getPret());
        AchizitieDAO.getInstance().creeazaAchizitie(achizitie1);
        AchizitieDAO.getInstance().creeazaAchizitie(achizitie2);
        AchizitieDAO.getInstance().creeazaAchizitie(achizitie3);
        AchizitieDAO.getInstance().creeazaAchizitie(achizitie4);
        AchizitieDAO.getInstance().creeazaAchizitie(achizitie5);
    }
}
