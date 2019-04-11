/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abcbankpack.model;

import abcbankpack.Database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Sir Lash
 */
public class Transactions {
    
    private int transId;
    private int accountNo;
    private String transType;
    private double amount;
    private String amtInWords;
    
    public Transactions()
    {
        
    }
    
    public boolean doTransaction(int newAcctNo, String newTransType, double newAmt, String newAmtInwords)
    {
        boolean isDoTrans = false;
        
         try
        (
            Connection con = Database.getMyConnection();
            PreparedStatement prs = con.prepareStatement("insert into Transactions" + "(iacno, amount, AmtInWords, TransType)" + "values (?,?,?,?)");
        )
         {
             prs.setInt(1, newAcctNo);
             prs.setDouble(2, newAmt);
             prs.setString(3, newAmtInwords);
             prs.setString(4, newTransType);
             
             int rowsAffected = prs.executeUpdate();
             if(rowsAffected > 0)
             {
                 isDoTrans = true;
             }
             
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
         
         return isDoTrans;
    }

    /**
     * @return the transId
     */
    public int getTransId() {
        return transId;
    }

    /**
     * @param transId the transId to set
     */
    public void setTransId(int transId) {
        this.transId = transId;
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
     * @return the transType
     */
    public String getTransType() {
        return transType;
    }

    /**
     * @param transType the transType to set
     */
    public void setTransType(String transType) {
        this.transType = transType;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the amtInWords
     */
    public String getAmtInWords() {
        return amtInWords;
    }

    /**
     * @param amtInWords the amtInWords to set
     */
    public void setAmtInWords(String amtInWords) {
        this.amtInWords = amtInWords;
    }
    
}
