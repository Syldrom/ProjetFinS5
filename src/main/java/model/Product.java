/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pedago
 */
public class Product {
    private int ref;
    private String nom;
    private int fournisseur;
    private int categorie;
    private String quantite;
    private float prix_uni;
    private int unites_en_stock;
    private int unites_commandees;
    private int niveau_de_reappro;
    private int disponibilite;
    
    public Product(int r,String name,int fourni,int cate,String qte,float prix,int stock,int commandees,int reappro,int dispo){
        this.ref=r;
        this.nom=name;
        this.fournisseur=fourni;
        this.categorie=cate;
        this.quantite=qte;
        this.prix_uni=prix;
        this.unites_en_stock=stock;
        this.unites_commandees=commandees;
        this.niveau_de_reappro=reappro;
        this.disponibilite=dispo;
    }
    
    public void setStock(int s){
        this.unites_en_stock=s;
    }
    
    public void decremStock(int s){
        this.unites_en_stock-=s;
    }
    
    public void setIndisponible(){
        this.disponibilite=1;
    }
    
    public void setDisponible(){
        this.disponibilite=0;
    }
    
}
