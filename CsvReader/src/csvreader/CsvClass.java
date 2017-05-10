/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvreader;

/**
 *
 * @author QuagMir
 */
public class CsvClass {
   String date;
   String orderNr;
   String cFName;
   String CLName;
   String address;
   String comment;

   public CsvClass() {
    }
   
    public CsvClass(String date, String orderNr, String cFName, String CLName, String address, String comment) {
        this.date = date;
        this.orderNr = orderNr;
        this.cFName = cFName;
        this.CLName = CLName;
        this.address = address;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(String orderNr) {
        this.orderNr = orderNr;
    }

    public String getcFName() {
        return cFName;
    }

    public void setcFName(String cFName) {
        this.cFName = cFName;
    }

    public String getCLName() {
        return CLName;
    }

    public void setCLName(String CLName) {
        this.CLName = CLName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
   
  

    
   
}
