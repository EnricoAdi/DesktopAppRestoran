/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Raymond Setiono
 */
public class PrintLaporan extends javax.swing.JFrame {

    /**
     * Creates new form PrintLaporan
     */
    public PrintLaporan() {
        initComponents(); setIconImage((new ImageIcon(Login.logoApp)).getImage());
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 55, 55));
        jPanel1.setFocusable(true);
        FrameDragListener frameDragListener = new FrameDragListener(this);
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);
        this.pack();
        settingTabel();
    }

    public void settingTabel(){
        tabelHeaderLaporan.getTableHeader().setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
        tabelHeaderLaporan.getTableHeader().setOpaque(false);
        tabelHeaderLaporan.getTableHeader().setBackground(new Color(255, 255, 255));
        tabelHeaderLaporan.getTableHeader().setForeground(new Color(0, 0, 0));
        tabelHeaderLaporan.setRowHeight(25);
        tabelHeaderLaporan.getTableHeader().setReorderingAllowed(false);
        tabelHeaderLaporan.getTableHeader().setResizingAllowed(false);
        tabelHeaderLaporan.setDefaultEditor(Object.class, null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKaryawan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        labelPendapatan = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelHeaderLaporan = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        dateChooser_akhir = new com.toedter.calendar.JDateChooser();
        dateChooser_awal = new com.toedter.calendar.JDateChooser();
        lblMinimize = new javax.swing.JLabel();

        tabelKaryawan.setBackground(new java.awt.Color(204, 204, 204));
        tabelKaryawan.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        tabelKaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelKaryawan.setRowHeight(25);
        tabelKaryawan.setSelectionBackground(new java.awt.Color(0, 239, 173));
        tabelKaryawan.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabelKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKaryawan);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(26, 50, 90));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dari");

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cetak Laporan Penjualan");

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tanggal Transaksi :");

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("hingga");

        btnGenerate.setBackground(new java.awt.Color(0, 239, 173));
        btnGenerate.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/preview.png"))); // NOI18N
        btnGenerate.setText(" Preview");
        btnGenerate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerateMouseExited(evt);
            }
        });
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/logoResto.png"))); // NOI18N
        jLabel2.setText("  Resto Ga Kenyang Ga Pulang");

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/close v2.png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });

        labelPendapatan.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        labelPendapatan.setForeground(new java.awt.Color(255, 255, 255));
        labelPendapatan.setText("Total Pendapatan : Rp ");

        tabelHeaderLaporan.setBackground(new java.awt.Color(204, 204, 204));
        tabelHeaderLaporan.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        tabelHeaderLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelHeaderLaporan.setRowHeight(25);
        tabelHeaderLaporan.setSelectionBackground(new java.awt.Color(0, 239, 173));
        tabelHeaderLaporan.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabelHeaderLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelHeaderLaporanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelHeaderLaporan);

        btnCetak.setBackground(new java.awt.Color(0, 239, 173));
        btnCetak.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/printer.png"))); // NOI18N
        btnCetak.setText("Cetak");
        btnCetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCetakMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCetakMouseExited(evt);
            }
        });
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/minimize4.png"))); // NOI18N
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addGap(182, 182, 182)
                        .addComponent(lblMinimize)
                        .addGap(19, 19, 19)
                        .addComponent(lblExit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23)
                        .addComponent(dateChooser_awal, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(dateChooser_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(492, 492, 492)
                        .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelPendapatan)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblMinimize))
                    .addComponent(lblExit))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addGap(11, 11, 11)
                .addComponent(jLabel9)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(dateChooser_awal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(btnGenerate)
                        .addGap(11, 11, 11)
                        .addComponent(labelPendapatan)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooser_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnCetak)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
         try { 
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            //System.out.println(df.format(dateChooser_awal.getDate()) + " - " + df.format(dateChooser_akhir.getDate()));
            if (dateChooser_awal.getDate() == null || dateChooser_akhir.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Semua field harus sudah terisi!", "Gagal Generate Laporan!", JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(Login.logoWarning));
            }
            else{
                tabelHeaderLaporan.setModel(DB.tabelHeaderLaporan(df.format(dateChooser_awal.getDate()), df.format(dateChooser_akhir.getDate()))); 
                labelPendapatan.setText("Total Pendapatan : Rp "+DB.totalHeaderLaporan(df.format(dateChooser_awal.getDate()), df.format(dateChooser_akhir.getDate())));
            }     
        } catch (Exception exc) { 
            JOptionPane.showMessageDialog(null, exc.getMessage(), "Gagal Generate Laporan!", JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(Login.logoError));
        }
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        FormPenghubung f = new FormPenghubung();
        f.setTitle("Ga Kenyang Ga Pulang");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblExitMouseClicked

    private void tabelKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKaryawanMouseClicked
        
    }//GEN-LAST:event_tabelKaryawanMouseClicked

    private void tabelHeaderLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelHeaderLaporanMouseClicked

    }//GEN-LAST:event_tabelHeaderLaporanMouseClicked

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        try {
            if (labelPendapatan.getText().equals("Total Pendapatan : Rp ")) {
                JOptionPane.showMessageDialog(null, "Lakukan preview terlebih dahulu!", "Gagal Cetak Laporan!", JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(Login.logoWarning));
            }
            else{
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                DB.cetakLaporanPenjualan(df.format(dateChooser_awal.getDate()), df.format(dateChooser_akhir.getDate())); 
                JOptionPane.showMessageDialog(this, "Success!", "Berhasil Mencetak Laporan", JOptionPane.INFORMATION_MESSAGE, 
                new ImageIcon(Login.logoCheck));  
            }
        } catch (Exception exc) {  
            JOptionPane.showMessageDialog(this, exc.getMessage(), "Gagal Cetak Laporan!", JOptionPane.INFORMATION_MESSAGE, 
            new ImageIcon(Login.logoError));  
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void btnGenerateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateMouseEntered
        btnGenerate.setBackground(new Color(0,220,120));
    }//GEN-LAST:event_btnGenerateMouseEntered

    private void btnGenerateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateMouseExited
         btnGenerate.setBackground(new Color(0,239,173)); 
    }//GEN-LAST:event_btnGenerateMouseExited

    private void btnCetakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseEntered
       btnCetak.setBackground(new Color(0,220,120));
    }//GEN-LAST:event_btnCetakMouseEntered

    private void btnCetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseExited
         btnCetak.setBackground(new Color(0,239,173)); 
    }//GEN-LAST:event_btnCetakMouseExited

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
            java.util.logging.Logger.getLogger(PrintLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintLaporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnGenerate;
    private com.toedter.calendar.JDateChooser dateChooser_akhir;
    private com.toedter.calendar.JDateChooser dateChooser_awal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelPendapatan;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JTable tabelHeaderLaporan;
    private javax.swing.JTable tabelKaryawan;
    // End of variables declaration//GEN-END:variables
}
