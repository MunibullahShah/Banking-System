/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testergui;

/**
 *
 * @author ayesh
 */
public class CustomerViewData {
    int cuid;
    String fname;
    String lName;
    int NIC;
    String address;
    int phoneno;
    String Email;
    String pasword;
    int brid;

    public CustomerViewData(int cuid, String fname, String lName, int NIC, String address, int phoneno, String Email, String pasword, int brid) {
        this.cuid = cuid;
        this.fname = fname;
        this.lName = lName;
        this.NIC = NIC;
        this.address = address;
        this.phoneno = phoneno;
        this.Email = Email;
        this.pasword = pasword;
        this.brid = brid;
    }
    
}
