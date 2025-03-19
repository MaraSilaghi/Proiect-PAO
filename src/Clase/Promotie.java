package Clase;

public class Promotie {
    private int id;
    private String nume;
    private String descriere;
    private int procentReducere;
    private String dataInceput;
    private String dataSfarsit;
    private String numeJoc;

    public Promotie(int id, String nume, String descriere, int procentReducere, String dataInceput, String dataSfarsit, String numeJoc) {
        this.id = id;
        this.nume = nume;
        this.descriere = descriere;
        this.procentReducere = procentReducere;
        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
        this.numeJoc = numeJoc;
    }

    public Promotie(String nume, String descriere, int procentReducere, String dataInceput, String dataSfarsit, String numeJoc) {
        this.nume = nume;
        this.descriere = descriere;
        this.procentReducere = procentReducere;
        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
        this.numeJoc = numeJoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getProcentReducere() {
        return procentReducere;
    }

    public void setProcentReducere(int procentReducere) {
        this.procentReducere = procentReducere;
    }

    public String getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(String dataInceput) {
        this.dataInceput = dataInceput;
    }

    public String getDataSfarsit() {
        return dataSfarsit;
    }

    public void setDataSfarsit(String dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }

    public String getNumeJoc() {
        return numeJoc;
    }

    public void setNumeJoc(String numeJoc) {
        this.numeJoc = numeJoc;
    }
}
