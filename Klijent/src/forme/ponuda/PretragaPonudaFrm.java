/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.ponuda;

import domen.Klijent;
import domen.Proizvodjac;
import domen.Rentiranje;
import domen.StavkaRentiranja;
import domen.TipOpreme;
import domen.ZimskaOprema;
import forma.model.ModelTabelePonuda;
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
public class PretragaPonudaFrm extends javax.swing.JFrame {

    /**
     * Creates new form PretragaPonudaFrm
     */
    public PretragaPonudaFrm() {
        initComponents();
        vratiTipOpreme();
        vratiProizvodjace();
        srediTabelu();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPonude = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cmbTipOpreme = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cmbProizvodjac = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbUzrast = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Trenutno u ponudi"));

        tabelaPonude.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaPonude);

        jButton2.setText("Dodaj novu opremu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Prikazi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cmbTipOpreme.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Tip opreme");

        cmbProizvodjac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Proizvodjac");

        cmbUzrast.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "odrasli", "deca" }));

        jLabel3.setText("Uzrast");

        jButton1.setText("Pretrazi");
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
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipOpreme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cmbProizvodjac, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(308, 347, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbUzrast, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipOpreme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbProizvodjac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbUzrast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(43, 43, 43)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(31, 31, 31))
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
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UnosPonudeFrm frm = new UnosPonudeFrm();
        frm.setLocationRelativeTo(null);
        frm.pack();
        frm.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ArrayList<ZimskaOprema> lista1 = Kontroler.getInstanca().vratiPonudeZimskeOpreme();
            Kontroler.getInstanca().setPonude(lista1);
            if (!(cmbTipOpreme.getSelectedItem() instanceof TipOpreme) && !(cmbProizvodjac.getSelectedItem() instanceof Proizvodjac) && cmbUzrast.getSelectedItem().equals("-")) {
                tabelaPonude.setModel(new ModelTabelePonuda(raspolozivo(lista1)));
                return;
            }
            TipOpreme to = new TipOpreme();
            Proizvodjac p = new Proizvodjac();
            String uzrast = "";
            if (cmbTipOpreme.getSelectedItem() instanceof TipOpreme) {
                to = (TipOpreme) cmbTipOpreme.getSelectedItem();
            }
            if (cmbProizvodjac.getSelectedItem() instanceof Proizvodjac) {
                p = (Proizvodjac) cmbProizvodjac.getSelectedItem();
            }
            if (!cmbUzrast.getSelectedItem().equals("-")) {
                uzrast = (String) cmbUzrast.getSelectedItem();
            }


            ArrayList<ZimskaOprema> lista = new ArrayList<>();
            for (ZimskaOprema zimskaOprema : Kontroler.getInstanca().getPonude()) {
                if ((uzrast.equals(zimskaOprema.getUzrast()) || (!uzrast.equals("odrasli") && !uzrast.equals("deca"))) && (p.equals(zimskaOprema.getProizvodjac()) || p.getProizvodjacID() == 0) && (to.equals(zimskaOprema.getTip()) || to.getTipID() == 0)) {
                    lista.add(zimskaOprema);
                }
            }

//            ArrayList<ZimskaOprema> lista = Kontroler.getInstanca().vratiPonudeZimskeOpremePretraga(zo);
           if(lista.isEmpty()){
                JOptionPane.showMessageDialog(this, "Ne postoje rezultati pretrage.");
            }
            tabelaPonude.setModel(new ModelTabelePonuda(raspolozivo(lista)));
            if(!lista.isEmpty()){
                JOptionPane.showMessageDialog(this, "Sistem je nasao ponude po zadatoj vrednosti.");
            }
        } catch (Exception ex) {
            Logger.getLogger(PretragaPonudaFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int red = tabelaPonude.getSelectedRow();
        if (red != -1) {
            ModelTabelePonuda mt = (ModelTabelePonuda) tabelaPonude.getModel();
            ZimskaOprema zo = mt.vratiOpremu(red);
            PrikazFrm frm = new PrikazFrm(this, false);
            frm.setOprema(zo);
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Morate selektovati red!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PretragaPonudaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PretragaPonudaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PretragaPonudaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PretragaPonudaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PretragaPonudaFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbProizvodjac;
    private javax.swing.JComboBox cmbTipOpreme;
    private javax.swing.JComboBox<String> cmbUzrast;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPonude;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {
        try {
            ArrayList<ZimskaOprema> lista = Kontroler.getInstanca().vratiPonudeZimskeOpreme();
            Kontroler.getInstanca().setPonude(lista);
            tabelaPonude.setModel(new ModelTabelePonuda());
        } catch (Exception ex) {
            Logger.getLogger(UnosPonudeFrm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void vratiTipOpreme() {
        try {
            ArrayList<TipOpreme> lista = Kontroler.getInstanca().vratiTipOpreme();
            cmbTipOpreme.setModel(new DefaultComboBoxModel(lista.toArray()));
            cmbTipOpreme.insertItemAt("", 0);
            cmbTipOpreme.setSelectedIndex(0);
        } catch (Exception ex) {
            Logger.getLogger(UnosPonudeFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void vratiProizvodjace() {
        try {
            ArrayList<Proizvodjac> lista = Kontroler.getInstanca().vratiProizvodjace();
            cmbProizvodjac.setModel(new DefaultComboBoxModel(lista.toArray()));
            cmbProizvodjac.insertItemAt("", 0);
            cmbProizvodjac.setSelectedIndex(0);
        } catch (Exception ex) {
            Logger.getLogger(UnosPonudeFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<ZimskaOprema> raspolozivo(ArrayList<ZimskaOprema> lista) throws Exception {
        Rentiranje r = new Rentiranje();
        r.setKlijent(new Klijent());
        ArrayList<Rentiranje> rentiranja = Kontroler.getInstanca().pretraziRentiranjene(r);
        for (ZimskaOprema zimskaOprema : lista) {
            int broj = 0;
            for (Rentiranje rentiranje : rentiranja) {
                for (StavkaRentiranja stavka : rentiranje.getStavke()) {
                    if (stavka.getOprema().equals(zimskaOprema)) {
                        broj += stavka.getKolicina();
                    }
                }
            }
            zimskaOprema.setRaspolozivo(zimskaOprema.getKapacitet() - broj);
        }
        return lista;
    }
}