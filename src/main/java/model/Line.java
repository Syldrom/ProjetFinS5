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
public class Line {
    private int commande;
    private int produit;
    private int quantite;
    
    public Line(int c,int p,int q){
        this.commande=c;
        this.produit=p;
        this.quantite=q;
    }
    
    public int getOrder(){
        return this.commande;
    }
    
    public int getProduct(){
        return this.produit;
    }
    
    public int getQuantity(){
        return this.quantite;
    }
    
}
