/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author milaz
 */
public class Korisnik implements Serializable, OpstiDomenskiObjekat {

    private int korisnikID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private String telefon;

    public Korisnik() {
    }

    public Korisnik(int korisnikID, String ime, String prezime, String korisnickoIme, String lozinka, String telefon) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.telefon = telefon;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return korisnikID + ", '" + ime + "', " + "'" + prezime + "', " + "'" + korisnickoIme + "', " + "'" + lozinka + "', " + "'" + telefon + "'";

    }

    @Override
    public String postaviVrednostiAtributa() {
        return "korisnikID=" + korisnikID + ", " + "ime='" + ime + "', " + "prezime='" + prezime + "', " + "korisnickoIme='" + korisnikID + "', " + "lozinka='" + lozinka + "', " + "telefon='" + telefon + "'";

    }

    @Override
    public String vratiImeKlase() {
        return "korisnik";
    }

    @Override
    public String vratiUslovZaJednog() {
        return "korisnickoIme = '" + korisnickoIme + "' and lozinka='" + lozinka + "'";
    }

    @Override
    public String vratiUslovZaVise() {
        return "korisnickoIme = '" + korisnickoIme + "' and lozinka='" + lozinka + "'";
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        String[] kolone = {"korisnikid", "ime", "prezime", "korisnickoime", "lozinka", "telefon"};
        return kolone[kolona];
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        if (rs.next()) {
            korisnikID = rs.getInt("korisnikid");
            ime = rs.getString("ime");
            prezime = rs.getString("prezime");
            korisnickoIme = rs.getString("korisnickoime");
            lozinka = rs.getString("lozinka");
            telefon = rs.getString("telefon");
            return this;
        }
        throw new Exception("Korisnik ne postoji u bazi!");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (this.korisnikID != other.korisnikID) {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
