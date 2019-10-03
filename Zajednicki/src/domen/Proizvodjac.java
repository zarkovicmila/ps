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
public class Proizvodjac implements Serializable, OpstiDomenskiObjekat{
    private int proizvodjacID;
    private String naziv;
    private String adresa;
    private String telefon;
    private String email;

    public Proizvodjac() {
    }

    public Proizvodjac(int proizvodjacID, String naziv, String adresa, String telefon, String email) {
        this.proizvodjacID = proizvodjacID;
        this.naziv = naziv;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProizvodjacID() {
        return proizvodjacID;
    }

    public void setProizvodjacID(int proizvodjacID) {
        this.proizvodjacID = proizvodjacID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Proizvodjac other = (Proizvodjac) obj;
        if (this.proizvodjacID != other.proizvodjacID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "proizvodjac";
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        while(rs.next()) {
            int id = rs.getInt("proizvodjacid");
            String naziv = rs.getString("naziv");
            String adresa = rs.getString("adresa");
            String telefon = rs.getString("telefon");
            String email = rs.getString("email");
            Proizvodjac p = new Proizvodjac(id, naziv, adresa, telefon, email);
            lista.add(p);
        }
        return lista;
    }
    
}
