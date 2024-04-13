/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboPopup;
/**
 *
 * @author Raymond Setiono
 */
public class CheckoutTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form CheckoutTransaksi
     */
    Meja mejaIni;
    mejaTrans parent;
    TakeAway parentTakeAway;
    String noNota = "";
    public static boolean tampil;
    String tipe = ""; 
    
    public CheckoutTransaksi(Meja m, TakeAway t) {
        tampil = true;
        initComponents();
        setIconImage((new ImageIcon(Login.logoApp)).getImage());
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 55, 55));
        mejaIni = m;
        parentTakeAway = t;
        jPanel1.setFocusable(true);
        FrameDragListener frameDragListener = new FrameDragListener(this);
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);
        this.pack();
        settingWarnaComboBox();
        lblNoNota.setText("Nomor Nota : "+Transaction.generateNomorNota());
        if (m.getNomerMeja() == 99) {
            lblNoMeja.setText("Nomor Meja : Take away");
            tipe = "take away";
        }
        else{
            lblNoMeja.setText("Nomor Meja : "+m.getNomerMeja());
            tipe = "dine in";
        }
        
        for (int i = 0; i < m.getListPesanan().size(); i++) {
            txtDetail.append(m.getListPesanan().get(i)+"\n"); 
        }
        txtDetail.append("--------------------------------\n"); 
        txtDetail.append("Total : Rp"+mejaIni.getTotal());
    }
    
    public CheckoutTransaksi(Meja m, mejaTrans f) {
        tampil = true;
        initComponents();setIconImage((new ImageIcon(Login.logoApp)).getImage());
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 55, 55));
        mejaIni = m;
        jPanel1.setFocusable(true);
        FrameDragListener frameDragListener = new FrameDragListener(this);
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);
        this.pack();
        settingWarnaComboBox();
        parent = f;
        lblNoNota.setText("Nomor Nota : "+Transaction.generateNomorNota());
        lblNoMeja.setText("Nomor Meja : "+m.getNomerMeja());  
         
        for (int i = 0; i < m.getListPesanan().size(); i++) {
            txtDetail.append(m.getListPesanan().get(i)+"\n"); 
        }
        txtDetail.append("--------------------------------\n"); 
        txtDetail.append("Total : Rp"+mejaIni.getTotal());
    }
    
    public CheckoutTransaksi() {
        initComponents();setIconImage((new ImageIcon(Login.logoApp)).getImage());
        jPanel1.setFocusable(true);
        FrameDragListener frameDragListener = new FrameDragListener(this);
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);
        this.pack();
        settingWarnaComboBox();
    }
    
    public void settingWarnaComboBox(){ 
        Object child = cbbMetode.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup = (BasicComboPopup)child;
        JList list = popup.getList();
        list.setSelectionBackground(new Color(0,239,173));
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
        txtDetail = new javax.swing.JTextArea();
        lblNoNota = new javax.swing.JLabel();
        lblNoMeja = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCheckout = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbMetode = new javax.swing.JComboBox<>();
        lblMinimize = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(26, 50, 90));

        txtDetail.setEditable(false);
        txtDetail.setColumns(20);
        txtDetail.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        txtDetail.setRows(5);
        jScrollPane1.setViewportView(txtDetail);

        lblNoNota.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        lblNoNota.setForeground(new java.awt.Color(255, 255, 255));
        lblNoNota.setText("Nomor Nota : ");
        lblNoNota.setName("label_nomernota"); // NOI18N

        lblNoMeja.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        lblNoMeja.setForeground(new java.awt.Color(255, 255, 255));
        lblNoMeja.setText("Nomor Meja : ");
        lblNoMeja.setName("label_nomormeja"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Metode Pembayaran : ");

        btnCheckout.setBackground(new java.awt.Color(0, 239, 173));
        btnCheckout.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnCheckout.setForeground(new java.awt.Color(0, 0, 0));
        btnCheckout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/bill.png"))); // NOI18N
        btnCheckout.setText(" Checkout");
        btnCheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCheckoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCheckoutMouseExited(evt);
            }
        });
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Checkout Pembayaran");

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/close v2.png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/logoResto.png"))); // NOI18N
        jLabel2.setText("  Resto Ga Kenyang Ga Pulang");

        cbbMetode.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        cbbMetode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tunai", "Go-Pay", "Ovo", "ShopeePay", "Dana", "LinkAja" }));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMinimize)
                .addGap(18, 18, 18)
                .addComponent(lblExit)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNoNota)
                            .addComponent(lblNoMeja)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblExit)
                    .addComponent(lblMinimize))
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(lblNoNota)
                .addGap(27, 27, 27)
                .addComponent(lblNoMeja)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbMetode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        try {
            noNota = Transaction.generateNomorNota();
            Transaction.insertTableHTrans(noNota, cbbMetode.getSelectedItem().toString(), mejaIni.getTotal(), Karyawan.getId(), mejaIni.getNomerMeja());
            for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                Transaction.insertTableDTrans(noNota, mejaIni.getListPesanan().get(i).getIdMenu(), 
                        mejaIni.getListPesanan().get(i).getQuantity(), mejaIni.getListPesanan().get(i).getHarga());
            } 
                JOptionPane.showMessageDialog(this,  "Berhasil Checkout", "Success!",
                        JOptionPane.INFORMATION_MESSAGE, 
                  new ImageIcon(Login.logoChef));
                
            int choose = JOptionPane.showConfirmDialog(this, 
                   "Cetak nota?",
                   "Nota", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Login.logoQuestion));   
            if (choose == 0) { 
                cetakNota(noNota); 
                JOptionPane.showMessageDialog(this, "Berhasil cetak nota", "Success!", JOptionPane.INFORMATION_MESSAGE, 
                new ImageIcon(Login.logoChef));   
            }
            mejaIni.getListPesanan().clear();
            this.dispose();
            if (!(tipe.equals("take away"))) {
                //Refresh meja sesuai kondisi
                parent.refreshForm();
                parent.setLocationRelativeTo(null);
            }
            else{ 
                parentTakeAway.setLocationRelativeTo(null);
                parentTakeAway.clearCart();
            }
            tampil = false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Gagal!", JOptionPane.INFORMATION_MESSAGE, 
                      new ImageIcon(Login.logoError));  
        }
    }//GEN-LAST:event_btnCheckoutActionPerformed
    private void cetakNota(String noNota){ 
        try { 
            FileWriter laporan = new FileWriter("Nota Penjualan\\Nota Penjualan "+noNota+".txt");
            BufferedWriter bfw = new BufferedWriter(laporan); 
            bfw.write("        \"Resto Gak Kenyang Gak Pulang\""); bfw.newLine();
            bfw.write("           Jl Maju Mundur Nomor 20");  bfw.newLine();
            bfw.write("                  Surabaya"); bfw.newLine();
            bfw.write("             Telp. 081234567890");  bfw.newLine();
            bfw.write("  .........................................");  bfw.newLine();
            bfw.write("  Nota     : "+noNota);  bfw.newLine();
            bfw.write("  Kasir    : "+Karyawan.getNama());  bfw.newLine();
            bfw.write("  Tanggal  : "+LocalDateTime.now().toString().substring(0,10));  bfw.newLine();
            bfw.write("  Metode   : "+cbbMetode.getSelectedItem().toString());  bfw.newLine();
            String nom = "-";
            if (mejaIni.getNomerMeja()!=99) {
                nom = mejaIni.getNomerMeja()+"";
            } 
            bfw.write("  No Meja  : "+nom);  bfw.newLine();
            bfw.newLine();
            if (mejaIni.getNomerMeja()==99) {
                bfw.write("  Take-Away");  bfw.newLine(); 
            }else {
                bfw.write("  Dine-In");  bfw.newLine();  
            }
            for (int i = 0; i < mejaIni.getListPesanan().size(); i++) { 
                bfw.write("     "+mejaIni.getListPesanan().get(i).toString());  bfw.newLine(); 
            }
            bfw.write("  .........................................");  bfw.newLine();
            bfw.write("     TOTAL            "+mejaIni.getTotal());  bfw.newLine(); 
            bfw.newLine(); 
            bfw.write("              TERIMA KASIH");  bfw.newLine(); 
            bfw.close(); 
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, exc.getMessage()+"\nPlease call the technician", 
                    "System Error", JOptionPane.INFORMATION_MESSAGE, 
                      new ImageIcon(Login.logoError));  
            
        }
    }
    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
//        mejaTrans f = new mejaTrans(); 
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
        tampil = false;
        this.dispose();
        if (!(tipe.equals("take away"))) {
            parent.refreshForm();
            parent.setLocationRelativeTo(null);
        }
        else{
            parentTakeAway.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_lblExitMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         
    }//GEN-LAST:event_formWindowActivated

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void btnCheckoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckoutMouseEntered
         btnCheckout.setBackground(new Color(0,220,120)); 
    }//GEN-LAST:event_btnCheckoutMouseEntered

    private void btnCheckoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckoutMouseExited
       btnCheckout.setBackground(new Color(0,239,173)); 
    }//GEN-LAST:event_btnCheckoutMouseExited

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
            java.util.logging.Logger.getLogger(CheckoutTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckoutTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckoutTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckoutTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckoutTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckout;
    private javax.swing.JComboBox<String> cbbMetode;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblNoMeja;
    private javax.swing.JLabel lblNoNota;
    private javax.swing.JTextArea txtDetail;
    // End of variables declaration//GEN-END:variables
}