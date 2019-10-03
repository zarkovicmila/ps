/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domen.Korisnik;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milaz
 */
public class ModelTabeleUlogovani extends AbstractTableModel {

    String[] kolone = {"Ime i prezime", "Korisnicko ime", "Telefon"};
    private ArrayList<Korisnik> korisnici;

    public ModelTabeleUlogovani() {
        korisnici = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Korisnik k = korisnici.get(row);
        switch (column) {
            case 0:
                return k.getIme() + " " + k.getPrezime();
            case 1:
                return k.getKorisnickoIme();
            case 2:
                return k.getTelefon();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    public ArrayList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ArrayList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public void dodaj(Korisnik k) {
        korisnici.add(k);
        fireTableDataChanged();
    }

    public void obrisi(Korisnik k) {
        korisnici.remove(k);
        fireTableDataChanged();
    }

    public void odjaviSe(Korisnik k) {
        korisnici.remove(k);
        fireTableDataChanged();
    }

    public void obrisiSve() {
        this.korisnici = new ArrayList<>();
    }

}
