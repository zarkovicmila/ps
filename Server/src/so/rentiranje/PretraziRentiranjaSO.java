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
public class PretraziRentiranjaSO extends OpstaSistemskaOperacija {
    
    private ArrayList<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void validiraj(Object obj) throws Exception {
          if(!(obj instanceof Rentiranje)) {
            throw new Exception("Neodgovarajuci tip parametra");
        }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
       lista = db.vratiVise((OpstiDomenskiObjekat) obj);
        for (OpstiDomenskiObjekat odo : lista) {
            Rentiranje r = (Rentiranje) odo;
            StavkaRentiranja s = new StavkaRentiranja();
            s.setRentiranje(r);
            ArrayList<OpstiDomenskiObjekat> lista1 = db.vratiVise(s);
            ArrayList<StavkaRentiranja> stavke = new ArrayList<>();
           for (OpstiDomenskiObjekat o : lista1) {
                s = (StavkaRentiranja) o;
                stavke.add(s);
            }
            r.setStavke(stavke);
        }
    }

    public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
}
