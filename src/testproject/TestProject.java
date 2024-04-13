/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.util.logging.Level;
import java.util.logging.Logger; 
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author calvi
*/
public class TestProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // inisiasi keperluan koneksi dan inisiasi array 
        try { 
            DB.initConn();
            Meja.initMeja();
            Menu.initMenu(); 
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        //tampilkan form login untuk memulai aplikasi
        Login l = new Login();
        l.setTitle("Ga Kenyang Ga Pulang");
        l.setLocationRelativeTo(null);
        l.setVisible(true); 
    }
    
}
