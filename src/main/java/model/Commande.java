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
public class Commande {
    private int numero;
    private String client;
    private Date saisie;
    private Date envoi;
    private float port;
    private String destinataire;
    private String adresse_livraison;
    private String ville_livraison;
    private String region_livraison;
    private int code_postal;
    private String pays;
    private float remise;
}
