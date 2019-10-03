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

/**
 *
 * @author milaz
 */
public class ZimskaOprema implements Serializable, OpstiDomenskiObjekat {

    private int opremaID;
    private TipOpreme tip;
    private String naziv;
    private BigDecimal cena;
    private int kapacitet;
    private String uzrast;
    private Proizvodjac proizvodjac;
    private int raspolozivo;

    public ZimskaOprema() {
    }

    public ZimskaOprema(int opremaID, TipOpreme tip, String naziv, BigDecimal cena, int kapacitet, String uzrast, Proizvodjac proizvodjac) {
        this.opremaID = opremaID;
        this.tip = tip;
        this.naziv = naziv;
        this.cena = cena;
        this.kapacitet = kapacitet;
        this.uzrast = uzrast;
        this.proizvodjac = proizvodjac;
        
    }

    public void setRaspolozivo(int raspolozivo) {
        this.raspolozivo = raspolozivo;
    }

    public int getRaspolozivo() {
        return raspolozivo;
    }

    public int getOpremaID() {
        return opremaID;
    }

    public void setOpremaID(int opremaID) {
        this.opremaID = opremaID;
    }

    public TipOpreme getTip() {
        return tip;
    }

    public void setTip(TipOpreme tip) {
        this.tip = tip;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getUzrast() {
        return uzrast;
    }

    public void setUzrast(String uzrast) {
        this.uzrast = uzrast;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final ZimskaOprema other = (ZimskaOprema) obj;
        if (this.opremaID != other.opremaID) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return opremaID + ", " + "'" + naziv + "', " + cena + ", " + kapacitet + ", '" + uzrast + "', " + tip.getTipID() + ", " + proizvodjac.getProizvodjacID();
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "naziv='" + naziv + "', " + "cena='" + cena + "', " + "kapacitet='" + kapacitet + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "zimskaoprema";
    }

    @Override
    public String vratiSpajanje() {
        return " zo join proizvodjac p on(zo.proizvodjacid=p.proizvodjacid) join tipopreme t on(zo.tipopremeid=t.tipid)"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String selektuj() {
        return "zo.*,t.naziv,p.naziv"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSortiranje() {
        return " order by t.naziv,zo.naziv"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public String vratiUslovZaJednog() {
        return "opremaid='"+opremaID+"'";
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
            int id = rs.getInt("zo.opremaid");
            String naziv = rs.getString("zo.naziv");
            BigDecimal cena = rs.getBigDecimal("zo.cena");
            int kapacitet = rs.getInt("zo.kapacitet");
            String uzr = rs.getString("zo.uzrast");
            int tipopremeid = rs.getInt("zo.tipopremeid");
            int proizvodjacid = rs.getInt("zo.proizvodjacid");

            String nazivProizvodjaca = rs.getString("p.naziv");
            String nazivopreme = rs.getString("t.naziv");

            lista.add(new ZimskaOprema(id, new TipOpreme(tipopremeid, nazivopreme), naziv, cena, kapacitet, uzr, new Proizvodjac(proizvodjacid, nazivProizvodjaca, "", "", "")));
        }
        return lista;
    }

}
