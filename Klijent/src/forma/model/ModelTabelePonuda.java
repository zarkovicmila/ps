/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domen.ZimskaOprema;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milaz
 */
public class ModelTabelePonuda extends AbstractTableModel {

    String[] kolone = {"Vrsta opreme" ,"Proizvodjac","Naziv", "Cena", "Kapacitet", "Raspolozivo", "Uzrast"};
    private ArrayList<ZimskaOprema> lista;

    public ModelTabelePonuda() {
        lista = new ArrayList<>();
    }

    public ModelTabelePonuda(ArrayList<ZimskaOprema> lista) {
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
        ZimskaOprema z = lista.get(row);
        switch (column) {
            case 0:
                return z.getTip(); 
             case 1:
                return z.getProizvodjac();    
            case 2:
                return z.getNaziv();
                
            case 3:
                return z.getCena();
            case 4:
                return z.getKapacitet();
            case 5:
                return z.getRaspolozivo();

            case 6:
                return z.getUzrast();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    public ArrayList<ZimskaOprema> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ZimskaOprema> lista) {
        this.lista = lista;
    }

    public void dodaj(ZimskaOprema zo) {
        lista.add(zo);
        fireTableDataChanged();
    }

    public ZimskaOprema vratiOpremu(int red) {
        return lista.get(red);
    }

}
