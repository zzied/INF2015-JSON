/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zied Zaier < Zaier.Zied at uqam.ca>
 */
package jsonparsing;

import net.sf.json.JSONArray;

/**
 * Parse a JSONArray
 * Get the number of CDs contained in the array
 */
public class Exercice1 {
    public static void main(String[] args) throws Exception {
        String json = FileReader.loadFileIntoString("json/catalogue.json", "utf-8");
        JSONArray livres = JSONArray.fromObject(json);
        System.out.println("Il y a " + livres.size() + " livre(s) dans le catalogue.");


    }
}
