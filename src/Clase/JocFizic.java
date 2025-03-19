package Clase;

public class JocFizic extends Joc {
    private String dimensiune;
    public JocFizic(int id, String titlu, int idGen, String creator, double pret, String dimensiune) {
        super(id, titlu, idGen, creator, pret);
        this.dimensiune = dimensiune;
    }

    public JocFizic(String titlu, int idGen, String creator, double pret, String dimensiune) {
        super(titlu, idGen, creator, pret);
        this.dimensiune = dimensiune;
    }

    public String getDimensiune() {
        return dimensiune;
    }

    public void setDimensiune(String dimensiune) {
        this.dimensiune = dimensiune;
    }
}
