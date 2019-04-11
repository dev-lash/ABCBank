/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abcbankpack.model;

import abcbankpack.view.Home;
import javax.swing.UIManager;

/**
 *
 * @author Sir Lash
 */
public class AppMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e)
        {
            System.out.println("Error in setting WLAF");
        }
        
        Home hm = new Home();
        hm.setVisible(true);
        hm.setLocationRelativeTo(null);
    }
    
}
