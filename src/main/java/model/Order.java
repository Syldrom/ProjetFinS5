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

    public Order(int numero, String client, Date saisie, Date envoi, float port, String destinataire, String adresse_livraison, String ville_livraison, String region_livraison, String code_postal, String pays, float remise) {
        this.numero = numero;
        this.client = client;
        this.saisie = saisie;
        this.envoi = envoi;
        this.port = port;
        this.destinataire = destinataire;
        this.adresse_livraison = adresse_livraison;
        this.ville_livraison = ville_livraison;
        this.region_livraison = region_livraison;
        this.code_postal = code_postal;
        this.pays = pays;
        this.remise = remise;
    }

    
    
    public int getNumero() {
        return numero;
    }

    public String getClient() {
        return client;
    }

    public Date getSaisie() {
        return saisie;
    }

    public Date getEnvoi() {
        return envoi;
    }

    public float getPort() {
        return port;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public String getAdresse_livraison() {
        return adresse_livraison;
    }

    public String getVille_livraison() {
        return ville_livraison;
    }

    public String getRegion_livraison() {
        return region_livraison;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public String getPays() {
        return pays;
    }

    public float getRemise() {
        return remise;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setSaisie(Date saisie) {
        this.saisie = saisie;
    }

    public void setEnvoi(Date envoi) {
        this.envoi = envoi;
    }

    public void setPort(float port) {
        this.port = port;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public void setAdresse_livraison(String adresse_livraison) {
        this.adresse_livraison = adresse_livraison;
    }

    public void setVille_livraison(String ville_livraison) {
        this.ville_livraison = ville_livraison;
    }

    public void setRegion_livraison(String region_livraison) {
        this.region_livraison = region_livraison;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setRemise(float remise) {
        this.remise = remise;
    }


    
    
    
}
