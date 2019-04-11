/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abcbankpack.model;

import abcbankpack.Database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sir Lash
 */
public class Customers {
    
    private int accountNo;
    private String firstname;
    private String lastname;
    private String gender;
    private String homeAd;
    private String phoneNumber;
    private double balance;
    private String officerId;
    
    
    public Customers()
    {
        
    }
    
    public boolean isRegister(String newName, String newSurname, String newGender, String newHomeAddress, String newPhoneNumber, double newBalance, String newOfficerId)
    {
        boolean isRegOk = false;
        
        try
        (
            Connection con = Database.getMyConnection();
            PreparedStatement prs = con.prepareStatement("insert into Customersacct" + "(vCusName, vCusSurname, cSex, vAddress, cPhoneNo, mBal, officersid)" 
                    + "values (?,?,?,?,?,?,?)");
        )
        {
            prs.setString(1, newName);
            prs.setString(2, newSurname);
            prs.setString(3, newGender);
            prs.setString(4, newHomeAddress);
            prs.setString(5, newPhoneNumber);
            prs.setDouble(6, newBalance);
            prs.setString(7, newOfficerId);
            
            int rowsAffected = prs.executeUpdate();
            if(rowsAffected > 0)
            {
                isRegOk = true;
                
                try
                    (
                        PreparedStatement p = con.prepareStatement("select * from Customersacct where vCusName = ?");
                        )
                {
                    p.setString(1, newName);
                    ResultSet rs = p.executeQuery();
                    rs.next();
                    
                    setAccountNo(rs.getInt("iAcNo"));
                }
                
                
                
            }
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        
        return isRegOk;
    }
    
    
    public void checkAccountBal(int newAccNo)
    {
        try
            (
                Connection con = Database.getMyConnection();
                PreparedStatement prs = con.prepareStatement("select * from customersacct where iAcNo = ?");
                )
        {
            prs.setInt(1, newAccNo);
            ResultSet rs = prs.executeQuery();
            rs.next();
            
            setAccountNo(rs.getInt("iAcNo"));
            setFirstname(rs.getString("vcusname"));
            setLastname(rs.getString("vcussurname"));
            setBalance(rs.getDouble("mbal"));
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
            
    

    /**
     * @return the accountNo
     */
    public int getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the homeAd
     */
    public String getHomeAd() {
        return homeAd;
    }

    /**
     * @param homeAd the homeAd to set
     */
    public void setHomeAd(String homeAd) {
        this.homeAd = homeAd;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the officerId
     */
    public String getOfficerId() {
        return officerId;
    }

    /**
     * @param officerId the officerId to set
     */
    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }
    
}
