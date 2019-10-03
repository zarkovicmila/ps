/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milaz
 */
public class Klijent implements Serializable, OpstiDomenskiObjekat {

    private int klijentID;
    private String jmbg;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;

    public Klijent() {
    }

    public Klijent(int klijentID, String jmbg, String ime, String prezime, String email, String telefon) {
        this.klijentID = klijentID;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return klijentID + ", '" + ime + "', " + "'" + prezime + "', " + "'" + jmbg + "', " + "'" + telefon + "', " + "'" + email + "'";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "ime = '" + ime + "', " + "prezime = '" + prezime + "', " + "jmbg = '" + jmbg + "', " + "telefon = '" + telefon + "', " + "email = '" + email + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "klijent";
    }

    @Override
    public String vratiUslovZaJednog() {
        return "klijentid=" + klijentID;
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            int klijentid = rs.getInt("klijentid");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String jmbg = rs.getString("jmbg");
            String email = rs.getString("email");
            String telefon = rs.getString("telefon");

            Klijent k = new Klijent(klijentid, jmbg, ime, prezime, email, telefon);
            list.add(k);
        }
        return list;
    }

    @Override
    public String vratiUslovZaVise() {
        String rez = " where";
        if(ime!=null){
            rez += " ime like '"+ime+"%' and";
        }
        if(prezime!=null) {
            rez += " prezime like '"+prezime + "%' and";
        }
        if(rez.equals(" where")) {
            return "";
        }
        return rez.substring(0, rez.length()-4);
    }

   
      @Override
    public String vratiSortiranje() {
        return " order by prezime";
    }
}
