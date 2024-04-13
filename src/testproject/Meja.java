
package testproject;

//PROJECT PBO

import java.util.ArrayList;

public class Meja implements java.io.Serializable{
    static Meja[] listMeja = new Meja[12]; 
    private int nomerMeja;
    private ArrayList<DTrans> listPesanan = new ArrayList<>();

    public Meja(int nomor) {
        this.nomerMeja = nomor;
    }
    public static boolean cekCloseForm(){
        //cek apakah ketika form mau ditutup masih ada pesanan blm dieksekusi  
         for (int i = 0; i < listMeja.length; i++) {
             if (listMeja[i].getListPesanan().size()>0) {
                 return false;
             }
        }
        return true;
    }

    public int getNomerMeja() {
        return nomerMeja;
    }

    public void setNomerMeja(int nomerMeja) {
        this.nomerMeja = nomerMeja;
    }

    public ArrayList<DTrans> getListPesanan() {
        return listPesanan;
    }

    public void setListPesanan(ArrayList<DTrans> listPesanan) {
        this.listPesanan = listPesanan;
    }

    public static void initMeja(){
       for (int i = 0; i < 12; i++) {
            listMeja[i] = new Meja(i+1);
        }
    }
    
    public int getTotal(){
        int oo = 0;
        for (int i = 0; i < listPesanan.size(); i++) {
            oo+= listPesanan.get(i).getSubtotal();
        }
        return oo;
    }
    
}