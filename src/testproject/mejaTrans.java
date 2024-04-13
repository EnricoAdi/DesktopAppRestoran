/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboPopup; 

/**
 *
 * @author Jonathan Bryan
 */
public class mejaTrans extends javax.swing.JFrame {

    /**
     * Creates new form mejaTrans
     */
    Meja mejaIni = null;Timer timer;
    ArrayList<DTrans> cart = new ArrayList<>();
    JPanel[] listPanel = new JPanel[12];
    boolean[] hold = new boolean[12];
    public mejaTrans() {
        initComponents(); setIconImage((new ImageIcon(Login.logoApp)).getImage());  
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 55, 55));
        labelJam.setText(""+LocalDateTime.now().toString().substring(11,19)); 
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelJam.setText(""+LocalDateTime.now().toString().substring(11,19)); 
            } 
        }); 
        timer.start();
        for (int i = 0; i < 12; i++) {
            hold[i] = false; //semua meja belum dipencet awalnya
        }
        
        jList1.setSelectionBackground(new Color(0,239,173));
        jPanel11.setFocusable(true);
        FrameDragListener frameDragListener = new FrameDragListener(this);
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);
        settingWarnaComboBox();
        lblWelcome.setText("Welcome, " + Karyawan.nama);
        
        cdMenu.removeAllItems();
        try {
            Menu.initMenu();
            for (Menu m : Menu.listMenu) {
                //System.out.println(m.getNamaMenu());
                cdMenu.addItem(m.getNamaMenu());
            }
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e.getMessage(), "Gagal!", JOptionPane.INFORMATION_MESSAGE, 
            new ImageIcon(Login.logoError));  
        }
        refreshForm();
        isiPanel();
    }
    private void isiPanel(){ 
        listPanel[0] = meja1; 
        listPanel[1] = meja2; 
        listPanel[2] = meja3; 
        listPanel[3] = meja4; 
        listPanel[4] = meja5; 
        listPanel[5] = meja6; 
        listPanel[6] = meja7; 
        listPanel[7] = meja8; 
        listPanel[8] = meja9; 
        listPanel[9] = meja10; 
        listPanel[10] = meja11; 
        listPanel[11] = meja12; 
    }
    public void refreshForm(){
        if (Meja.listMeja[0].getListPesanan().size()==0) {
            meja1.setBackground(new Color(51,255,102)); 
        }
        else {
            meja1.setBackground(new Color(255,52,52)); 
        }
        if (Meja.listMeja[1].getListPesanan().size()==0) {
            meja2.setBackground(new Color(51,255,102)); 
        }
        else {
            meja2.setBackground(new Color(255,52,52)); 
        }
        if (Meja.listMeja[2].getListPesanan().size()==0) {
            meja3.setBackground(new Color(51,255,102)); 
        }
        else {
            meja3.setBackground(new Color(255,52,52)); 
        }
        if (Meja.listMeja[3].getListPesanan().size()==0) {
            meja4.setBackground(new Color(51,255,102)); 
        }
        else {
            meja4.setBackground(new Color(255,52,52)); 
        }
        if (Meja.listMeja[4].getListPesanan().size()==0) {
            meja5.setBackground(new Color(51,255,102)); 
        }
        else {
            meja5.setBackground(new Color(255,52,52)); 
        }
        if (Meja.listMeja[5].getListPesanan().size()==0) {
            meja6.setBackground(new Color(51,255,102)); 
        }
        else {
            meja6.setBackground(new Color(255,52,52)); 
        }
        if (Meja.listMeja[6].getListPesanan().size()==0) {
            meja7.setBackground(new Color(51,255,102)); 
        }
        else {
            meja7.setBackground(new Color(255,52,52)); 
        }
        if (Meja.listMeja[7].getListPesanan().size()==0) {
            meja8.setBackground(new Color(51,255,102)); 
        }
        else {
            meja8.setBackground(new Color(255,52,52)); 
        }
        if (Meja.listMeja[8].getListPesanan().size()==0) {
            meja9.setBackground(new Color(51,255,102)); 
        }
        else {
            meja9.setBackground(new Color(255,52,52)); 
        }
        if (Meja.listMeja[9].getListPesanan().size()==0) {
            meja10.setBackground(new Color(51,255,102)); 
        }
        else {
            meja10.setBackground(new Color(255,52,52)); 
        }
        
        if (Meja.listMeja[10].getListPesanan().size()==0) {
            meja11.setBackground(new Color(51,255,102)); 
        }
        else {
            meja11.setBackground(new Color(255,52,52)); 
        }
        if (Meja.listMeja[11].getListPesanan().size()==0) {
            meja12.setBackground(new Color(51,255,102)); 
        }
        else {
            meja12.setBackground(new Color(255,52,52)); 
        } 
    
    }
    public void settingWarnaComboBox(){ 
        Object child = cdMenu.getAccessibleContext().getAccessibleChild(0);
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

        jPanel11 = new javax.swing.JPanel();
        meja1 = new javax.swing.JPanel();
        no1 = new javax.swing.JLabel();
        meja2 = new javax.swing.JPanel();
        no2 = new javax.swing.JLabel();
        meja3 = new javax.swing.JPanel();
        no3 = new javax.swing.JLabel();
        meja4 = new javax.swing.JPanel();
        no4 = new javax.swing.JLabel();
        meja5 = new javax.swing.JPanel();
        no5 = new javax.swing.JLabel();
        meja6 = new javax.swing.JPanel();
        no6 = new javax.swing.JLabel();
        meja7 = new javax.swing.JPanel();
        no7 = new javax.swing.JLabel();
        meja8 = new javax.swing.JPanel();
        no8 = new javax.swing.JLabel();
        meja9 = new javax.swing.JPanel();
        no9 = new javax.swing.JLabel();
        meja10 = new javax.swing.JPanel();
        no10 = new javax.swing.JLabel();
        meja11 = new javax.swing.JPanel();
        no11 = new javax.swing.JLabel();
        meja12 = new javax.swing.JPanel();
        no12 = new javax.swing.JLabel();
        pDetail = new javax.swing.JPanel();
        noMeja = new javax.swing.JLabel();
        noMeja1 = new javax.swing.JLabel();
        cdMenu = new javax.swing.JComboBox<>();
        QTY = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        noMeja2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        btnClear1 = new javax.swing.JButton();
        labelJam = new javax.swing.JLabel();
        btnClear2 = new javax.swing.JButton();
        lblMinimize = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(26, 50, 90));
        setUndecorated(true);

        jPanel11.setBackground(new java.awt.Color(26, 50, 90));

        meja1.setBackground(new java.awt.Color(51, 255, 102));
        meja1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        meja1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                meja1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                meja1MouseExited(evt);
            }
        });

        no1.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no1.setForeground(new java.awt.Color(0, 0, 0));
        no1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no1.setText("1");
        no1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja1Layout = new javax.swing.GroupLayout(meja1);
        meja1.setLayout(meja1Layout);
        meja1Layout.setHorizontalGroup(
            meja1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(no1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        meja1Layout.setVerticalGroup(
            meja1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(no1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        meja2.setBackground(new java.awt.Color(51, 255, 102));
        meja2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        no2.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no2.setForeground(new java.awt.Color(0, 0, 0));
        no2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no2.setText("2");
        no2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja2Layout = new javax.swing.GroupLayout(meja2);
        meja2.setLayout(meja2Layout);
        meja2Layout.setHorizontalGroup(
            meja2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(no2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        meja2Layout.setVerticalGroup(
            meja2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(no2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        meja3.setBackground(new java.awt.Color(51, 255, 102));
        meja3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        no3.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no3.setForeground(new java.awt.Color(0, 0, 0));
        no3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no3.setText("3");
        no3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja3Layout = new javax.swing.GroupLayout(meja3);
        meja3.setLayout(meja3Layout);
        meja3Layout.setHorizontalGroup(
            meja3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(no3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        meja3Layout.setVerticalGroup(
            meja3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(no3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        meja4.setBackground(new java.awt.Color(51, 255, 102));
        meja4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        meja4.setForeground(new java.awt.Color(255, 255, 255));

        no4.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no4.setForeground(new java.awt.Color(0, 0, 0));
        no4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no4.setText("4");
        no4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja4Layout = new javax.swing.GroupLayout(meja4);
        meja4.setLayout(meja4Layout);
        meja4Layout.setHorizontalGroup(
            meja4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(no4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        meja4Layout.setVerticalGroup(
            meja4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(no4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        meja5.setBackground(new java.awt.Color(51, 255, 102));
        meja5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        no5.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no5.setForeground(new java.awt.Color(0, 0, 0));
        no5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no5.setText("5");
        no5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja5Layout = new javax.swing.GroupLayout(meja5);
        meja5.setLayout(meja5Layout);
        meja5Layout.setHorizontalGroup(
            meja5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(meja5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no5, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        );
        meja5Layout.setVerticalGroup(
            meja5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(meja5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        meja6.setBackground(new java.awt.Color(51, 255, 102));
        meja6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        no6.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no6.setForeground(new java.awt.Color(0, 0, 0));
        no6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no6.setText("6");
        no6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja6Layout = new javax.swing.GroupLayout(meja6);
        meja6.setLayout(meja6Layout);
        meja6Layout.setHorizontalGroup(
            meja6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(meja6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        );
        meja6Layout.setVerticalGroup(
            meja6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(meja6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        meja7.setBackground(new java.awt.Color(51, 255, 102));
        meja7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        no7.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no7.setForeground(new java.awt.Color(0, 0, 0));
        no7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no7.setText("7");
        no7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja7Layout = new javax.swing.GroupLayout(meja7);
        meja7.setLayout(meja7Layout);
        meja7Layout.setHorizontalGroup(
            meja7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(meja7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        );
        meja7Layout.setVerticalGroup(
            meja7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(meja7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        meja8.setBackground(new java.awt.Color(51, 255, 102));
        meja8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        no8.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no8.setForeground(new java.awt.Color(0, 0, 0));
        no8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no8.setText("8");
        no8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no8MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja8Layout = new javax.swing.GroupLayout(meja8);
        meja8.setLayout(meja8Layout);
        meja8Layout.setHorizontalGroup(
            meja8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(meja8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        );
        meja8Layout.setVerticalGroup(
            meja8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(meja8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        meja9.setBackground(new java.awt.Color(51, 255, 102));
        meja9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        no9.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no9.setForeground(new java.awt.Color(0, 0, 0));
        no9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no9.setText("9");
        no9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja9Layout = new javax.swing.GroupLayout(meja9);
        meja9.setLayout(meja9Layout);
        meja9Layout.setHorizontalGroup(
            meja9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(meja9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        );
        meja9Layout.setVerticalGroup(
            meja9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(meja9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no9, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        meja10.setBackground(new java.awt.Color(51, 255, 102));
        meja10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        no10.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no10.setForeground(new java.awt.Color(0, 0, 0));
        no10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no10.setText("10");
        no10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no10MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja10Layout = new javax.swing.GroupLayout(meja10);
        meja10.setLayout(meja10Layout);
        meja10Layout.setHorizontalGroup(
            meja10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(meja10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        );
        meja10Layout.setVerticalGroup(
            meja10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(meja10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(no10, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        meja11.setBackground(new java.awt.Color(51, 255, 102));
        meja11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        meja11.setPreferredSize(new java.awt.Dimension(135, 102));
        meja11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                meja11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                meja11MouseExited(evt);
            }
        });

        no11.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no11.setForeground(new java.awt.Color(0, 0, 0));
        no11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no11.setText("11");
        no11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no11MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja11Layout = new javax.swing.GroupLayout(meja11);
        meja11.setLayout(meja11Layout);
        meja11Layout.setHorizontalGroup(
            meja11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(meja11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(meja11Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(no11, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGap(53, 53, 53)))
        );
        meja11Layout.setVerticalGroup(
            meja11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(meja11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(meja11Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(no11, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addGap(4, 4, 4)))
        );

        meja12.setBackground(new java.awt.Color(51, 255, 102));
        meja12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        meja12.setPreferredSize(new java.awt.Dimension(135, 102));

        no12.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        no12.setForeground(new java.awt.Color(0, 0, 0));
        no12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no12.setText("12");
        no12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                no12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                no12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                no12MouseExited(evt);
            }
        });

        javax.swing.GroupLayout meja12Layout = new javax.swing.GroupLayout(meja12);
        meja12.setLayout(meja12Layout);
        meja12Layout.setHorizontalGroup(
            meja12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(meja12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(meja12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(no12, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        meja12Layout.setVerticalGroup(
            meja12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(meja12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(meja12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(no12, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pDetail.setBackground(new java.awt.Color(26, 50, 90));

        noMeja.setBackground(new java.awt.Color(26, 50, 90));
        noMeja.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        noMeja.setForeground(new java.awt.Color(255, 255, 255));
        noMeja.setText("Meja : ");

        noMeja1.setBackground(new java.awt.Color(26, 50, 90));
        noMeja1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        noMeja1.setForeground(new java.awt.Color(255, 255, 255));
        noMeja1.setText("Menu :");

        cdMenu.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N

        QTY.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        QTY.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        QTY.setOpaque(false);

        jList1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jList1.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jList1);

        btnAdd.setBackground(new java.awt.Color(0, 239, 173));
        btnAdd.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 0, 0));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/add.png"))); // NOI18N
        btnAdd.setText(" Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 239, 173));
        btnUpdate.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/confirm.png"))); // NOI18N
        btnUpdate.setText("  Confirm");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/delete.png"))); // NOI18N
        btnDelete.setText(" Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(147, 45));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

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

        noMeja2.setBackground(new java.awt.Color(26, 50, 90));
        noMeja2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        noMeja2.setForeground(new java.awt.Color(255, 255, 255));
        noMeja2.setText("Total : ");

        txtTotal.setBackground(new java.awt.Color(26, 50, 90));
        txtTotal.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotal.setText("-");

        jLabel3.setBackground(new java.awt.Color(26, 50, 90));
        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DETAIL");

        javax.swing.GroupLayout pDetailLayout = new javax.swing.GroupLayout(pDetail);
        pDetail.setLayout(pDetailLayout);
        pDetailLayout.setHorizontalGroup(
            pDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pDetailLayout.createSequentialGroup()
                        .addComponent(noMeja1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cdMenu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(QTY, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDetailLayout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addGroup(pDetailLayout.createSequentialGroup()
                        .addComponent(noMeja2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDetailLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(noMeja)
                .addGap(25, 25, 25))
            .addGroup(pDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pDetailLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel3)
                    .addContainerGap(232, Short.MAX_VALUE)))
        );
        pDetailLayout.setVerticalGroup(
            pDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDetailLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(noMeja)
                .addGap(18, 18, 18)
                .addGroup(pDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noMeja1)
                    .addComponent(cdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QTY, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noMeja2)
                    .addComponent(txtTotal))
                .addGap(18, 18, 18)
                .addGroup(pDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(pDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pDetailLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel3)
                    .addContainerGap(592, Short.MAX_VALUE)))
        );

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

        lblWelcome.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 22)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("Welcome, ");

        btnClear1.setBackground(new java.awt.Color(255, 255, 153));
        btnClear1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnClear1.setForeground(new java.awt.Color(0, 0, 0));
        btnClear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/rotate-left-circular-arrow-interface-symbol.png"))); // NOI18N
        btnClear1.setText(" Reset");
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        labelJam.setBackground(new java.awt.Color(26, 50, 90));
        labelJam.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        labelJam.setForeground(new java.awt.Color(255, 255, 255));
        labelJam.setText("10:10:10");

        btnClear2.setBackground(new java.awt.Color(0, 239, 173));
        btnClear2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        btnClear2.setForeground(new java.awt.Color(0, 0, 0));
        btnClear2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/take-away.png"))); // NOI18N
        btnClear2.setText(" Take Away");
        btnClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear2ActionPerformed(evt);
            }
        });

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/images/minimize4.png"))); // NOI18N
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(462, 462, 462)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(meja8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(meja4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(meja5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(meja1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(meja9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(meja6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(meja2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(meja10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(meja7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(meja3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(meja11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(meja12, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(lblWelcome)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(labelJam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(pDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMinimize)
                        .addGap(18, 18, 18)
                        .addComponent(lblExit)
                        .addGap(28, 28, 28))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMinimize)
                            .addComponent(lblExit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWelcome)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(meja4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(meja8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(meja3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(meja7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(meja2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(meja6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(meja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(meja5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(meja12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(meja11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(meja10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(meja9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelJam))
                        .addGap(45, 45, 45))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void togglePanelEdit(int no){
        refreshForm();
        for (int i = 0; i < 12; i++) {
            hold[i] = false;
        }
        switch (no) {
            case 1:
                meja1.setBackground(new Color(255,255,113));  
                hold[0] = true;
                break; 
            case 2:
                meja2.setBackground(new Color(255,255,113));  
                hold[1] = true;
                break; 
            case 3:
                meja3.setBackground(new Color(255,255,113));  
                hold[2] = true;
                break;
            case 4:
                meja4.setBackground(new Color(255,255,113));  
                hold[3] = true;
                break;  
            case 5:
                meja5.setBackground(new Color(255,255,113));  
                hold[4] = true;
                break; 
            case 6:
                meja6.setBackground(new Color(255,255,113)); 
                hold[5] = true; 
                break;
            case 7:
                meja7.setBackground(new Color(255,255,113));  
                hold[6] = true;
                break;
            case 8:
                meja8.setBackground(new Color(255,255,113));  
                hold[7] = true;
                break;   
            case 9:
                meja9.setBackground(new Color(255,255,113));  
                hold[8] = true;
                break;  
            case 10:
                meja10.setBackground(new Color(255,255,113));  
                hold[9] = true;
                break;
            case 11:
                meja11.setBackground(new Color(255,255,113));  
                hold[10] = true;
                break;
            case 12:
                meja12.setBackground(new Color(255,255,113));  
                hold[11] = true;
                break;   
        } 
    }
    private void no1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no1MouseClicked
        noMeja.setText("Meja : 1");
        cart.clear();
        updateJList();
        panelTemp = meja1;
        mejaIni = Meja.listMeja[0];
        if (meja1.getBackground().equals(new Color(255,52,52))) {
            //System.out.print(mejaIni.getListPesanan().size()+"");
            if (evt.getClickCount()>1) {
                keCheckout(mejaIni);
            }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            } 
        }else { 
            togglePanelEdit(1); 
        }
    }//GEN-LAST:event_no1MouseClicked
 
    private void no2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no2MouseClicked
        noMeja.setText("Meja : 2");
        cart.clear();
        updateJList();
        panelTemp = meja2;
        mejaIni = Meja.listMeja[1];
        if (meja2.getBackground().equals(new Color(255,52,52))) { 
            if (evt.getClickCount()>1) {
                keCheckout(mejaIni);
            }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            }  
        }else { 
            togglePanelEdit(2); 
        }
    }//GEN-LAST:event_no2MouseClicked

    private void no3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no3MouseClicked
        noMeja.setText("Meja : 3");
        cart.clear();
        updateJList();
        panelTemp = meja3;
        mejaIni = Meja.listMeja[2];
        if (meja3.getBackground().equals(new Color(255,52,52))) {
            if (evt.getClickCount()>1) {
                keCheckout(mejaIni);
            }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            } 
        }else { 
            togglePanelEdit(3); 
        }
    }//GEN-LAST:event_no3MouseClicked

    private void no4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no4MouseClicked
        noMeja.setText("Meja : 4");
        cart.clear();
        updateJList();
        panelTemp = meja4;
        mejaIni = Meja.listMeja[3];
        if (meja4.getBackground().equals(new Color(255,52,52))) {
            if (evt.getClickCount()>1) {
                keCheckout(mejaIni);
            }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            } 
        }else { 
            togglePanelEdit(4); 
        }
    }//GEN-LAST:event_no4MouseClicked

    private void no5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no5MouseClicked
        noMeja.setText("Meja : 5");
        cart.clear();
        updateJList();
        panelTemp = meja5;
        mejaIni = Meja.listMeja[4];
        if (meja5.getBackground().equals(new Color(255,52,52))) {
            if (evt.getClickCount()>1) {
                keCheckout(mejaIni);
            }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            } 
        }else { 
            togglePanelEdit(5); 
        }
    }//GEN-LAST:event_no5MouseClicked

    private void no6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no6MouseClicked
        noMeja.setText("Meja : 6");
        cart.clear();
        updateJList();
        panelTemp = meja6;
        mejaIni = Meja.listMeja[5];
        if (meja6.getBackground().equals(new Color(255,52,52))) {
            if (evt.getClickCount()>1) {
                keCheckout(mejaIni);
            }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            } 
        }else { 
            togglePanelEdit(6); 
        }
    }//GEN-LAST:event_no6MouseClicked

    private void no7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no7MouseClicked
        noMeja.setText("Meja : 7");
        cart.clear();
        updateJList();
        panelTemp = meja7;
        mejaIni = Meja.listMeja[6];
        if (meja7.getBackground().equals(new Color(255,52,52))) {
            if (evt.getClickCount()>1) {
                 keCheckout(mejaIni);
             }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            } 
        }else { 
            togglePanelEdit(7); 
        }
    }//GEN-LAST:event_no7MouseClicked

    private void no8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no8MouseClicked
        noMeja.setText("Meja : 8");
        cart.clear();
        updateJList();
        panelTemp = meja8;
        mejaIni = Meja.listMeja[7];
        if (meja8.getBackground().equals(new Color(255,52,52))) {
            if (evt.getClickCount()>1) {
                keCheckout(mejaIni);
            }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            } 
        }else { 
            togglePanelEdit(8); 
        }
    }//GEN-LAST:event_no8MouseClicked

    private void no9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no9MouseClicked
        noMeja.setText("Meja : 9");
        cart.clear();
        updateJList();
        panelTemp = meja9;
        mejaIni = Meja.listMeja[8];
        if (meja9.getBackground().equals(new Color(255,52,52))) {
            if (evt.getClickCount()>1) {
                keCheckout(mejaIni);
            }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            } 
        }else { 
            togglePanelEdit(9); 
        }
    }//GEN-LAST:event_no9MouseClicked

    private void no10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no10MouseClicked
        noMeja.setText("Meja : 10");
        cart.clear();
        updateJList();
        panelTemp = meja10;
        mejaIni = Meja.listMeja[9];
        if (meja10.getBackground().equals(new Color(255,52,52))) {
            if (evt.getClickCount()>1) {
                keCheckout(mejaIni);
            }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            } 
        }else { 
            togglePanelEdit(10); 
        }
    }//GEN-LAST:event_no10MouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        FormPenghubungKaryawan f = new FormPenghubungKaryawan();
        f.setTitle("Ga Kenyang Ga Pulang");
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        try {
            timer.stop();
        } catch (Exception exc) {
            System.out.println("Error");
        }
        this.dispose();
    }//GEN-LAST:event_lblExitMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       int choose = JOptionPane.showConfirmDialog(this, 
                   "Apakah anda ingin mengosongkan keranjang?", 
                   "Konfirmasi", JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE , new ImageIcon(Login.logoQuestion));   
        if (choose == 0) {     
            cart.clear();
            updateJList();
            txtTotal.setText("-");
        }
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (jList1.getSelectedIndex()==-1) { 
            JOptionPane.showMessageDialog(null, "Silahkan memilih menu yang mau dihapus", "Warning", JOptionPane.INFORMATION_MESSAGE, 
            new ImageIcon(Login.logoWarning));  
            return;
        }
        cart.remove(jList1.getSelectedIndex());
        updateJList();
    }//GEN-LAST:event_btnDeleteActionPerformed

    void updateTotal(){
        int temp = 0;
        for (DTrans pesan : cart) {
            temp+= pesan.getSubtotal();
        }
        txtTotal.setText("Rp. "+temp);
    }
    
    void updateJList(){
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < cart.size(); i++) {
            listModel.addElement(cart.get(i).toString());
        }
        jList1.setModel(listModel);
        updateTotal();
    }
    
    JPanel panelTemp;
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
     
        if (cart.size()==0) { 
            JOptionPane.showMessageDialog(null, "Pesanan harus diisi", "Warning", JOptionPane.INFORMATION_MESSAGE, 
            new ImageIcon(Login.logoWarning));  
            return;
        }
        
        panelTemp.setBackground(new Color(255,52,52));
        mejaIni.getListPesanan().clear();
        for (int i = 0; i < cart.size(); i++) {
            mejaIni.getListPesanan().add(cart.get(i));
        }
        DefaultListModel d = new DefaultListModel();
        jList1.setModel(d);
        txtTotal.setText("-");
        btnClear1ActionPerformed(null);
        
//        CheckoutTransaksi f = new CheckoutTransaksi();
//        f.setResizable(false);
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnUpdateActionPerformed

    void keCheckout(Meja m){
        if (CheckoutTransaksi.tampil) { 
            JOptionPane.showMessageDialog(null, "Ada form checkout yang masih terbuka", "Error", JOptionPane.INFORMATION_MESSAGE, 
            new ImageIcon(Login.logoError));  
            return;
        }
        CheckoutTransaksi f = new CheckoutTransaksi(m, this);
        f.setTitle("Ga Kenyang Ga Pulang");
        f.setResizable(false);
        //f.setPreferredSize(new Dimension(1000, 1000));
        this.setLocation(90, 170);
        //f.setLocationRelativeTo(null);
        f.setLocation(1200, 170);
        f.setVisible(true);
    }
    public int containMenu(int id){
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getIdMenu() == id) {
                return i;
            }
        }
        return -1;
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (mejaIni == null) { 
            JOptionPane.showMessageDialog(null, "Pilih Meja dulu Bosss", "Warning", JOptionPane.INFORMATION_MESSAGE, 
            new ImageIcon(Login.logoWarning));  
            return;
        }  
        int idx = containMenu(Menu.listMenu.get(cdMenu.getSelectedIndex()).getIdMenu());
        if (idx!=-1) {
             //bagian ini menunjukkan kalau cart sudah ada menu yang mau ditambah
             cart.get(idx).setQuantity(cart.get(idx).getQuantity()+ (int) QTY.getValue());
        }else { 
            cart.add(new DTrans(Menu.listMenu.get(cdMenu.getSelectedIndex()).getIdMenu(), cdMenu.getSelectedItem().toString(),
                    Menu.listMenu.get(cdMenu.getSelectedIndex()).getCategory(), 
                    Menu.listMenu.get(cdMenu.getSelectedIndex()).getHarga(),
                    1, (int) QTY.getValue()));
        }
        updateJList();
    }//GEN-LAST:event_btnAddActionPerformed

    private void no12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no12MouseClicked
        noMeja.setText("Meja : 12");
        cart.clear();
        updateJList();
        panelTemp = meja12;
        mejaIni = Meja.listMeja[11];
        if (meja12.getBackground().equals(new Color(255,52,52))) {
            if (evt.getClickCount()>1) {
                keCheckout(mejaIni);
            }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            } 
        }else { 
            togglePanelEdit(12); 
        }
    }//GEN-LAST:event_no12MouseClicked

    private void no11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no11MouseClicked
        noMeja.setText("Meja : 11");
        cart.clear();
        updateJList();
        panelTemp = meja11;
        mejaIni = Meja.listMeja[10];
        if (meja11.getBackground().equals(new Color(255,52,52))) {
            if (evt.getClickCount()>1) {
                keCheckout(mejaIni);
            }else{
                for (int i = 0; i < mejaIni.getListPesanan().size(); i++) {
                cart.add(mejaIni.getListPesanan().get(i));
                }
                updateJList();
            } 
        }else { 
            togglePanelEdit(11); 
        }
    }//GEN-LAST:event_no11MouseClicked

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        noMeja.setText("Meja : -");
        mejaIni=null;
        cart.clear();
        updateJList();
        txtTotal.setText("-");
        cdMenu.setSelectedIndex(0);
        QTY.setValue(1);
        refreshForm();
        for (int i = 0; i < 12; i++) {
            hold[i] = false;
        }
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void meja1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meja1MouseEntered
        // TODO add your handling code here:
          
    }//GEN-LAST:event_meja1MouseEntered

    private void meja1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meja1MouseExited
        // TODO add your handling code here:
       
    }//GEN-LAST:event_meja1MouseExited

    private void no1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no1MouseEntered
        // TODO add your handling code here:
        if (Meja.listMeja[0].getListPesanan().size()==0 && hold[0]==false) {
            meja1.setBackground(new Color(51,165,102)); 
//             System.out.println("Hover enter");
        } 
    }//GEN-LAST:event_no1MouseEntered
    private int adaClick(){
        for (int i = 0; i < 12; i++) {
            if (hold[i]==true) {
                return i;
            }
        }
        return -1;
    } 
    private void hoverToggle(){
     if (adaClick()==-1) {  
            refreshForm(); 
        }else {
            refreshForm();
            //meja yg lagi diclick dibalikkan jadi kuning
            togglePanelEdit(adaClick()+1);  
        }
    }
    private void no1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no1MouseExited
        hoverToggle();
//        System.out.println("hover exit");
    }//GEN-LAST:event_no1MouseExited

    private void no2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no2MouseEntered
       if (Meja.listMeja[1].getListPesanan().size()==0 && hold[1] == false) {
            meja2.setBackground(new Color(51,165,102));  
        } 
    }//GEN-LAST:event_no2MouseEntered

    private void no2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no2MouseExited
        hoverToggle();
    }//GEN-LAST:event_no2MouseExited

    private void no3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no3MouseEntered
        if (Meja.listMeja[2].getListPesanan().size()==0 && hold[2] == false){
            meja3.setBackground(new Color(51,165,102));  
        } 
    }//GEN-LAST:event_no3MouseEntered

    private void no3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no3MouseExited
        hoverToggle();
    }//GEN-LAST:event_no3MouseExited

    private void no4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no4MouseEntered
       if (Meja.listMeja[3].getListPesanan().size()==0&& hold[3] == false) {
            meja4.setBackground(new Color(51,165,102));  
        } 
    }//GEN-LAST:event_no4MouseEntered

    private void no4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no4MouseExited
        hoverToggle();
    }//GEN-LAST:event_no4MouseExited

    private void no5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no5MouseEntered
        if (Meja.listMeja[4].getListPesanan().size()==0&& hold[4] == false) {
            meja5.setBackground(new Color(51,165,102));  
        } 
    }//GEN-LAST:event_no5MouseEntered

    private void no5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no5MouseExited
        hoverToggle();
    }//GEN-LAST:event_no5MouseExited

    private void no6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no6MouseEntered
       if (Meja.listMeja[5].getListPesanan().size()==0&& hold[5] == false) {
            meja6.setBackground(new Color(51,165,102));  
        } 
    }//GEN-LAST:event_no6MouseEntered

    private void no6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no6MouseExited
        hoverToggle();
    }//GEN-LAST:event_no6MouseExited

    private void no7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no7MouseEntered
       if (Meja.listMeja[6].getListPesanan().size()==0&& hold[6] == false) {
            meja7.setBackground(new Color(51,165,102));  
        } 
    }//GEN-LAST:event_no7MouseEntered

    private void no7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no7MouseExited
        hoverToggle();
    }//GEN-LAST:event_no7MouseExited

    private void no8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no8MouseEntered
        if (Meja.listMeja[7].getListPesanan().size()==0&& hold[7] == false) {
            meja8.setBackground(new Color(51,165,102));  
        } 
    }//GEN-LAST:event_no8MouseEntered

    private void no8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no8MouseExited
        hoverToggle();
    }//GEN-LAST:event_no8MouseExited

    private void no9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no9MouseEntered
        if (Meja.listMeja[8].getListPesanan().size()==0&& hold[8] == false) {
            meja9.setBackground(new Color(51,165,102));  
        } 
    }//GEN-LAST:event_no9MouseEntered

    private void no9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no9MouseExited
       hoverToggle();
    }//GEN-LAST:event_no9MouseExited

    private void no10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no10MouseEntered
        if (Meja.listMeja[9].getListPesanan().size()==0&& hold[9] == false) {
            meja10.setBackground(new Color(51,165,102));  
        } 
    }//GEN-LAST:event_no10MouseEntered

    private void no10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no10MouseExited
       hoverToggle();
    }//GEN-LAST:event_no10MouseExited

    private void no11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no11MouseEntered
        
    }//GEN-LAST:event_no11MouseEntered

    private void no11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no11MouseExited
         
    }//GEN-LAST:event_no11MouseExited

    private void no12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no12MouseEntered
        if (Meja.listMeja[11].getListPesanan().size()==0&& hold[11] == false) {
            meja12.setBackground(new Color(51,165,102));  
        } 
    }//GEN-LAST:event_no12MouseEntered

    private void no12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_no12MouseExited
       hoverToggle();
    }//GEN-LAST:event_no12MouseExited

    private void meja11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meja11MouseEntered
        if (Meja.listMeja[10].getListPesanan().size()==0&& hold[10] == false) {
            meja11.setBackground(new Color(51,165,102));  
        } 
    }//GEN-LAST:event_meja11MouseEntered

    private void meja11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meja11MouseExited
        hoverToggle();
    }//GEN-LAST:event_meja11MouseExited

    private void btnClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear2ActionPerformed
        TakeAway f = new TakeAway();
        f.setTitle("Ga Kenyang Ga Pulang");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClear2ActionPerformed

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
            java.util.logging.Logger.getLogger(mejaTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mejaTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mejaTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mejaTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mejaTrans().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner QTY;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnClear2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cdMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelJam;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel meja1;
    private javax.swing.JPanel meja10;
    private javax.swing.JPanel meja11;
    private javax.swing.JPanel meja12;
    private javax.swing.JPanel meja2;
    private javax.swing.JPanel meja3;
    private javax.swing.JPanel meja4;
    private javax.swing.JPanel meja5;
    private javax.swing.JPanel meja6;
    private javax.swing.JPanel meja7;
    private javax.swing.JPanel meja8;
    private javax.swing.JPanel meja9;
    private javax.swing.JLabel no1;
    private javax.swing.JLabel no10;
    private javax.swing.JLabel no11;
    private javax.swing.JLabel no12;
    private javax.swing.JLabel no2;
    private javax.swing.JLabel no3;
    private javax.swing.JLabel no4;
    private javax.swing.JLabel no5;
    private javax.swing.JLabel no6;
    private javax.swing.JLabel no7;
    private javax.swing.JLabel no8;
    private javax.swing.JLabel no9;
    private javax.swing.JLabel noMeja;
    private javax.swing.JLabel noMeja1;
    private javax.swing.JLabel noMeja2;
    private javax.swing.JPanel pDetail;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
