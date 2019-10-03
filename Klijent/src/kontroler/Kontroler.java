/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Klijent;
import domen.Korisnik;
import domen.Proizvodjac;
import domen.Rentiranje;
import domen.TipOpreme;
import domen.ZimskaOprema;
import java.io.IOException;
import java.util.ArrayList;
import komunikacija.KomSaServerom;
import konstante.Operacija;
import konstante.StatusOdgovora;
import sesija.Sesija;
import transfer.Odgovor;
import transfer.Zahtev;

/**
 *
 * @author milaz
 */
public class Kontroler {

    private static Kontroler instanca;
    private ArrayList<ZimskaOprema> ponude;

    public Kontroler() {
        ponude = new ArrayList<>();
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public void setPonude(ArrayList<ZimskaOprema> ponude) {
        this.ponude = ponude;
    }

    public ArrayList<ZimskaOprema> getPonude() {
        return ponude;
    }

    public Korisnik login(String korisnickoIme, String lozinka) throws Exception {
        Korisnik k = new Korisnik();
        k.setKorisnickoIme(korisnickoIme);
        k.setLozinka(lozinka);
        Zahtev z = new Zahtev(Operacija.PRIJAVI_SE, k);
        KomSaServerom.getInstanca().posaljiZahtev(z);
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            return (Korisnik) o.getPodaci();
        }

        throw new Exception((String) o.getGreska());

    }

    public void odjaviSe() throws Exception {
        KomSaServerom.getInstanca().posaljiZahtev(new Zahtev(Operacija.ODJAVI_SE, Sesija.getInstanca().getKorisnik()));
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.GRESKA) {
            throw new Exception((String) o.getGreska());
        }
        if (o.getStatus() == StatusOdgovora.OK) {
            return;
        }

    }

    public void unosKlijenta(Klijent k) throws Exception {
        KomSaServerom.getInstanca().posaljiZahtev(new Zahtev(Operacija.UNESI_KLIJENTA, k));
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;

    }

    public ArrayList<TipOpreme> vratiTipOpreme() throws Exception {
        KomSaServerom.getInstanca().posaljiZahtev(new Zahtev(Operacija.VRATI_TIP_OPREME, null));
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            return (ArrayList<TipOpreme>) o.getPodaci();
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public ArrayList<Proizvodjac> vratiProizvodjace() throws Exception {
        KomSaServerom.getInstanca().posaljiZahtev(new Zahtev(Operacija.VRATI_PROIZVODJACE, null));
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            return (ArrayList<Proizvodjac>) o.getPodaci();
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public void unosNoveOpreme(ZimskaOprema zo) throws Exception {
        KomSaServerom.getInstanca().posaljiZahtev(new Zahtev(Operacija.KREIRAJ_PONUDU, zo));
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public ArrayList<ZimskaOprema> vratiPonudeZimskeOpreme() throws Exception {
        KomSaServerom.getInstanca().posaljiZahtev(new Zahtev(Operacija.VRATI_PONUDE, null));
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            return (ArrayList<ZimskaOprema>) o.getPodaci();
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }


    public void izmeniPonudu(ZimskaOprema oprema) throws Exception {
        KomSaServerom.getInstanca().posaljiZahtev(new Zahtev(Operacija.IZMENI_PONUDU, oprema));
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public ArrayList<Klijent> pretraziKlijente(Klijent k) throws Exception {
        KomSaServerom.getInstanca().posaljiZahtev(new Zahtev(Operacija.PRETRAZI_KLIJENTE, k));
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            return (ArrayList<Klijent>) o.getPodaci();
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public void rentiranje(Rentiranje r) throws Exception {
        KomSaServerom.getInstanca().posaljiZahtev(new Zahtev(Operacija.RENTIRANJE, r));
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public ArrayList<Rentiranje> pretraziRentiranjene(Rentiranje rentiranje) throws Exception {
        KomSaServerom.getInstanca().posaljiZahtev(new Zahtev(Operacija.PRETRAZI_RENTIRANJA, rentiranje));
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            return (ArrayList<Rentiranje>) o.getPodaci();
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public void vracenaOprema(Rentiranje r) throws Exception {
        KomSaServerom.getInstanca().posaljiZahtev(new Zahtev(Operacija.VRACENA_OPREMA, r));
        Odgovor o = KomSaServerom.getInstanca().primiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

}
