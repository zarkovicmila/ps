/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.rentiranje;

import domen.Klijent;
import domen.Proizvodjac;
import domen.Rentiranje;
import domen.StavkaRentiranja;
import domen.TipOpreme;
import domen.ZimskaOprema;
import forma.model.ModelTabelePonuda;
import forma.model.ModelTabeleStavke;
import forme.klijent.PretragaKlijentaDijalog;
import forme.ponuda.UnosPonudeFrm;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author milaz
 */
public class RentiranjeFrm extends javax.swing.JFrame {

    private Klijent klijent;

    /**
     * Creates new form RentiranjeFrm
     */
    public RentiranjeFrm() {
        initComponents();
        vratiTipOpreme();
        vratiProizvodjace();
        srediTabelu();
        srediTabeluStavki();
        panelKlijent.setVisible(false);
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
        txtIme.setText(klijent.getIme());
        txtPrezime.setText(klijent.getPrezime());
        panelKlijent.setVisible(true);
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
        btnDodajStavku = new javax.swing.JButton();
        cmbTipOpreme = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cmbProizvodjac = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbUzrast = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        spinerKolicina = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaStavke = new javax.swing.JTable();
        btnObrisiStavku = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBrojDana = new javax.swing.JTextField();
        txtDatum = new javax.swing.JTextField();
        btnSacuvajRez = new javax.swing.JButton();
        panelKlijent = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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

        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
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

        jLabel4.setText("Kolicina:");

        spinerKolicina.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
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
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbUzrast, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinerKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipOpreme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbProizvodjac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbUzrast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajStavku)
                    .addComponent(spinerKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(133, 133, 133))
        );

        tabelaStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaStavke);

        btnObrisiStavku.setText("Obrisi stavku");
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Rentiranje"));

        jLabel5.setText("Klijent:");

        jButton2.setText("Izaberi klijenta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Datum:");

        jLabel7.setText("Broj dana:");

        txtBrojDana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrojDanaActionPerformed(evt);
            }
        });

        btnSacuvajRez.setText("Sacuvaj ");
        btnSacuvajRez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajRezActionPerformed(evt);
            }
        });

        panelKlijent.setBorder(javax.swing.BorderFactory.createTitledBorder("Izabran klijent"));

        jLabel9.setText("Ime:");

        jLabel10.setText("Prezime:");

        txtIme.setEnabled(false);

        txtPrezime.setEnabled(false);

        javax.swing.GroupLayout panelKlijentLayout = new javax.swing.GroupLayout(panelKlijent);
        panelKlijent.setLayout(panelKlijentLayout);
        panelKlijentLayout.setHorizontalGroup(
            panelKlijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKlijentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKlijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKlijentLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(36, 36, 36)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelKlijentLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelKlijentLayout.setVerticalGroup(
            panelKlijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKlijentLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelKlijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelKlijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSacuvajRez, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBrojDana, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(txtDatum)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(43, 43, 43)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jButton2))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtBrojDana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnSacuvajRez)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnObrisiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnObrisiStavku)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            if (!(cmbTipOpreme.getSelectedItem() instanceof TipOpreme) && !(cmbProizvodjac.getSelectedItem() instanceof Proizvodjac) && cmbUzrast.getSelectedItem().equals("-")) {
                tabelaPonude.setModel(new ModelTabelePonuda(raspolozivo(Kontroler.getInstanca().getPonude())));
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

            tabelaPonude.setModel(new ModelTabelePonuda(raspolozivo(lista)));

        } catch (Exception ex) {
            Logger.getLogger(RentiranjeFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed
        int red = tabelaStavke.getSelectedRow();
        if (red != -1) {
            ModelTabeleStavke mts = (ModelTabeleStavke) tabelaStavke.getModel();
            mts.obrisi(red);

        } else {
            JOptionPane.showMessageDialog(this, "Morate selektovati red u tabeli stavki!");
            return;
        }
    }//GEN-LAST:event_btnObrisiStavkuActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        int red = tabelaPonude.getSelectedRow();
        if (red != -1) {
            int kolicina = (int) spinerKolicina.getValue();
            ModelTabelePonuda mt = (ModelTabelePonuda) tabelaPonude.getModel();
            ZimskaOprema zo = mt.vratiOpremu(red);
            if (zo.getRaspolozivo() < kolicina) {
                JOptionPane.showMessageDialog(this, "Nije moguce iznajmiti opremu.\nOprema: "+zo.getNaziv()+"\nRaspolozivo: "+zo.getRaspolozivo());
                return;
            }
            BigDecimal cena = BigDecimal.valueOf(kolicina).multiply(zo.getCena());
            StavkaRentiranja sr = new StavkaRentiranja(0, cena, kolicina, zo);
            ModelTabeleStavke mts = (ModelTabeleStavke) tabelaStavke.getModel();
            mts.dodaj(sr);

        } else {
            JOptionPane.showMessageDialog(this, "Morate selektovati red u tabeli ponuda!");
            return;
        }
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PretragaKlijentaDijalog frm = new PretragaKlijentaDijalog(this, false);
        frm.setLocationRelativeTo(null);
        frm.pack();
        frm.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSacuvajRezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajRezActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ModelTabeleStavke mts = (ModelTabeleStavke) tabelaStavke.getModel();
        ArrayList<StavkaRentiranja> lista = mts.getLista();
        if (lista.size() == 0) {
            JOptionPane.showMessageDialog(this, "Niste izabrali opremu za iznajmljivanje.");
            return;
        }
        if (klijent == null) {
            JOptionPane.showMessageDialog(this, "Morate izabrati klijenta.");
            return;
        }
        int brDana = new Integer(txtBrojDana.getText().trim());
        BigDecimal ukupnaCena = BigDecimal.valueOf(0);
        for (StavkaRentiranja stavkaRentiranja : lista) {
            ukupnaCena = ukupnaCena.add(BigDecimal.valueOf(stavkaRentiranja.getKolicina()).multiply(stavkaRentiranja.getCena()));
        }
        try {
            Date datum = sdf.parse(txtDatum.getText());
            if (brDana > 0) {
                ukupnaCena = ukupnaCena.multiply(BigDecimal.valueOf(brDana));
                Rentiranje r = new Rentiranje(0, brDana, datum, ukupnaCena, true, lista, klijent);
                Kontroler.getInstanca().rentiranje(r);
                JOptionPane.showMessageDialog(this, "Uspesno iznajmljena oprema! Ukupna cena rentiranja iznosi " + ukupnaCena + " din.");
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Broj dana na koji se iznajmljuje oprema mora biti veci od 0!");
                return;
            }

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Datum mora biti u formatu: dd.MM.yyyy");
            Logger.getLogger(RentiranjeFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(RentiranjeFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajRezActionPerformed

    private void txtBrojDanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrojDanaActionPerformed

    }//GEN-LAST:event_txtBrojDanaActionPerformed

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
            java.util.logging.Logger.getLogger(RentiranjeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentiranjeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentiranjeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentiranjeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentiranjeFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnSacuvajRez;
    private javax.swing.JComboBox cmbProizvodjac;
    private javax.swing.JComboBox cmbTipOpreme;
    private javax.swing.JComboBox<String> cmbUzrast;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelKlijent;
    private javax.swing.JSpinner spinerKolicina;
    private javax.swing.JTable tabelaPonude;
    private javax.swing.JTable tabelaStavke;
    private javax.swing.JTextField txtBrojDana;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
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

    private void srediTabeluStavki() {
        tabelaStavke.setModel(new ModelTabeleStavke());
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