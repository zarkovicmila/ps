/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author milaz
 */
public class Rentiranje implements Serializable, OpstiDomenskiObjekat {

    private int rentaID;
    private int brojDana;
    private Date datum;
    private BigDecimal ukupnaCena;
    private boolean status=true;
    private ArrayList<StavkaRentiranja> stavke;
    private Klijent klijent;

    public Rentiranje() {
    }

    public Rentiranje(int rentaID, int brojDana, Date datum, BigDecimal ukupnaCena, boolean status, ArrayList<StavkaRentiranja> stavke, Klijent klijent) {
        this.rentaID = rentaID;
        this.brojDana = brojDana;
        this.datum = datum;
        this.ukupnaCena = ukupnaCena;
        this.status = status;
        this.stavke = stavke;
        this.klijent = klijent;
    }

    public ArrayList<StavkaRentiranja> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaRentiranja> stavke) {
        this.stavke = stavke;
    }

    public int getRentaID() {
        return rentaID;
    }

    public void setRentaID(int rentaID) {
        this.rentaID = rentaID;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(int brojDana) {
        this.brojDana = brojDana;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public BigDecimal getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(BigDecimal ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return rentaID + ", " + brojDana + ", '" + new java.sql.Date(datum.getTime()) + "', " + ukupnaCena + ", " + (status == true ? 1 : 0) + ", " + klijent.getKlijentID();
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "status=" + status;
    }

    @Override
    public String vratiImeKlase() {
        return "rentiranje";
    }

//    @Override
//    public String selektuj() {
//        return "r.*,k.ime,k.prezime"; //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public String vratiSpajanje() {
        return " r join klijent k on r.klijentid=k.klijentid";
    }

    @Override
    public String vratiUslovZaJednog() {
        return "rentaid=" + rentaID;
    }

    @Override
    public String vratiUslovZaVise() {
        String rez = " where (r.status=" + status;
        if (!status) {
            rez += " or r.status=true)";
        } else{
            rez+=")";
        }
        if (klijent.getIme() != null) {
            rez += " and k.ime like '" + klijent.getIme() + "%'";
        }
        if (klijent.getPrezime() != null) {
            rez += " and k.prezime like '" + klijent.getPrezime() + "%'";
        }
      
        return rez;
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
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("r.rentaid");
            int brDana = rs.getInt("r.brojdana");
            Date datum = rs.getDate("r.datumrentiranja");

            BigDecimal ukCena = rs.getBigDecimal("r.ukupnacena");
            boolean status = rs.getBoolean("r.status");
            int klijentID = rs.getInt("r.klijentid");
            String ime = rs.getString("k.ime");
            String prezime = rs.getString("k.prezime");

            Klijent k = new Klijent();
            k.setIme(ime);
            k.setPrezime(prezime);
            lista.add(new Rentiranje(id, brDana, datum, ukCena, status, null, k));

        }
        return lista;
    }

    @Override
    public String vratiSortiranje() {
        return " order by r.datumrentiranja DESC";
    }

}
