/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abcbankpack.model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Sir Lash
 */
public class MyIconImage {
    
    public MyIconImage()
    {
        
    }
    
    public Image getIconImage()
    {
        ImageIcon LogoImage2 = new ImageIcon(getClass().getResource("/abcbankpack/imgFol/zt.gif"));
        
        Image im = LogoImage2.getImage();
        
        return im;
    }
    
}
