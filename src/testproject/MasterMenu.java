/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Michael Kevin
 */
public class MasterMenu extends javax.swing.JFrame {

    /**
     * Creates new form MasterMenu
     */
    
    String nama, kategori;
    int harga, status, id;
    String mode = "";
    
    public MasterMenu() {
        initComponents(); setIconImage((new ImageIcon(Login.logoApp)).getImage());
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 55, 55));
        jPanel1.setFocusable(true);
        FrameDragListener frameDragListener = new FrameDragListener(this);
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);
        settingTabel();
        settingWarnaComboBox();
        mode = "insert";
        lblURL.setText(""); 
    }
    public void setImage(String loc){ 
        ImageIcon icon = new ImageIcon(loc);
        Image img = icon.getImage(); 
        Image imgScale = img.getScaledInstance(lblGambar.getWidth(), 
                lblGambar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        lblGambar.setIcon(scaledIcon);  
    } 
    public void settingTabel(){
        tabelMenu.getTableHeader().setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
        tabelMenu.getTableHeader().setOpaque(false);
        tabelMenu.getTableHeader().setBackground(new Color(255, 255, 255));
        tabelMenu.getTableHeader().setForeground(new Color(0, 0, 0));
        tabelMenu.setRowHeight(25);
        tabelMenu.setModel(DB.getTabelMenu(cmbCariKategori.getSelectedItem().toString(), txtCariNama.getText()));
        tabelMenu.getColumnModel().getColumn(0).setMaxWidth(80);
        tabelMenu.getTableHeader().setResizingAllowed(false);
        tabelMenu.setDefaultEditor(Object.class, null);
    }
    
    public void getData(){
        nama = txtNama.getText();
        kategori = cmbKategori.getSelectedItem().toString();
        harga = Integer.parseInt(nudHarga.getValue().toString());
        if (!(txtID.getText().equals(""))) {
            id = Integer.parseInt(txtID.getText());
        }
//        if (radAvailable.isSelected()) {
//            status = 1;
//        }
//        else{
//            status = 0;
//        }
    }
    
    public void resetAll(){
        txtNama.setText("");
        try {   
            setImage("src\\testproject\\images\\Makanan\\x.jpg"); 
        } catch (Exception exc) {
            System.out.println(""+exc.getMessage());
        }
        txtID.setText("");
        nudHarga.setValue(0);
        //radAvailable.setSelected(true);
        cmbKategori.setSelectedIndex(0);
        //txtCariNama.setText("");
        mode = "insert";
        lblURL.setText(""); 
        //refreshTabel();
    }
    
    public void refreshTabel(){
        try { 
            Menu.initMenu();
        } catch (Exception exc) {
            System.out.println(""+exc.getMessage()); 
        }
        tabelMenu.setModel(DB.getTabelMenu(cmbCariKategori.getSelectedItem().toString(), txtCariNama.getText()));
        settingTabel();
    }
    
    public void settingWarnaComboBox(){
        Object child = cmbKategori.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup = (BasicComboPopup)child;
        JList list = popup.getList();
        list.setSelectionBackground(new Color(0,239,173));
        
        Object child2 = cmbCariKategori.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup2 = (BasicComboPopup)child2;
        JList list2 = popup2.getList();
        list2.setSelectionBackground(new Color(0,239,173));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblExit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMenu = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        cmbKategori = new javax.swing.JComboBox<>();
        nudHarga = new javax.swing.JSpinner();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbCariKategori = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCariNama = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblGambar = new javax.swing.JLabel();
        btnFindImage = new javax.swing.JButton();
        lblURL = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(26, 50, 90));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/close v2.png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        jPanel1.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 16, -1, -1));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Master Menu");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 98, -1, -1));

        tabelMenu.setBackground(new java.awt.Color(204, 204, 204));
        tabelMenu.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        tabelMenu.setForeground(new java.awt.Color(0, 0, 0));
        tabelMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelMenu.setRowHeight(25);
        tabelMenu.setSelectionBackground(new java.awt.Color(0, 239, 173));
        tabelMenu.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelMenu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 920, 385));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Harga : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 862, -1, -1));

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Menu :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 703, -1, -1));

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nama Menu :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 760, -1, -1));

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kategori :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 813, -1, -1));

        txtID.setEditable(false);
        txtID.setBackground(new java.awt.Color(26, 50, 90));
        txtID.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setMargin(new java.awt.Insets(0, 5, 0, 5));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 699, 162, -1));

        txtNama.setBackground(new java.awt.Color(26, 50, 90));
        txtNama.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        txtNama.setForeground(new java.awt.Color(255, 255, 255));
        txtNama.setMargin(new java.awt.Insets(0, 5, 0, 5));
        jPanel1.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 756, 229, -1));

        cmbKategori.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Makanan", "Minuman", "Snack" }));
        jPanel1.add(cmbKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 808, 229, -1));

        nudHarga.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jPanel1.add(nudHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 857, 230, -1));

        btnClear.setBackground(new java.awt.Color(255, 255, 153));
        btnClear.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 0, 0));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/clear.png"))); // NOI18N
        btnClear.setText("  Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 940, 176, 57));

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/delete.png"))); // NOI18N
        btnDelete.setText(" Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 940, 175, 57));

        btnUpdate.setBackground(new java.awt.Color(0, 239, 173));
        btnUpdate.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/update.png"))); // NOI18N
        btnUpdate.setText("  Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 940, 176, 57));

        btnInsert.setBackground(new java.awt.Color(0, 239, 173));
        btnInsert.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(0, 0, 0));
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/insert.png"))); // NOI18N
        btnInsert.setText("  Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 940, 162, 57));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/logoResto.png"))); // NOI18N
        jLabel2.setText("  Resto Ga Kenyang Ga Pulang");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 16, -1, -1));

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cari berdasarkan :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 174, -1, -1));

        cmbCariKategori.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        cmbCariKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Makanan", "Minuman", "Snack" }));
        jPanel1.add(cmbCariKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 218, 229, -1));

        btnSearch.setBackground(new java.awt.Color(0, 239, 173));
        btnSearch.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(0, 0, 0));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/search.png"))); // NOI18N
        btnSearch.setText(" Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 218, 130, 29));

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nama :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 223, -1, -1));

        txtCariNama.setBackground(new java.awt.Color(26, 50, 90));
        txtCariNama.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        txtCariNama.setForeground(new java.awt.Color(255, 255, 255));
        txtCariNama.setMargin(new java.awt.Insets(0, 5, 0, 5));
        jPanel1.add(txtCariNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 219, 190, -1));

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pilih kategori :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 223, -1, -1));

        lblGambar.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        lblGambar.setForeground(new java.awt.Color(255, 255, 255));
        lblGambar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblGambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 700, 172, 133));

        btnFindImage.setBackground(new java.awt.Color(0, 239, 173));
        btnFindImage.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        btnFindImage.setForeground(new java.awt.Color(0, 0, 0));
        btnFindImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/search.png"))); // NOI18N
        btnFindImage.setText("Choose Image");
        btnFindImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindImageActionPerformed(evt);
            }
        });
        jPanel1.add(btnFindImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 700, 190, 40));

        lblURL.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        lblURL.setForeground(new java.awt.Color(255, 255, 255));
        lblURL.setText("url");
        jPanel1.add(lblURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 850, -1, -1));

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/minimize4.png"))); // NOI18N
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
        });
        jPanel1.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 18, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        FormPenghubung f = new FormPenghubung();
        f.setTitle("Ga Kenyang Ga Pulang");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblExitMouseClicked

    private void tabelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMenuMouseClicked
        int idx = tabelMenu.getSelectedRow();
        mode = "edit";
        if (idx >= 0 && idx < tabelMenu.getRowCount()){
            txtID.setText(DB.getTabelMenu(cmbCariKategori.getSelectedItem().toString(), txtCariNama.getText()).getValueAt(idx, 0).toString());
            txtNama.setText(DB.getTabelMenu(cmbCariKategori.getSelectedItem().toString(), txtCariNama.getText()).getValueAt(idx, 1).toString());
            nudHarga.setValue(Integer.parseInt(DB.getTabelMenu(cmbCariKategori.getSelectedItem().toString(), txtCariNama.getText()).getValueAt(idx, 2).toString()));
//            String status = DB.getTabelMenu(cmbCariKategori.getSelectedItem().toString(), txtCariNama.getText()).getValueAt(idx, 4).toString();
//            if (status.equals("Available")) {
//                radAvailable.setSelected(true);
//                radNotAvailable.setSelected(false);
//            }
//            else{
//                radAvailable.setSelected(false);
//                radNotAvailable.setSelected(true);
//            }
            String kategori = DB.getTabelMenu(cmbCariKategori.getSelectedItem().toString(), txtCariNama.getText()).getValueAt(idx, 3).toString();
            if (kategori.equals("Makanan")) {
                cmbKategori.setSelectedIndex(0);
            }
            else if (kategori.equals("Minuman")) {
                cmbKategori.setSelectedIndex(1);
            }
            else{
                cmbKategori.setSelectedIndex(2);
            }
            try {   
//                setImage("src\\testproject\\images\\Makanan\\"+txtNama.getText()+".jpg"); 
                int find = Menu.findByNama(txtNama.getText());
                setImage(Menu.listMenu.get(find).getImageURL());    
                lblURL.setText(Menu.listMenu.get(find).getImageURL()); 
            } catch (Exception exc) {
                System.out.println(""+exc.getMessage());
            }
        }
    }//GEN-LAST:event_tabelMenuMouseClicked

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (mode.equals("insert")) {
            getData();
            try {
                String url = lblURL.getText();
                Menu.insertTableMenu(nama, kategori, harga, 1, url); 
                refreshTabel();
                JOptionPane.showMessageDialog(this, "Berhasil Insert!", "Success!", JOptionPane.INFORMATION_MESSAGE, 
                new ImageIcon(Login.logoCheck));  
                resetAll();
            } catch (Exception e) { 
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE, 
                new ImageIcon(Login.logoError));  
            }
        }
        else{ 
            JOptionPane.showMessageDialog(this, "Bukan sedang dalam mode Insert!", "WARNING!", JOptionPane.INFORMATION_MESSAGE, 
            new ImageIcon(Login.logoWarning));  
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (mode.equals("edit")) {
            getData();
            try {
                String url = lblURL.getText();
                Menu.updateTableMenu(id, nama, harga, kategori, 1, url);  
                refreshTabel();
                JOptionPane.showMessageDialog(this, "Berhasil Update!", "Success!", JOptionPane.INFORMATION_MESSAGE, 
                new ImageIcon(Login.logoCheck));  
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE, 
                new ImageIcon(Login.logoError));  
            }
            resetAll();
        }
        else{ 
            JOptionPane.showMessageDialog(this, "Bukan sedang dalam mode Edit!", "WARNING!", JOptionPane.INFORMATION_MESSAGE, 
            new ImageIcon(Login.logoWarning));  
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (mode.equals("edit")) {
            getData();
            int choice = JOptionPane.showConfirmDialog(this, "Yakin hapus item?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(Login.logoQuestion));
            if (choice == 0){
                try {
                    Menu.deleteTableMenu(id); 
                    refreshTabel();
                    JOptionPane.showMessageDialog(this, "Berhasil Delete!", "Success!", JOptionPane.INFORMATION_MESSAGE, 
                    new ImageIcon(Login.logoCheck));  
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE, 
                    new ImageIcon(Login.logoError));  
                }
                resetAll();
            }
        }
        else{ 
            JOptionPane.showMessageDialog(this, "Bukan sedang dalam mode Edit!", "WARNING!", JOptionPane.INFORMATION_MESSAGE, 
            new ImageIcon(Login.logoWarning));  
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        resetAll();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        refreshTabel();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnFindImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindImageActionPerformed
        // TODO add your handling code here:
        JFileChooser d = new JFileChooser();
        d.setCurrentDirectory(new File("src\\testproject\\images\\save.png")); 
        int result = d.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String url1 = d.getSelectedFile().getPath();
            String[] listchar = url1.split("\\\\");  
            int idx = -1;
            for (int i = 0; i < listchar.length; i++) { 
                if (listchar[i].equals("src")) {
                     idx = i; 
                }
            }
            url1 = "";
            for (int i = idx; i < listchar.length; i++) {
                if (i<listchar.length-1) {  
                    url1 += listchar[i]+"\\";
                }else {
                     url1 += listchar[i];
                }
            } 
            lblURL.setText(url1); 
            setImage(url1); 
//            lblURL.setText(d.getSelectedFile().getPath()); 
        }
    }//GEN-LAST:event_btnFindImageActionPerformed

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

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
            java.util.logging.Logger.getLogger(MasterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFindImage;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCariKategori;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblGambar;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblURL;
    private javax.swing.JSpinner nudHarga;
    private javax.swing.JTable tabelMenu;
    private javax.swing.JTextField txtCariNama;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}