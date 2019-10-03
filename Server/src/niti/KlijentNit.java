/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Klijent;
import domen.Korisnik;
import domen.Rentiranje;
import domen.TipOpreme;
import domen.ZimskaOprema;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.KomSaKlijentom;
import konstante.Operacija;
import konstante.StatusOdgovora;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.Zahtev;

/**
 *
 * @author milaz
 */
public class KlijentNit extends Thread {

    private Socket socket;
    private boolean kraj = false;
    private Korisnik korisnik;

    public KlijentNit(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!kraj) {
            Zahtev z = KomSaKlijentom.getInstanca().primiZahtev(socket);
            Odgovor odg = new Odgovor();

            switch (z.getOperacija()) {
                case Operacija.PRIJAVI_SE:
                    try {
                        korisnik = Kontroler.getInstanca().login((Korisnik) z.getPodaci());
                        boolean aktivan = Kontroler.getInstanca().vecJeUlogovan(korisnik);
                        if (aktivan) {
                            odg.setGreska("Korisnik je vec ulogovan.");
                        } else {
                            if (!korisnik.getIme().isEmpty()) {
                                odg.setPodaci(korisnik);
                                odg.setStatus(StatusOdgovora.OK);
                                Kontroler.getInstanca().getAktivniKorisnici().add(this);
                                Kontroler.getInstanca().getFormaServer().dodajPrijavljenogKorisnika(korisnik);
                            } else {
                                odg.setGreska("Neuspesna prijava na sistem.");
                            }
                        }
                    } catch (Exception ex) {
                        odg.setGreska("Neuspesna prijava na sistem.");
                        odg.setPodaci(ex.getMessage());
                    }
                    break;

                case Operacija.ODJAVI_SE:
                    Korisnik k = (Korisnik) z.getPodaci();
                    try {
                        Kontroler.getInstanca().odjaviSe(k);
                        Kontroler.getInstanca().getAktivniKorisnici().remove(this);
                        odg.setStatus(StatusOdgovora.OK);
                    } catch (Exception ex) {
                        odg.setGreska("Greska");
                        odg.setStatus(StatusOdgovora.GRESKA);
                        odg.setPodaci(ex.getMessage());
                        System.out.println(ex.getStackTrace());
                    }
                    break;
                case Operacija.UNESI_KLIJENTA:
                    try {
                        Kontroler.getInstanca().unosKlijenta((Klijent) z.getPodaci());
                        odg.setStatus(StatusOdgovora.OK);

                    } catch (Exception ex) {
                        odg.setStatus(StatusOdgovora.GRESKA);
                        odg.setGreska(ex);

                    }
                    break;
                case Operacija.VRATI_TIP_OPREME:
                    try {
                        odg.setPodaci(Kontroler.getInstanca().vratiTipOpreme());
                        odg.setStatus(StatusOdgovora.OK);

                    } catch (Exception ex) {
                        odg.setStatus(StatusOdgovora.GRESKA);
                        odg.setGreska(ex);

                    }
                    break;
                case Operacija.VRATI_PROIZVODJACE:
                    try {
                        odg.setPodaci(Kontroler.getInstanca().vratiProizvodjace());
                        odg.setStatus(StatusOdgovora.OK);

                    } catch (Exception ex) {
                        odg.setStatus(StatusOdgovora.GRESKA);
                        odg.setGreska(ex);

                    }
                    break;
                case Operacija.KREIRAJ_PONUDU:
                    try {
                        ZimskaOprema zo = (ZimskaOprema) z.getPodaci();
                        Kontroler.getInstanca().unosNoveOpreme(zo);
                        odg.setStatus(StatusOdgovora.OK);

                    } catch (Exception ex) {
                        odg.setStatus(StatusOdgovora.GRESKA);
                        odg.setGreska(ex);

                    }
                    break;
                case Operacija.VRATI_PONUDE:
                    try {
                        odg.setPodaci(Kontroler.getInstanca().vratiPonudeZimskeOpreme());
                        odg.setStatus(StatusOdgovora.OK);

                    } catch (Exception ex) {
                        odg.setStatus(StatusOdgovora.GRESKA);
                        odg.setGreska(ex);

                    }
                    break;
                case Operacija.IZMENI_PONUDU:
                    try {
                        ZimskaOprema zimskaOprema = (ZimskaOprema) z.getPodaci();
                        Kontroler.getInstanca().izmeniPonudu(zimskaOprema);
                        odg.setStatus(StatusOdgovora.OK);

                    } catch (Exception ex) {
                        odg.setStatus(StatusOdgovora.GRESKA);
                        odg.setGreska(ex);

                    }
                    break;
                case Operacija.PRETRAZI_KLIJENTE:
                    try {
                        Klijent klijent = (Klijent) z.getPodaci();
                        odg.setPodaci(Kontroler.getInstanca().pretraziKlijente(klijent));
                        odg.setStatus(StatusOdgovora.OK);

                    } catch (Exception ex) {
                        odg.setStatus(StatusOdgovora.GRESKA);
                        odg.setGreska(ex);

                    }
                    break;
                case Operacija.RENTIRANJE:
                    try {
                        Rentiranje r = (Rentiranje) z.getPodaci();
                        Kontroler.getInstanca().rentiranje(r);
                        odg.setStatus(StatusOdgovora.OK);

                    } catch (Exception ex) {
                        odg.setStatus(StatusOdgovora.GRESKA);
                        odg.setGreska(ex);

                    }
                    break;
                case Operacija.PRETRAZI_RENTIRANJA:
                    try {
                        Rentiranje r = (Rentiranje) z.getPodaci();
                        odg.setPodaci(Kontroler.getInstanca().pretraziRentiranja(r));
                        odg.setStatus(StatusOdgovora.OK);

                    } catch (Exception ex) {
                        odg.setStatus(StatusOdgovora.GRESKA);
                        odg.setGreska(ex);

                    }
                    break;
                case Operacija.VRACENA_OPREMA:
                    try {
                        Rentiranje r = (Rentiranje) z.getPodaci();
                        System.out.println(r.isStatus());
                        Kontroler.getInstanca().vracenaOprema(r);
                        odg.setStatus(StatusOdgovora.OK);

                    } catch (Exception ex) {
                        odg.setStatus(StatusOdgovora.GRESKA);
                        odg.setGreska(ex);

                    }
                    break;
            }

            KomSaKlijentom.getInstanca().posaljiOdgovor(odg, socket);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isKraj() {
        return kraj;
    }

    public void setKraj(boolean kraj) {
        this.kraj = kraj;

    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

}
