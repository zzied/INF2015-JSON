/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonparsing;

/**
 *
 * @author Zied Zaier < Zaier.Zied at uqam.ca>
 */
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Generate a JSON String
 Build an commande manually
 */
public class Exercice4 {
    public static void main(String[] args) throws Exception {
        // Build the order object
        JSONObject commande = new JSONObject();
        commande.accumulate("id", "1321033823");
        commande.accumulate("total", 49.9);
        commande.accumulate("date", "11/11/2011");
        commande.accumulate("validation", true);

        // Build another object for representing the book
        JSONObject livre = new JSONObject();
        livre.accumulate("id", "1");
        livre.accumulate("titre", "Database System Concepts");

        // Build a JSON array of books
        JSONArray albums = new JSONArray();
        albums.add(livre);

        // Add the array to the order
        commande.accumulate("livres", albums);

        System.out.println(commande);
    }
}