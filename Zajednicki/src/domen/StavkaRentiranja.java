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
public class StavkaRentiranja implements Serializable,OpstiDomenskiObjekat{
    private int rb;
    private BigDecimal cena;
    private int kolicina;
    private ZimskaOprema oprema;
    private Rentiranje rentiranje;

    public StavkaRentiranja() {
    }

    public StavkaRentiranja(int rb, BigDecimal cena, int kolicina, ZimskaOprema oprema) {
        this.rb = rb;
        this.cena = cena;
        this.kolicina = kolicina;
        this.oprema = oprema;
    }
    
    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public ZimskaOprema getOprema() {
        return oprema;
    }

    public void setOprema(ZimskaOprema oprema) {
        this.oprema = oprema;
    }

    public Rentiranje getRentiranje() {
        return rentiranje;
    }

    public void setRentiranje(Rentiranje rentiranje) {
        this.rentiranje = rentiranje;
    }
    
    @Override
    public String vratiVrednostiAtributa() {
        return rentiranje.getRentaID() + ", " + rb + ", " + cena + ", " + kolicina + ", " + oprema.getOpremaID();
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "stavkarentiranja";
    }

    @Override
    public String vratiUslovZaJednog() {
        return "rentaid="+rentiranje.getRentaID() + " and rb="+rb;
    }

    @Override
    public String vratiUslovZaVise() {
         return " where s.rentaid="+rentiranje.getRentaID();
    }

    @Override
    public String vratiSpajanje() {
        return " s join rentiranje r on(s.rentaid=r.rentaid) join zimskaoprema z on(s.opremaid=z.opremaid) join tipopreme t on(z.tipopremeid=t.tipid) join proizvodjac p on(z.proizvodjacid=p.proizvodjacid)"; //To change body of generated methods, choose Tools | Templates.
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
    public String vratiSortiranje() {
        return " order by rb asc"; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
         ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()) {
            int rentaid = rs.getInt("s.rentaid");
            int rb = rs.getInt("s.rb");
            BigDecimal cena = rs.getBigDecimal("s.cena");
            int kol = rs.getInt("s.kolicina");
            int zimskaOprID = rs.getInt("s.opremaid");
            String nazivZimskeOpr = rs.getString("z.naziv");
            BigDecimal cenaZimOpr = rs.getBigDecimal("z.cena");
            int kapacitet = rs.getInt("z.kapacitet");
            String uzrast = rs.getString("z.uzrast");
            int tipOprID = rs.getInt("z.tipopremeid");
            int proizvodjacID = rs.getInt("z.proizvodjacid");
            String nazivTipaOpreme = rs.getString("t.naziv");
            String nazivProizvodjaca = rs.getString("p.naziv");
            
            Rentiranje rent = new Rentiranje();
            rent.setRentaID(rentaid);
            TipOpreme tipOpreme = new TipOpreme(tipOprID, nazivTipaOpreme);
            Proizvodjac proizvodjac = new Proizvodjac(proizvodjacID, nazivProizvodjaca, "", "", "");
            ZimskaOprema zo = new ZimskaOprema(zimskaOprID, tipOpreme, nazivZimskeOpr, cenaZimOpr, kapacitet, uzrast, proizvodjac);
            StavkaRentiranja stavka = new StavkaRentiranja(rb, cena, kol, zo);
            stavka.setRentiranje(rent);
            lista.add(stavka);
        }
        return lista;
    }
    
    
}
