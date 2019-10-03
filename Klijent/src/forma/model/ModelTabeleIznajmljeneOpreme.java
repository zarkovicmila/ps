/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domen.StavkaRentiranja;
import domen.ZimskaOprema;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milaz
 */
public class ModelTabeleIznajmljeneOpreme extends AbstractTableModel {

    String[] kolone = {"Rb", "Vrsta opreme", "Proizvodjac", "Naziv", "Uzrast", "Kolicina", "Cena"};
    private ArrayList<StavkaRentiranja> lista;

    public ModelTabeleIznajmljeneOpreme() {
        lista = new ArrayList<>();
    }

    public ModelTabeleIznajmljeneOpreme(ArrayList<StavkaRentiranja> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        StavkaRentiranja sr = lista.get(row);
        switch (column) {
            case 0:
                return sr.getRb();
            case 1:
                return sr.getOprema().getTip();
            case 2:
                return sr.getOprema().getProizvodjac();
            case 3:
                return sr.getOprema().getNaziv();
            case 4:
                return sr.getOprema().getUzrast();
            case 5:
                return sr.getKolicina();
            case 6:
                return sr.getCena();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    public ArrayList<StavkaRentiranja> getLista() {
        return lista;
    }

    public void setLista(ArrayList<StavkaRentiranja> lista) {
        this.lista = lista;
    }

    private void srediRB() {
        int rb = 1;
        for (StavkaRentiranja stavkaRentiranja : lista) {
            stavkaRentiranja.setRb(rb);
            rb++;
        }
    }

    public void dodaj(StavkaRentiranja sr) {
        lista.add(sr);
        srediRB();
        fireTableDataChanged();
    }

    public void obrisi(int red) {
        lista.remove(red);
        srediRB();
        fireTableDataChanged();
    }
}
