package Clase;

public class JocDigital extends Joc {
    private int idPlatforma;


    public JocDigital(int id, String titlu, int idGen, String creator, Integer pret, int idPlatforma) {
        super(id, titlu, idGen, creator, pret);
        this.idPlatforma = idPlatforma;
    }

    public JocDigital(String titlu, int idGen, String creator, Integer pret, int idPlatforma) {
        super(titlu, idGen, creator, pret);
        this.idPlatforma = idPlatforma;
    }

    public int getIdPlatforma() {
        return idPlatforma;
    }

    public void setIdPlatforma(int idPlatforma) {
        this.idPlatforma = idPlatforma;
    }
}
