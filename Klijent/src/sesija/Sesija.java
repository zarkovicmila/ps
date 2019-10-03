/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domen.OpstiDomenskiObjekat;
import domen.Korisnik;

/**
 *
 * @author milaz
 */
public class Sesija {

    private static Sesija instanca;
    private Korisnik korisnik;
    private OpstiDomenskiObjekat objekat;

    private Sesija() {
    }

    public static Sesija getInstanca() {
        if (instanca == null) {
            instanca = new Sesija();
        }
        return instanca;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public OpstiDomenskiObjekat getObjekat() {
        return objekat;
    }

    public void setObjekat(OpstiDomenskiObjekat objekat) {
        this.objekat = objekat;
    }

}
