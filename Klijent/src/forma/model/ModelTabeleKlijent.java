/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domen.Klijent;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milaz
 */
public class ModelTabeleKlijent extends AbstractTableModel {

    String[] kolone = {"JMBG", "Ime", "Prezime", "Telefon", "Email"};
    private ArrayList<Klijent> lista;

    public ModelTabeleKlijent() {
        lista = new ArrayList<>();
    }

    public ModelTabeleKlijent(ArrayList<Klijent> lista) {
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
        Klijent k = lista.get(row);
        switch (column) {
            case 0:
                return k.getJmbg();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();

            case 3:
                return k.getTelefon();
            case 4:
                return k.getEmail();

            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    public Klijent vratiKlijenta(int red) {
        return lista.get(red);
    }

}
