/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.korisnik;

import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author milaz
 */
public class PrijavljivanjeSO extends OpstaSistemskaOperacija{
    
    private Korisnik korisnik;

    @Override
    protected void validiraj(Object obj) throws Exception {
       if(!(obj instanceof Korisnik)){
           throw new Exception("Greska, pogresan parametar.");
       }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
        korisnik = (Korisnik) db.vratiJednog((OpstiDomenskiObjekat) obj);
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    
}
