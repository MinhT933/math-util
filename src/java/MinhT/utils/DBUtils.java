/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhT.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HHoang5719
 */
public class DBUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
         Connection conn= null;
        
        try {
           
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url= "jdbc:sqlserver://localhost:1433;databaseName=Assisgment";
        conn = DriverManager.getConnection(url, "sa", "12345");
        } catch (Exception e) {
            System.out.println("sai connect");
        }
        
        return conn;
        
    }
    
   
}
    
