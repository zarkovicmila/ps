/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.oprema;

import domen.OpstiDomenskiObjekat;
import domen.ZimskaOprema;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;



/**
 *
 * @author milaz
 */
public class VratiPonudeSO extends OpstaSistemskaOperacija{
    private ArrayList<OpstiDomenskiObjekat> lista;
    @Override
    protected void validiraj(Object obj) throws Exception {
        if(!(obj instanceof ZimskaOprema)) {
            throw new Exception("Neodgovarajuci tip parametra");
        }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
       lista = db.vratiVise((OpstiDomenskiObjekat) obj);
    }
     public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
}
