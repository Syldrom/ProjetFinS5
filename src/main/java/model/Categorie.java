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
public class Categorie {
    private int code;
    private String libelle;
    private String description;
    
    public Categorie(int c, String l, String d){
        this.code=c;
        this.libelle=l;
        this.description=d;
    }
    
    public String getLibelle(){
        return this.libelle;
    }
    
    public int getCode(){
        return this.code;
    }
    
    public String getDescription(){
        return this.description;
    }
    
}
