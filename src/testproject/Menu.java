
package testproject;

//PROJECT PBO GAIS

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Menu {
    static ArrayList<Menu> listMenu = new ArrayList<>();
    private int idMenu;
    private String namaMenu;
    private String category;
    private int harga;
    private int status;
    private String imageURL;

    public Menu(int idMenu, String namaMenu, String category, int harga, int status, String url) {
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.category = category;
        this.harga = harga;
        this.status = status;
        this.imageURL = url;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public static void insertTableMenu(String namaMenu, String category, int harga, int status, String imgURL) throws Exception {
        if(namaMenu.equals("") || category.equals("") || harga <= 0 || (!(status == 0 || status == 1)) ){
            //exception
            throw new Exception("Field tidak boleh kosong dan harga harus > 0 !");
        }
        PreparedStatement ps = DB.conn.prepareStatement
                ("insert into menu (nama, kategori, harga, status, imageURL) values (?, ?, ?, ?, ?)");
        ps.setString(1, namaMenu);
        ps.setString(2, category);
        ps.setInt(3, harga);
        ps.setInt(4, status);
        ps.setString(5, imgURL); 

        ps.executeUpdate();
    }
    
    public static void updateTableMenu(int idMenu, String namaMenu, int harga, String kategori, int status, String url) throws Exception {
        if(namaMenu.equals("") || harga <= 0 || (!(status == 0 || status == 1)) ){
            throw new Exception("Field tidak boleh kosong dan harga harus > 0 !");
        }

        PreparedStatement pr = DB.conn.prepareStatement("update menu set nama = ?, harga = ?, kategori = ?, status = ?, imageURL = ? where id_menu = ?");

        pr.setString(1, namaMenu);
        pr.setInt(2, harga);
        pr.setString(3, kategori);
        pr.setInt(4, 1);
        pr.setString(5, url); 
        pr.setInt(6, idMenu);

        pr.executeUpdate();
    }
    
    public static void deleteTableMenu(int idMenu) throws Exception {
        int valid = -99;
        valid = idMenu;
        if(valid == -99){
            throw new Exception("ID Menu tidak boleh kosong !");
        }
        PreparedStatement pr = DB.conn.prepareStatement
                ("update menu set status = 0 where id_menu = ?");
        pr.setInt(1, idMenu);

        pr.executeUpdate();
    }
    
    public static void initMenu() throws Exception{
     listMenu.clear();  
     try {  
     PreparedStatement ps = DB.conn.prepareStatement
                         ("SELECT imageURL, id_menu as \"ID\",NAMA as \"Nama\", " +
                         "harga as \"Harga\", kategori as \"Kategori\","+
                         "status as \"Status\" FROM MENU WHERE status != 0\n"); 
         ResultSet st = ps.executeQuery();
         while (st.next()) { 
             listMenu.add(new Menu(Integer.parseInt(st.getString("ID")), st.getString("Nama"), st.getString("Kategori")
                     , Integer.parseInt(st.getString("Harga")),Integer.parseInt(st.getString("Status")),st.getString("imageURL") ));   
         } 
     } catch (Exception exc) {
         throw new Exception(exc.getMessage());
     }  
    }
    public static int findByNama(String nama){
        for (int i = 0; i < listMenu.size(); i++) {
            if (listMenu.get(i).getNamaMenu().equalsIgnoreCase(nama)) {
                return i;
            }
        }
        return -1;
    }
     
}
