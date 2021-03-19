/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testergui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static testergui.DBconnect.connect;
/**
 *
 * @author ayesh
 */
public class TesterGui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException{
        // TODO code application logic here
        new Login().setVisible(true);
        //new Customer().setVisible(true);
        //connect();
        
    }
    
}
