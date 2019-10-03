/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rentiranje;

import domen.OpstiDomenskiObjekat;
import domen.Rentiranje;
import domen.StavkaRentiranja;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author milaz
 */
public class RentiranjeSO extends OpstaSistemskaOperacija {

    @Override
    protected void validiraj(Object obj) throws Exception {
         if(!(obj instanceof Rentiranje)) {
            throw new Exception("Neodgovarajuci tip parametra");
        }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
        int id = db.sacuvaj((OpstiDomenskiObjekat) obj);
        Rentiranje r = (Rentiranje) obj;
        r.setRentaID(id);
        ArrayList<StavkaRentiranja> stavke = r.getStavke();
        for (StavkaRentiranja s : stavke) {
            s.setRentiranje(r);
            db.sacuvaj(s);
        }
    }
    
}
