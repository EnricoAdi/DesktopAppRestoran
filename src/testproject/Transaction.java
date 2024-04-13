 
package testproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    private String nomorNota;
    private String tglTrans;
    private String metodePembayaran;
    private int total;
    private String jam;
    private String namaKasir;
    private int statusNomorMeja;
    private ArrayList<DTrans> listPesanan = new ArrayList<>();

    public Transaction(String nomorNota, String tglTrans,
            String metodePembayaran, int total, String jam, 
            String namaKasir, int statusNomorMeja) {
        this.nomorNota = nomorNota;
        this.tglTrans = tglTrans;
        this.metodePembayaran = metodePembayaran;
        this.total = total;
        this.jam = jam;
        this.namaKasir = namaKasir;
        this.statusNomorMeja = statusNomorMeja;
    }

    public int getStatusNomorMeja() {
        return statusNomorMeja;
    }

    public void setStatusNomorMeja(int statusNomorMeja) {
        this.statusNomorMeja = statusNomorMeja;
    }

    public String getNomorNota() {
        return nomorNota;
    }

    public void setNomorNota(String nomorNota) {
        this.nomorNota = nomorNota;
    }

    public String getTglTrans() {
        return tglTrans;
    }

    public void setTglTrans(String tglTrans) {
        this.tglTrans = tglTrans;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getNamaKasir() {
        return namaKasir;
    }

    public void setNamaKasir(String namaKasir) {
        this.namaKasir = namaKasir;
    }

    public ArrayList<DTrans> getListPesanan() {
        return listPesanan;
    }

    public void setListPesanan(ArrayList<DTrans> listPesanan) {
        this.listPesanan = listPesanan;
    }
    
    public static String generateNomorNota(){
        String hasil = "NOTA";
        int urutan = 10001;
        
        //getTanggal
        Date dateNow = new Date();
        String dataDate = new SimpleDateFormat("ddMMyyyy").format(dateNow);
        
        hasil += dataDate;
        
        //getNomorUrutNota
        try {
            Class.forName("com.mysql.jdbc.Driver"); //dapat dari service
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pbo_proyek", "root", "");
            Statement statement = conn.createStatement();
            
            //String query = "select count(substr(nomorNota,1,12)) from htrans where nomorNota = '" + hasil + "'";
            String query = "select " + "count(substr(nomorNota,1,12))" + " from htrans where substr(nomorNota,1,12) = '" + hasil + "'" ;
            ResultSet resultSet = statement.executeQuery(query);
            
            
            while(resultSet.next()){
                urutan += resultSet.getInt(1);
//                System.out.println("hasil query     : " + resultSet.getString(1));
//                System.out.println("hasil generate  : " + hasil);
            }
            //System.out.println("jumlah urutan : " + urutan);
        } catch (Exception ex) {
            System.out.println("error genNota : " + ex.getMessage());
        }
        
        //menyatukan Hasil
        hasil += String.valueOf(urutan).substring(1);
        
        return hasil;
    }
    
    public static void insertTableHTrans(String nomorNota, String metodePembayaran, int total, int idKaryawan, int status) throws Exception {
        if (metodePembayaran.equals("")) {
            throw new Exception("Metode pembayaran harus diisi"); 
        }
        String tanggal = "";
        String jam = "";
        
        //get tanggal
        tanggal = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        
        //get jam
        jam = java.time.LocalDateTime.now().toString();
        
        PreparedStatement ps = DB.conn.prepareStatement
            ("insert into htrans (nomorNota, tanggalTrans, jamTrans, metodePembayaran, total, id_karyawan, status) values (?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, nomorNota);
        ps.setString(2, tanggal);
        ps.setString(3, jam);
        ps.setString(4, metodePembayaran);
        ps.setInt(5, total);
        ps.setInt(6, idKaryawan);
        ps.setInt(7, status);

        int hasil = ps.executeUpdate();
//        System.out.println("status query htrans : " + hasil);
    }
    
    public static void insertTableDTrans(String nomorNota, int idMenu, int qty, int harga) throws Exception {
        
        int total = harga * qty;
        
        PreparedStatement ps = DB.conn.prepareStatement
            ("insert into dtrans (nomorNota, id_menu, qty, harga, subtotal) values (?, ?, ?, ?, ?)");
        ps.setString(1, nomorNota);
        ps.setInt(2, idMenu);
        ps.setInt(3, qty);
        ps.setInt(4, harga);
        ps.setInt(5, total);
        
        int hasil = ps.executeUpdate();
//        System.out.println("status query dtrans : " + hasil);
    }
}
