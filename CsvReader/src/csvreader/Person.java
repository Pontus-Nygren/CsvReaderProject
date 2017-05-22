/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvreader;

import java.util.ArrayList;


/**
 *
 * @author QuagMir
 */
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String roletype; 
    private String passWord;
    private ArrayList<CsvClass> csvList = new ArrayList();

   
    public Person() {
    }

      public Person(int id, String firstName, String lastName, String eMail, String roletype, String passWord) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.roletype = roletype;
        this.passWord = passWord;
    }

      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
       public ArrayList<CsvClass> getCsvList() {
        return csvList;
    }

    public void setCsvList(ArrayList<CsvClass> csvList) {
        this.csvList = csvList;
    }
  
    
            
}
