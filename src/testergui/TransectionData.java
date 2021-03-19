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
public class TransectionData {
    int accidto;
    int accidfrom;
    int amount;
    String date;
    String type;
    public TransectionData(int accidfrom, int accidto, int amount, String date, String type) {
        this.accidto = accidto;
        this.accidfrom = accidfrom;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }
    
    
}
