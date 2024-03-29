/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.ponuda;

import domen.Proizvodjac;
import domen.TipOpreme;
import domen.ZimskaOprema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author milaz
 */
public class UnosPonudeFrm extends javax.swing.JFrame {

    /**
     * Creates new form UnosPonudeFrm
     */
    public UnosPonudeFrm() {
        initComponents();
        vratiTipOpreme();
        vratiProizvodjace();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbTipOpreme = new javax.swing.JComboBox();
        cmbProizvodjac = new javax.swing.JComboBox();
        txtNaziv = new javax.swing.JTextField();
        txtKapacitet = new javax.swing.JTextField();
        txtCena = new javax.swing.JTextField();
        cmbUzrast = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos nove opreme"));

        jLabel1.setText("Tip opreme:");

        jLabel2.setText("Proizvodjac:");

        jLabel3.setText("Naziv:");

        jLabel4.setText("Cena:");

        jLabel5.setText("Kapacitet:");

        jLabel6.setText("Uzrast:");

        cmbTipOpreme.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbProizvodjac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbUzrast.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "odrasli", "deca" }));

        jButton1.setText("Dodaj u ponudu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbUzrast, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKapacitet)
                    .addComponent(cmbTipOpreme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbProizvodjac, 0, 254, Short.MAX_VALUE)
                    .addComponent(txtNaziv)
                    .addComponent(txtCena, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTipOpreme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbProizvodjac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKapacitet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbUzrast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TipOpreme tip = (TipOpreme) cmbTipOpreme.getSelectedItem();
        Proizvodjac proizvodjac = (Proizvodjac) cmbProizvodjac.getSelectedItem();
        String uzras = (String) cmbUzrast.getSelectedItem();
        String naziv = txtNaziv.getText().trim();
         if (naziv.isEmpty() || txtCena.getText().isEmpty() || txtKapacitet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
            return;
        }
        BigDecimal cena = new BigDecimal(txtCena.getText());
        int kapacitet = Integer.parseInt(txtKapacitet.getText());
        

        if (cena.compareTo(new BigDecimal(0)) > 0 && kapacitet > 0) {
            try {
                ZimskaOprema zo = new ZimskaOprema(0, tip, naziv, cena, kapacitet, uzras, proizvodjac);
                Kontroler.getInstanca().unosNoveOpreme(zo);
                JOptionPane.showMessageDialog(this, "Nova oprema je ubacena u ponudu!");
                txtCena.setText("");
                txtKapacitet.setText("");
                txtNaziv.setText("");
                JOptionPane.showMessageDialog(this, "Uspesno ste uneli opremu!");
                return;
            } catch (Exception ex) {
                Logger.getLogger(UnosPonudeFrm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Cena i kapacitet moraju biti veci od nule!");
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbProizvodjac;
    private javax.swing.JComboBox cmbTipOpreme;
    private javax.swing.JComboBox<String> cmbUzrast;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtKapacitet;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void vratiTipOpreme() {
        try {
            ArrayList<TipOpreme> lista = Kontroler.getInstanca().vratiTipOpreme();
            cmbTipOpreme.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(UnosPonudeFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void vratiProizvodjace() {
        try {
            ArrayList<Proizvodjac> lista = Kontroler.getInstanca().vratiProizvodjace();
            cmbProizvodjac.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(UnosPonudeFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
