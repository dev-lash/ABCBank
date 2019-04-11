/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abcbankpack.Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Sir Lash
 */
public class Database {
    private static Connection con;
    
    public static Connection getMyConnection()
            {
                try 
                {
                    File file = new File("ConnectionFile.properties");
                    String pathFile = file.getPath();
                    Properties fileName = new Properties();
                    fileName.load(new FileInputStream(pathFile));
                    
                    con = DriverManager.getConnection(fileName.getProperty("conString"), fileName.getProperty("userNameDb"), fileName.getProperty("passwordDb"));
                } 
                catch (IOException | SQLException ex) 
                {
                    System.out.println(ex.getMessage());
                }
                
                return con;
            }
    
}
