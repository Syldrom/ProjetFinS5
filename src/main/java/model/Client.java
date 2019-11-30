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
    
    public Client(String cod,String societ,String contac,String fonctio,String addr,String city,String regio,String postal,String country,String tel,String faX){
        this.code=cod;
        this.societe=societ;
        this.contact=contac;
        this.fonction=fonctio;
        this.adresse=addr;
        this.ville=city;
        this.region=regio;
        this.code_postal=postal;
        this.pays=country;
        this.telephone=tel;
        this.fax=faX;
    }
    
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
}
