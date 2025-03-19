package Servicii;
import Clase.Joc;

import java.util.ArrayList;
import java.util.List;

public class ServiciuJocuri {
    private List<Joc> jocuri;
    private ServiciuAudit serviciuAudit;

    public ServiciuJocuri() {
        this.jocuri = new ArrayList<>();
        this.serviciuAudit = ServiciuAudit.getInstance();
    }

    public void adaugaJoc(Joc joc) {
        if (!jocuri.contains(joc)) {
            jocuri.add(joc);
        }
        serviciuAudit.logAction("AdaugaJoc");
    }

    public List<Joc> getJocuri() {
        return jocuri;
    }

    public Joc getJocById(int id) {
        for (Joc joc : jocuri) {
            if (joc.getId() == id) {
                return joc;
            }
        }
        return null;
    }

    public void imprumutaJoc(int idJoc) {
        Joc joc = getJocById(idJoc);
        if (joc != null) {
            joc.setDisponibil(false);
        }
        serviciuAudit.logAction("ImprumutaJoc");
    }

    public void returneazaJoc(int idJoc) {
        Joc joc = getJocById(idJoc);
        if (joc != null) {
            joc.setDisponibil(true);
        }
        serviciuAudit.logAction("ReturneazaJoc");
    }

    public boolean esteDisponibil(int idJoc) {
        Joc joc = getJocById(idJoc);
        return joc != null && joc.isDisponibil();
    }

    public void afiseazaJocuri() {
        if (jocuri.isEmpty()) {
            System.out.println("Nu sunt jocuri inregistrate.");
        } else {
            System.out.println("Jocurile inregistrate sunt:");
            for (Joc joc : jocuri) {
                System.out.println(joc.getTitlu());
            }
        }
        serviciuAudit.logAction("AfiseazaJocuri");
    }
}
