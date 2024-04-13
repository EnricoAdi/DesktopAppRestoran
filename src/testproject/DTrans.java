
package testproject; 
public class DTrans extends Menu{
    private int quantity; 
    private int subtotal;
    public DTrans(int idMenu, String namaMenu, String category, int harga, int status, int q) {
        super(idMenu, namaMenu, category, harga, status,"");
        this.quantity = q;
        this.subtotal = harga*q;
    }
    public int getSubtotal(){
        return super.getHarga()*quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }  
    @Override
    public String toString() {
        return super.getNamaMenu()+" "+getQuantity()+" x "+super.getHarga()+" -> "+getSubtotal();
    }
    
}
