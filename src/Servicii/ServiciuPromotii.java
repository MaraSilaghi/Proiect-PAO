package Servicii;
import Clase.Promotie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiciuPromotii {
    private List<Promotie> promotii;
    private ServiciuAudit serviciuAudit;

    public ServiciuPromotii() {
        this.promotii = new ArrayList<>();
        this.serviciuAudit = ServiciuAudit.getInstance();
    }

    public void adaugaPromotie(Promotie promotie) {
        promotii.add(promotie);
        serviciuAudit.logAction("AdaugaPromotie");
    }

    public double aplicaPromotie(String numeJoc, double pretJoc, String dataAchizitie) {
        for (Promotie promotie : promotii) {
            if (promotie.getNumeJoc().equalsIgnoreCase(numeJoc) && esteInPerioada(promotie, dataAchizitie)) {
                serviciuAudit.logAction("AplicaPromotie");
                return pretJoc - (pretJoc * promotie.getProcentReducere() / 100);
            }
        }
        return pretJoc;
    }

    private boolean esteInPerioada(Promotie promotie, String data) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date dataStartParsed = format.parse(promotie.getDataInceput());
            Date dataSfarsitParsed = format.parse(promotie.getDataSfarsit());
            Date dataParsed = format.parse(data);

            return !dataParsed.before(dataStartParsed) && !dataParsed.after(dataSfarsitParsed);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
