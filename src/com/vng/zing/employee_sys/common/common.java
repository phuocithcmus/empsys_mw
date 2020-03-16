/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.employee_sys.common;

import java.sql.*;
import com.mysql.jdbc.Driver;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cpu11129
 */
public class common {
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_system_demo","root","Aa123456");  
            return con;
        }
        catch(Exception e){ 
            System.out.println(e);
        } 
        return null;
    }
    
    public static void closeConnection() throws SQLException{
        getConnection().close();
    }
}
