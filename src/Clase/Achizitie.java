package Clase;

public class Achizitie {
    private int id;
    private int idClient;
    private int idJoc;
    private String dataAchizitie;
    private double pret;

    public Achizitie(int id, int idClient, int idJoc, String dataAchizitie, double pret) {
        this.id = id;
        this.idClient = idClient;
        this.idJoc = idJoc;
        this.dataAchizitie = dataAchizitie;
        this.pret = pret;
    }

    public Achizitie(int idClient, int idJoc, String dataAchizitie, double pret) {
        this.idClient = idClient;
        this.idJoc = idJoc;
        this.dataAchizitie = dataAchizitie;
        this.pret = pret;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdJoc() {
        return idJoc;
    }

    public void setIdJoc(int idJoc) {
        this.idJoc = idJoc;
    }

    public String getDataAchizitie() {
        return dataAchizitie;
    }

    public void setDataAchizitie(String dataAchizitie) {
        this.dataAchizitie = dataAchizitie;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }
}
