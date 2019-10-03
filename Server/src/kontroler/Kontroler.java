/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Klijent;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Proizvodjac;
import domen.Rentiranje;
import domen.TipOpreme;
import domen.ZimskaOprema;
import forme.FormaServer;
import java.util.ArrayList;
import java.util.List;
import niti.KlijentNit;
import so.OpstaSistemskaOperacija;
import so.klijent.PretraziKlijenteSO;
import so.klijent.UnosKlijentaSO;
import so.korisnik.PrijavljivanjeSO;
import so.oprema.IzmeniPonuduOpremeSO;
import so.oprema.UnosNoveOpreme;
import so.oprema.VratiPonudeSO;
import so.oprema.VratiProizvodjaceSO;
import so.oprema.VratiTipOpremeSO;
import so.rentiranje.PretraziRentiranjaSO;
import so.rentiranje.RentiranjeSO;
import so.rentiranje.VracanjeRentiraneOpremeSO;

/**
 *
 * @author milaz
 */
public class Kontroler {

    private static Kontroler instanca;
    private FormaServer forma;
    private ArrayList<KlijentNit> aktivniKorisnici;

    public Kontroler() {
        aktivniKorisnici = new ArrayList<>();
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public void setForma(FormaServer forma) {
        this.forma = forma;
    }

    public FormaServer getFormaServer() {
        return forma;
    }

    public void FormaServer(FormaServer forma) {
        this.forma = forma;
    }

    public Korisnik login(Korisnik korisnik) throws Exception {
        PrijavljivanjeSO p = new PrijavljivanjeSO();
        p.izvrsenjeSO(korisnik);
        return p.getKorisnik();
    }

    public boolean vecJeUlogovan(Korisnik korisnik) {
        for (KlijentNit klijentNit : aktivniKorisnici) {
            if (klijentNit.getKorisnik().equals(korisnik)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<KlijentNit> getAktivniKorisnici() {
        return aktivniKorisnici;
    }

    public void setAktivniKorisnici(ArrayList<KlijentNit> aktivniKorisnici) {
        this.aktivniKorisnici = aktivniKorisnici;
    }

    public void odjaviSe(Korisnik k) {

        for (KlijentNit klijentNit : aktivniKorisnici) {
            if (k.equals(klijentNit.getKorisnik())) {
                forma.odjava(k);

            }
        }
    }

    public void unosKlijenta(Klijent klijent) throws Exception {
        OpstaSistemskaOperacija so = new UnosKlijentaSO();
        so.izvrsenjeSO(klijent);

    }

    public ArrayList<OpstiDomenskiObjekat> vratiTipOpreme() throws Exception {
        OpstaSistemskaOperacija so = new VratiTipOpremeSO();
        so.izvrsenjeSO(new TipOpreme());
        return ((VratiTipOpremeSO) so).getLista();
    }

    public ArrayList<OpstiDomenskiObjekat> vratiProizvodjace() throws Exception {
        OpstaSistemskaOperacija so = new VratiProizvodjaceSO();
        so.izvrsenjeSO(new Proizvodjac());
        return ((VratiProizvodjaceSO) so).getLista();
    }

    public void unosNoveOpreme(ZimskaOprema zo) throws Exception {
        OpstaSistemskaOperacija so = new UnosNoveOpreme();
        so.izvrsenjeSO(zo);
    }

    public ArrayList<OpstiDomenskiObjekat> vratiPonudeZimskeOpreme() throws Exception {
        OpstaSistemskaOperacija so = new VratiPonudeSO();
        so.izvrsenjeSO(new ZimskaOprema());
        return ((VratiPonudeSO) so).getLista();
    }

    public void izmeniPonudu(ZimskaOprema zimskaOprema) throws Exception {
        OpstaSistemskaOperacija so = new IzmeniPonuduOpremeSO();
        so.izvrsenjeSO(zimskaOprema);
    }

    public ArrayList<OpstiDomenskiObjekat> pretraziKlijente(Klijent klijent) throws Exception {
        OpstaSistemskaOperacija so = new PretraziKlijenteSO();
        so.izvrsenjeSO(klijent);
        return ((PretraziKlijenteSO) so).getKlijenti();
    }

    public void rentiranje(Rentiranje r) throws Exception {
        OpstaSistemskaOperacija so = new RentiranjeSO();
        so.izvrsenjeSO(r);
    }

    public ArrayList<OpstiDomenskiObjekat> pretraziRentiranja(Rentiranje r) throws Exception {
        OpstaSistemskaOperacija so = new PretraziRentiranjaSO();
        so.izvrsenjeSO(r);
        return ((PretraziRentiranjaSO) so).getLista();
    }

    public void vracenaOprema(Rentiranje r) throws Exception {
        OpstaSistemskaOperacija so = new VracanjeRentiraneOpremeSO();
        so.izvrsenjeSO(r);
    }

}
