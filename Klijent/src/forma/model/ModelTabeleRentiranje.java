/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domen.Rentiranje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milaz
 */
public class ModelTabeleRentiranje extends AbstractTableModel {

    String[] kolone = {"ID", "Ime", " Prezime", "Datum rentiranja", "Br dana", "Cena", "Status"};
    private ArrayList<Rentiranje> lista;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleRentiranje() {
        lista = new ArrayList<>();
    }

    public ModelTabeleRentiranje(ArrayList<Rentiranje> lista) {
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
        Rentiranje r = lista.get(row);
        switch (column) {
            case 0:
                return r.getRentaID();
            case 1:
                return r.getKlijent().getIme();
            case 2:
                return r.getKlijent().getPrezime();
            case 3:
                return sdf.format(r.getDatum());    
            case 4:
                return r.getBrojDana();
            case 5:
                return r.getUkupnaCena();
            case 6:
                return r.isStatus();
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 6:
                return Boolean.class;

            default:
                return String.class;
        }
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    public ArrayList<Rentiranje> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Rentiranje> lista) {
        this.lista = lista;
    }

    public Rentiranje obrisiRentiranje(int red) {
       Rentiranje r = lista.get(red);
    //   lista.remove(red);
       fireTableDataChanged();
       return r;
    }

}
