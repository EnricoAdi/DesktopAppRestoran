 
package testproject;

//Project PBO

import java.io.BufferedWriter;
import java.sql.Connection;
import java.io.FileWriter;
import java.io.FileReader;
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DB {
    static Connection conn;
    public DB(){ }
    public static void initConn(){ 
        try { 
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pbo_proyek","root","");  
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }  
    public static void close(){
        try {
            conn.close();
        } catch (Exception exc) {
          JOptionPane.showMessageDialog(null, exc.getMessage()); 
        }
    } 
    public static DefaultTableModel getTabelKaryawan(){
        //function ini untuk query tabel karyawan di master karyawan
        DefaultTableModel tabelKaryawan = new DefaultTableModel();
        String[] rows = {"ID","NAMA",
            "USERNAME", "JABATAN"};
        tabelKaryawan = new DefaultTableModel(rows, 0);  
        try { 
            PreparedStatement ps = conn.prepareStatement("SELECT k.id_karyawan as \"ID\",k.nama as \"Nama\" ,"
                    + "k.username as \"Username\",\n" +
                    "k.password as \"Password\"," +
                    "case k.jabatan when k.jabatan=1 then 'Kasir' else "
                    +"'Manager' end as \"Jabatan\"\n" +
                    "FROM `karyawan` k WHERE status != 0");
            ResultSet st = ps.executeQuery();
            while (st.next()) {
                Object[] rows1 = new Object[]{
                    st.getString("ID"),st.getString("Nama"),st.getString("Username"),st.getString("Jabatan")}; 
                tabelKaryawan.addRow(rows1);   
            } 
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        } 
        
        return tabelKaryawan;
    } 
    
    public static DefaultTableModel getTabelMenu(String kategori, String nama){
        //function buat query tabel menu di master menu 
        String[] rows = {"ID","Nama",
            "Harga","Kategori"};
        String kategori1 = "";
        if (!kategori.equals("Semua")) {
            kategori1 = kategori;
        }
         DefaultTableModel tabelMenu = new DefaultTableModel(rows, 0);  
        try {  
        PreparedStatement ps = conn.prepareStatement
                            ("SELECT id_menu as \"ID\",NAMA as \"Nama\", " +
                            "harga as \"Harga\", kategori as \"Kategori\"" +
                            "FROM MENU " +
                            "WHERE kategori LIKE ? and nama like ? and status!=0 " +
                            "order by id_menu desc");
            ps.setString(1, "%"+kategori1+"%");
            ps.setString(2, "%"+nama+"%");
            ResultSet st = ps.executeQuery();
            while (st.next()) {
                Object[] rows1 = new Object[]{
                    st.getString("ID"),st.getString("Nama"),st.getString("Harga"),st.getString("Kategori")
                }; 
                tabelMenu.addRow(rows1);   
            } 
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }   
        return tabelMenu;
    }
     
    public static void cetakLaporanPenjualan(String tanggalAwal, String tanggalAkhir) throws Exception{
        //function ini untuk mencetak laporan penjualan ke dalam bentuk file .txt
        //pengecekan tanggal valid
        if (tanggalAwal == null || tanggalAkhir == null) {
            throw new Exception("Semua field harus terisi!");
        }
        if (cekDate(tanggalAwal)==false || cekDate(tanggalAkhir)==false) {
            throw new Exception("Format tanggal harus benar (YYYY-MM-DD)");
        }
        int txtal = 0;
        int jumTunai = 0; //Tunai
        int jumGopay = 0; //Go-Pay
        int jumOvo = 0; //Ovo
        int jumShopeePay = 0;//ShopeePay
        int jumDana = 0;//Dana
        int jumLinkAja = 0;//LinkAja
        ArrayList<Transaction> listTransaction = new ArrayList<>();
            ArrayList<String> listheader = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement
                            ("SELECT h.nomorNota as \"nomorNota\",\n" +
                            "h.tanggalTrans as \"tanggalTrans\",\n" +
                            "h.jamTrans as \"jamTrans\",\n" +
                            "h.metodePembayaran as \"metodePembayaran\",\n" +
                            "h.total as \"total\",\n" +
                            "k.nama as \"nama Karyawan\",\n" +
                            "h.status as \"status\",\n" +
                            "rpad(h.tanggalTrans,12) as \"tanggal1\",\n" +
                            "rpad(k.nama,12) as \"Kasir1\",\n" +
                            "rpad(h.metodePembayaran,20) as \"Metode Pembayaran1\",\n" +
                            "rpad(h.total,11) as \"Total1\"\n" +
                            "FROM htrans h join karyawan k ON k.id_karyawan=h.id_karyawan\n" +
                            "where h.tanggalTrans>=? and h.tanggalTrans<=?");
            ps.setString(1, tanggalAwal);
            ps.setString(2, tanggalAkhir);  
            ResultSet st = ps.executeQuery();
            while (st.next()) {
                listTransaction.add(new Transaction(st.getString("nomorNota"), 
                        st.getString("tanggalTrans"), st.getString("metodePembayaran"), 
                        Integer.parseInt(st.getString("total")), 
                        st.getTime("jamTrans")+"",
                        st.getString("nama Karyawan"), Integer.parseInt(st.getString("status"))));
                
                listheader.add(st.getString("tanggal1")+"|"+st.getString("Kasir1")+"|"+
                        st.getString("Metode Pembayaran1")+"|"+st.getString("Total1")+"|");
                
                if (st.getString("metodePembayaran").equalsIgnoreCase("Tunai")) {
                    jumTunai+= Integer.parseInt(st.getString("total"));
                }
                else if (st.getString("metodePembayaran").equalsIgnoreCase("Go-Pay")) {
                    jumGopay+= Integer.parseInt(st.getString("total"));
                }  
                else if (st.getString("metodePembayaran").equalsIgnoreCase("Ovo")) {
                    jumOvo+= Integer.parseInt(st.getString("total"));
                }  
                else if (st.getString("metodePembayaran").equalsIgnoreCase("ShopeePay")) {
                    jumShopeePay+= Integer.parseInt(st.getString("total"));
                }  
                else if (st.getString("metodePembayaran").equalsIgnoreCase("Dana")) {
                    jumDana+= Integer.parseInt(st.getString("total"));
                }  
                else{
                    jumLinkAja+= Integer.parseInt(st.getString("total"));
                }  
            } 
            for (int i = 0; i < listTransaction.size(); i++) {
                txtal += listTransaction.get(i).getTotal();
            } 
            
        } catch (Exception exc) {
            throw new Exception("Maaf ada kesalahan dalam memuat laporan \n"+exc.getMessage());
        } 
        try { 
            FileWriter laporan = new FileWriter("Laporan Penjualan\\Laporan Penjualan Tanggal "
                    +tanggalAwal+" - "+tanggalAkhir+".txt");
            BufferedWriter bfw = new BufferedWriter(laporan);
            bfw.write("*********************************************************");bfw.newLine();
            bfw.write("               Resto Gak Kenyang Gak Pulang");bfw.newLine();
            bfw.write("        Periode Tanggal "+tanggalAwal+" sampai "+tanggalAkhir);bfw.newLine(); 
            bfw.write("*********************************************************");bfw.newLine();

            bfw.write("Total Pendapatan : Rp"+txtal);bfw.newLine();bfw.newLine();
            bfw.write("----------------------------------------------------------");bfw.newLine();
            bfw.write("Tanggal     |Kasir       |Metode Pembayaran   |Total      |");bfw.newLine();
            bfw.write("----------------------------------------------------------");bfw.newLine();
            for (int i = 0; i < listheader.size(); i++) { 
            bfw.write(listheader.get(i));bfw.newLine(); 
            bfw.write("----------------------------------------------------------");bfw.newLine();
            }
            bfw.newLine();
            bfw.newLine();
            bfw.newLine();
            bfw.write("Total Pembayaran Menggunakan : ");bfw.newLine();
            if (jumTunai>0) { 
                bfw.write("Uang Tunai : "+jumTunai);bfw.newLine();
            }
            if (jumGopay>0) {
                bfw.write("Go-Pay     : "+jumGopay);bfw.newLine(); 
            } 
            if (jumOvo>0) {
                bfw.write("Ovo        : "+jumOvo);bfw.newLine(); 
            } 
            if (jumShopeePay>0) {
                bfw.write("ShopeePay  : "+jumShopeePay);bfw.newLine(); 
            } 
            if (jumDana>0) {
                bfw.write("Dana       : "+jumDana);bfw.newLine(); 
            } 
            if (jumLinkAja>0) {
                bfw.write("LinkAja    : "+jumLinkAja);bfw.newLine(); 
            } 
             
            bfw.newLine();
            bfw.newLine();
            bfw.newLine();
            bfw.write("* Untuk memaksimalkan tampilan laporan, gunakan font");
            bfw.newLine();
            bfw.write("Courier dengan ukuran 11");
            bfw.newLine();
            bfw.close(); 
        } catch (Exception exc) {
            throw new Exception(exc.getMessage());
        }
    }
    
    public static void cetakMenuFavorit(String kategori, int banyakData, String tanggalAwal, String tanggalAkhir) throws Exception {
        //ini fungsi untuk cetak laporan Menu Favorit ke txt
        if (cekDate(tanggalAwal)==false || cekDate(tanggalAkhir)==false) {
            throw new Exception("Format tanggal harus benar (YYYY-MM-DD)");
        }
        
        ArrayList<String> arrNamaMenu = new ArrayList();
        ArrayList<String> arrJumlahMenu = new ArrayList();
        
        try {
            PreparedStatement ps;
            if(kategori.equals("")){
                //kalau kategori tidak di isi, select dari semua kategori
                ps = conn.prepareStatement
                    ("SELECT RPAD(SUM(DT.QTY),20,' ') as \"Jumlah\", "
                            + "RPAD(M.NAMA,37,' ') as \"Nama\" "
                            + "FROM MENU M, DTRANS DT, HTRANS HT "
                            + "WHERE M.ID_MENU = DT.ID_MENU "
                            + "AND HT.NOMORNOTA = DT.NOMORNOTA "
                            + "AND HT.TANGGALTRANS >= ? AND HT.TANGGALTRANS <= ?"
                            + "GROUP BY DT.ID_MENU "
                            + "ORDER BY SUM(DT.QTY) DESC"
                    );
                ps.setString(1, tanggalAwal);
                ps.setString(2, tanggalAkhir);
            }else{
                //kalau kategori di isi, select sesuai kategori yang di isi
                ps = conn.prepareStatement
                    ("SELECT RPAD(SUM(DT.QTY),20,' ') as \"Jumlah\", "
                            + "RPAD(M.NAMA,37,' ') as \"Nama\" "
                            + "FROM MENU M, DTRANS DT, HTRANS HT "
                            + "WHERE M.ID_MENU = DT.ID_MENU "
                            + "AND HT.NOMORNOTA = DT.NOMORNOTA "
                            + "AND HT.TANGGALTRANS >= ? AND HT.TANGGALTRANS <= ?"
                            + "AND M.KATEGORI = ?"
                            + "GROUP BY DT.ID_MENU "
                            + "ORDER BY SUM(DT.QTY) DESC"
                    );
                ps.setString(1, tanggalAwal);
                ps.setString(2, tanggalAkhir);
                ps.setString(3, kategori);
            }

            ResultSet st = ps.executeQuery();
            int counter = 1;
            while (st.next()) {
                if(counter <= banyakData){
                    arrNamaMenu.add(st.getString("Nama"));
                    arrJumlahMenu.add(st.getString("Jumlah"));
                    counter += 1;
//                    System.out.println("nama " + st.getString("Nama") + " || jumlah " + st.getString("Jumlah"));
                }else{
                    break;
                }
            }
            
            //code ke txt
            FileWriter laporan = new FileWriter("Laporan MenuFavorit\\Laporan MenuFavorit Tanggal " + 
                    tanggalAwal + " - " + tanggalAkhir + ".txt");
            BufferedWriter bfw = new BufferedWriter(laporan);
            bfw.write("*********************************************************"); bfw.newLine();
            bfw.write("               Resto Gak Kenyang Gak Pulang"); bfw.newLine();
            bfw.write("        Periode Tanggal "+tanggalAwal+" sampai "+tanggalAkhir); bfw.newLine(); 
            bfw.write("*********************************************************"); bfw.newLine();

            bfw.write(banyakData + " Menu Favorit");bfw.newLine();bfw.newLine();
            bfw.write("----------------------------------------------------------");bfw.newLine();
            bfw.write("Nama                                 |Total               |");bfw.newLine();
            bfw.write("----------------------------------------------------------");bfw.newLine();
            for (int i = 0; i < arrNamaMenu.size(); i++) { 
                bfw.write(arrNamaMenu.get(i) + "|" + arrJumlahMenu.get(i) + "|"); bfw.newLine(); 
                bfw.write("----------------------------------------------------------");bfw.newLine();
            }
            bfw.newLine();
            bfw.newLine();
            bfw.newLine();
            bfw.write("* Untuk memaksimalkan tampilan laporan, gunakan font");
            bfw.newLine();
            bfw.write("Courier dengan ukuran 11");
            bfw.newLine();
            bfw.close(); 
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            throw new Exception("Maaf ada kesalahan dalam memuat laporan Menu Favorit\n" + exc.getMessage());
        }
    }
    
    public static DefaultTableModel tabelMenuFavorit(String kategori, int banyakData, String tanggalAwal, String tanggalAkhir) throws Exception {
        if (cekDate(tanggalAwal)==false || cekDate(tanggalAkhir)==false) {
            throw new Exception("Format tanggal harus benar (YYYY-MM-DD)");
        }
        
        String[] rows = {"Menu", "Jumlah Pembelian"};
        DefaultTableModel dfm = new DefaultTableModel(rows, 0);
        try {
            PreparedStatement ps;
            if(kategori.equals("")){
                //kalau kategori tidak di isi, select dari semua kategori
                ps = conn.prepareStatement
                    ("SELECT SUM(DT.QTY) as \"Jumlah\", "
                            + "M.NAMA as \"Nama\" "
                            + "FROM MENU M, DTRANS DT, HTRANS HT "
                            + "WHERE M.ID_MENU = DT.ID_MENU "
                            + "AND HT.NOMORNOTA = DT.NOMORNOTA "
                            + "AND HT.TANGGALTRANS >= ? AND HT.TANGGALTRANS <= ?"
                            + "GROUP BY DT.ID_MENU "
                            + "ORDER BY SUM(DT.QTY) DESC"
                    );
                ps.setString(1, tanggalAwal);
                ps.setString(2, tanggalAkhir);
            }else{
                //kalau kategori di isi, select sesuai kategori yang di isi
                ps = conn.prepareStatement
                    ("SELECT SUM(DT.QTY) as \"Jumlah\", "
                            + "M.NAMA as \"Nama\" "
                            + "FROM MENU M, DTRANS DT, HTRANS HT "
                            + "WHERE M.ID_MENU = DT.ID_MENU "
                            + "AND HT.NOMORNOTA = DT.NOMORNOTA "
                            + "AND HT.TANGGALTRANS >= ? AND HT.TANGGALTRANS <= ?"
                            + "AND M.KATEGORI = ?"
                            + "GROUP BY DT.ID_MENU "
                            + "ORDER BY SUM(DT.QTY) DESC"
                    );
                ps.setString(1, tanggalAwal);
                ps.setString(2, tanggalAkhir);
                ps.setString(3, kategori);
            }
            
            ResultSet st = ps.executeQuery();
            int counter = 1;
            while (st.next()) {
                if(counter <= banyakData){
                    dfm.addRow(new Object[]{st.getString("Nama"),st.getString("Jumlah")});     
                    counter += 1;
//                    System.out.println("nama " + st.getString("Nama") + " || jumlah " + st.getString("Jumlah"));
                }else{
                    break;
                }
            }
        } catch (Exception exc) {
            throw new Exception("Maaf ada kesalahan dalam query Menu Favorit\n" + exc.getMessage());
        }
        return dfm;
    }
    
    public static DefaultTableModel tabelHeaderLaporan(String tanggalAwal, String tanggalAkhir) throws Exception{
        //function ini untuk menampilkan tabel preview laporan di form cetak laporan
        if (cekDate(tanggalAwal)==false || cekDate(tanggalAkhir)==false) {
            throw new Exception("Format tanggal harus benar (YYYY-MM-DD)");
        }
        String[] rows = {"Tanggal","Kasir", "Metode Pembayaran","Total"}; 
        DefaultTableModel dfm = new DefaultTableModel(rows,0);
         try {
            PreparedStatement ps = conn.prepareStatement
                            ("SELECT h.nomorNota as \"nomorNota\",\n" +
                            "h.tanggalTrans as \"tanggalTrans\",\n" +
                            "h.jamTrans as \"jamTrans\",\n" +
                            "h.metodePembayaran as \"metodePembayaran\",\n" +
                            "h.total as \"total\",\n" +
                            "k.nama as \"nama Karyawan\",\n" +
                            "h.status as \"status\",\n" +
                            "rpad(h.tanggalTrans,12) as \"tanggal1\",\n" +
                            "rpad(k.nama,12) as \"Kasir1\",\n" +
                            "rpad(h.metodePembayaran,20) as \"Metode Pembayaran1\",\n" +
                            "rpad(h.total,11) as \"Total1\"\n" +
                            "FROM htrans h join karyawan k ON k.id_karyawan=h.id_karyawan\n" +
                            "where h.tanggalTrans>=? and h.tanggalTrans<=?");
            ps.setString(1, tanggalAwal);
            ps.setString(2, tanggalAkhir);  
            ResultSet st = ps.executeQuery();
            while (st.next()) { 
                dfm.addRow(new Object[]{
                    st.getString("tanggalTrans"),st.getString("nama Karyawan"),
                    st.getString("metodePembayaran"),st.getString("total"),
                    st.getString("Status")});     
            }   
        } catch (Exception exc) {
            throw new Exception("Maaf ada kesalahan dalam memuat laporan \n"+exc.getMessage());
        }
        return dfm;
    }
    public static int totalHeaderLaporan(String tanggalAwal, String tanggalAkhir) throws Exception{
        //function ini untuk mencetak total pendapatan dari suatu periode laporan
          if (cekDate(tanggalAwal)==false || cekDate(tanggalAkhir)==false) {
            throw new Exception("Format tanggal harus benar (YYYY-MM-DD)");
        }
        int txtal = 0;
        ArrayList<Transaction> listTransaction = new ArrayList<>();
            ArrayList<String> listheader = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement
                            ("SELECT h.nomorNota as \"nomorNota\",\n" +
                            "h.tanggalTrans as \"tanggalTrans\",\n" +
                            "h.jamTrans as \"jamTrans\",\n" +
                            "h.metodePembayaran as \"metodePembayaran\",\n" +
                            "h.total as \"total\",\n" +
                            "k.nama as \"nama Karyawan\",\n" +
                            "h.status as \"status\",\n" +
                            "rpad(h.tanggalTrans,12) as \"tanggal1\",\n" +
                            "rpad(k.nama,12) as \"Kasir1\",\n" +
                            "rpad(h.metodePembayaran,20) as \"Metode Pembayaran1\",\n" +
                            "rpad(h.total,11) as \"Total1\"\n" +
                            "FROM htrans h join karyawan k ON k.id_karyawan=h.id_karyawan\n" +
                            "where h.tanggalTrans>=? and h.tanggalTrans<=?");
            ps.setString(1, tanggalAwal);
            ps.setString(2, tanggalAkhir);  
            ResultSet st = ps.executeQuery();
            while (st.next()) {
                listTransaction.add(new Transaction(st.getString("nomorNota"), 
                        st.getString("tanggalTrans"), st.getString("metodePembayaran"), 
                        Integer.parseInt(st.getString("total")), 
                        st.getTime("jamTrans")+"",
                        st.getString("nama Karyawan"), Integer.parseInt(st.getString("status"))));   
                listheader.add(st.getString("tanggal1")+"|"+st.getString("Kasir1")+"|"+
                        st.getString("Metode Pembayaran1")+"|"+st.getString("Total1")+"|");
            } 
            for (int i = 0; i < listTransaction.size(); i++) {
                txtal += listTransaction.get(i).getTotal();
            } 
            
        } catch (Exception exc) {
            throw new Exception("Maaf ada kesalahan dalam memuat laporan \n"+exc.getMessage());
        }
        return txtal;
    } 
    private static boolean cekDate(String tgl){ 
        try {
            String[] temp;
            temp = tgl.split("-");
            int tahun = Integer.parseInt(temp[0]);
            int bulan = Integer.parseInt(temp[1]);
            int tanggal = Integer.parseInt(temp[2]);
            String tahunstr = tahun + "";
            if ((tanggal > 0 && tanggal < 32) && (bulan > 0 && bulan < 13) && (tahun > 0) && (tahunstr.length() == 4)) {
                return true;
            } 
        } 
        catch (Exception e) {
            return false;
        } 
        return false;
    }
    
    

}   

