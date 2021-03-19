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
public class StaffData {
    int stid;
    String fname;
    String lname;
    int nic;
    String dob;
    String address;
    int phoneno;
    String password;
    int brid;
    String rank;

    public StaffData(int stid, String fname, String lname, int nic, String dob, String address, int phoneno, String password, int brid, String rank) {
        this.stid = stid;
        this.fname = fname;
        this.lname = lname;
        this.nic = nic;
        this.dob = dob;
        this.address = address;
        this.phoneno = phoneno;
        this.password = password;
        this.brid = brid;
        this.rank = rank;
    }
    
}
