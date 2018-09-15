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
 * Iterate over a JSON array
 * Display in available books
 */
public class Exercice3 {
    public static void main(String[] args) throws Exception {
        String json = FileReader.loadFileIntoString("json/catalogue.json","UTF-8");
        JSONArray livres = JSONArray.fromObject(json);

        System.out.println("Prix des livres disponibles:");
        int cpt = 0;
        for(int i = 0; i < livres.size(); i++) {
            JSONObject livre = livres.getJSONObject(i);
            if(livre.getBoolean("disponible")) {
                   cpt += 1;
                   System.out.println(" * " + livre.getString("titre") + ": " + livre.getDouble("prix") + "$");
            }
        }
        System.out.println("Il y a " + cpt + " livre(s) disponible(s).");
    }
}
