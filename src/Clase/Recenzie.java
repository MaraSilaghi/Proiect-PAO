package Clase;

public class Recenzie {
    private int id;
    private int idJoc;
    private int idClient;
    private int rating;
    private String text;

    public Recenzie(int id, int idJoc, int idClient, int rating, String text) {
        this.id = id;
        this.idJoc = idJoc;
        this.idClient = idClient;
        this.rating = rating;
        this.text = text;
    }

    public Recenzie(int idJoc, int idClient, int rating, String text) {
        this.idJoc = idJoc;
        this.idClient = idClient;
        this.rating = rating;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJoc() {
        return idJoc;
    }

    public void setIdJoc(int idJoc) {
        this.idJoc = idJoc;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
