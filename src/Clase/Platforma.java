package Clase;


public class Platforma {
    private int id;
    private String nume;
    private String descriere;

    public Platforma(String nume, String descriere) {
        this.nume = nume;
        this.descriere = descriere;
    }
    public Platforma(int id, String nume, String descriere) {
        this.id = id;
        this.nume = nume;
        this.descriere = descriere;
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

}
