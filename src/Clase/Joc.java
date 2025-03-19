package Clase;

public class Joc {
    private int id;
    private String titlu;
    private int idGen;
    private String creator;
    private double pret;
    private boolean disponibil;

    //pentru update in JocDAO
    public Joc(int id, String titlu, int idGen, String creator, double pret, boolean disponibil) {
        this.id = id;
        this.titlu = titlu;
        this.idGen = idGen;
        this.creator = creator;
        this.pret = pret;
        this.disponibil = disponibil;
    }

    //pentru initializare in main
    public Joc(String titlu, int idGen, String creator, double pret) {
        this.titlu = titlu;
        this.idGen = idGen;
        this.creator = creator;
        this.pret = pret;
        this.disponibil = true;
    }

  //pentru constructorul din joc_fizic
    public Joc(int id, String titlu, int idGen, String creator, double pret) {
        this.id = id;
        this.titlu = titlu;
        this.idGen = idGen;
        this.creator = creator;
        this.pret = pret;
        this.disponibil = true;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public int getIdGen() {
        return idGen;
    }

    public void setIdGen(int idGen) {
        this.idGen = idGen;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public boolean isDisponibil() {
        return disponibil;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil = disponibil;
    }
}
