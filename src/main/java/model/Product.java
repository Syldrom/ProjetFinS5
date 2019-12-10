/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

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
    
    //
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
    
    //TRANSFORMATEURS
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
    
    public boolean isDisponible(){
        return this.disponibilite==0;
    }
    
    public int getRef(){
        return this.ref;
    }
    
    public String getName(){
        return this.nom;
    }
    
    public int getFournisseur(){
        return this.fournisseur;
    }
    
    public int getCategory(){
        return this.categorie;
    }
    
    public String getQuantity(){
        return this.quantite;
    }
    
    public float getPrice(){
        return this.prix_uni;
    }
    
    public int getStock(){
        return this.unites_en_stock;
    }
    
    public int getUC(){
        return this.unites_commandees;
    }
    
    public int getReappro(){
        return this.niveau_de_reappro;
    }
    
    public int getDispo(){
        return this.disponibilite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.ref;
        hash = 19 * hash + Objects.hashCode(this.nom);
        hash = 19 * hash + this.fournisseur;
        hash = 19 * hash + this.categorie;
        hash = 19 * hash + Objects.hashCode(this.quantite);
        hash = 19 * hash + Float.floatToIntBits(this.prix_uni);
        hash = 19 * hash + this.unites_en_stock;
        hash = 19 * hash + this.unites_commandees;
        hash = 19 * hash + this.niveau_de_reappro;
        hash = 19 * hash + this.disponibilite;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.ref != other.ref) {
            return false;
        }
        if (this.fournisseur != other.fournisseur) {
            return false;
        }
        if (this.categorie != other.categorie) {
            return false;
        }
        if (Float.floatToIntBits(this.prix_uni) != Float.floatToIntBits(other.prix_uni)) {
            return false;
        }
        if (this.unites_en_stock != other.unites_en_stock) {
            return false;
        }
        if (this.unites_commandees != other.unites_commandees) {
            return false;
        }
        if (this.niveau_de_reappro != other.niveau_de_reappro) {
            return false;
        }
        if (this.disponibilite != other.disponibilite) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.quantite, other.quantite)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "ref=" + ref + ", nom=" + nom + ", fournisseur=" + fournisseur + ", categorie=" + categorie + ", quantite=" + quantite + ", prix_uni=" + prix_uni + ", unites_en_stock=" + unites_en_stock + ", unites_commandees=" + unites_commandees + ", niveau_de_reappro=" + niveau_de_reappro + ", disponibilite=" + disponibilite + '}';
    }
    
}
