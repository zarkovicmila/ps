/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste;

import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;



/**
 *
 * @author milaz
 */
public interface IBrokerBazePodataka {
    
    OpstiDomenskiObjekat vratiJednog(OpstiDomenskiObjekat obj) throws Exception;
    ArrayList<OpstiDomenskiObjekat> vratiVise(OpstiDomenskiObjekat obj) throws Exception;
    int sacuvaj(OpstiDomenskiObjekat obj) throws Exception;
    void izmeni(OpstiDomenskiObjekat obj) throws Exception;
    void obrisi(OpstiDomenskiObjekat obj) throws Exception;
    
}
