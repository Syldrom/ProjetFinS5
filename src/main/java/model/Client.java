/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sylvain
 */
public class Client {
    private String code;
    private String societe;
    private String contact;
    private String fonction;
    private String adresse;
    private String ville;
    private String region;
    private String code_postal;
    private String pays;
    private String telephone;
    private String fax;
    
    public String getCode(){
        return this.code;
    }
    
    public String getSociety(){
        return this.societe;
    }
    
    public String getContact(){
        return this.contact;
    }
    
    public String getFunction(){
        return this.fonction;
    }
    
    public String getAdress(){
        return this.adresse;
    }
    
    public String getCity(){
        return this.ville;
    }
    
    public String getRegion(){
        return this.region;
    }
    
    public String getPostal(){
        return this.code_postal;
    }
    
    public String getCountry(){
        return this.pays;
    }
    
    public String getPhone(){
        return this.telephone;
    }
    
    public String getFax(){
        return this.fax;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
}
