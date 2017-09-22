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
import manage.file.FileManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Iterate over a JSON array
 * Display books released since 1990
 */
public class Exercice2 {
    public static void main(String[] args) throws Exception {
        String json = FileManager.createStringFromFileContent("json", "catalogue.json");
        JSONArray livres = JSONArray.fromObject(json);

        System.out.println("livres parus depuis 2010:");
        int cpt = 0;
        for(int i = 0; i < livres.size(); i++) {
            JSONObject livre = livres.getJSONObject(i);
            if(livre.getInt("annee") >= 2010) {
                   cpt += 1;
                   System.out.println(" * " + livre.getString("titre"));
            }
        }
        System.out.println("Il y a " + livres.size() + " livre(s) dans le catalogue dont " + cpt + " paru(s) depuis 2010.");
    }
}