/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author pedago
 */
public class Order {
    private int numero;
    private String client;
    private Date saisie;
    private Date envoi;
    private float port;
    private String destinataire;
    private String adresse_livraison;
    private String ville_livraison;
    private String region_livraison;
    private String code_postal;
    private String pays;
    private float remise;
    
    public Order(int num,String cli,Date s,Date env,float p, String desti, String addr_livraison,String ville_liv,String reg_livraison,String code,String country,float discount){
        this.numero=num;
        this.client=cli;
        this.saisie=s;
        this.envoi=env;
        this.port=p;
        this.destinataire=desti;
        this.adresse_livraison=addr_livraison;
        this.ville_livraison=ville_liv;
        this.region_livraison=reg_livraison;
        this.code_postal=code;
        this.pays=country;
        this.remise=discount;
    }
    
    public String getClient(){
        return this.client;
    }
    
    public int getNumCommande(){
        return this.numero;
    }
    
    public Date getDateSaisie(){
        return this.saisie;
    }
    
    public Date getDateEnvoi(){
        return this.envoi;
    }
    
    public float getFloat(){
        return this.port;
    }
    
    public String getDestinataire(){
        return this.destinataire;
    }
    
    public String getAdresseLivraison(){
        return this.adresse_livraison;
    }
    
    public String getVille(){
        return this.ville_livraison;
    }
    
    public String getRegion(){
        return this.region_livraison;
    }
    
    public String getCodePostal(){
        return this.code_postal;
    }
    
    public String getCountry(){
        return this.pays;
    }
    
    public float getDiscount(){
        return this.remise;
    }
    
}
