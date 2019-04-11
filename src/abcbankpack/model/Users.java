/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abcbankpack.model;

import abcbankpack.Database.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sir Lash
 */
public class Users {
    
    private String userId;
    private String username;
    private String password;
    
    public Users()
    {
        
    }
    
    public boolean isLoginOk(String newUsername, String newPassword)
    {
        boolean loginOk = false;
        
        try
            (
                Connection con = Database.getMyConnection();
                Statement stat = con.createStatement();
                ResultSet rs = stat.executeQuery("select * from AccountUsers" )
            )
        {
            
            rs.next();
            
            setUsername(rs.getString("cusername"));
            setPassword(rs.getString("cpassword"));
            
            if(newUsername.equalsIgnoreCase(getUsername().trim()) && newPassword.equals(getPassword().trim()))
            {
                loginOk = true; 
            }

            
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return loginOk;
    }
    
    

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
