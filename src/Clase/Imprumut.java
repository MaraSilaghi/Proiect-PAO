package Clase;

public class Imprumut {
    private int id;
    private int idClient;
    private int idJoc;
    private String dataImprumut;
    private String dataReturnare;
    private String status;

    public Imprumut(int id, int idClient, int idJoc, String dataImprumut, String dataReturnare, String status) {
        this.id = id;
        this.idClient = idClient;
        this.idJoc = idJoc;
        this.dataImprumut = dataImprumut;
        this.dataReturnare = dataReturnare;
        this.status = status;
    }

    public Imprumut(int idClient, int idJoc, String dataImprumut, String dataReturnare) {
        this.idClient = idClient;
        this.idJoc = idJoc;
        this.dataImprumut = dataImprumut;
        this.dataReturnare = dataReturnare;
        this.status = "activ";
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

    public String getDataImprumut() {
        return dataImprumut;
    }

    public void setDataImprumut(String dataImprumut) {
        this.dataImprumut = dataImprumut;
    }

    public String getDataReturnare() {
        return dataReturnare;
    }

    public void setDataReturnare(String dataReturnare) {
        this.dataReturnare = dataReturnare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
