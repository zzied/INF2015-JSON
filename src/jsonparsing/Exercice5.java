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
import java.text.DecimalFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Generate JSON
 * Build a full order from catalog
 */
public class Exercice5 {
    public static void main(String[] args) throws Exception {
        String json = FileReader.loadFileIntoString("json/catalogue.json", "utf-8");
        JSONArray lvrs = JSONArray.fromObject(json);

        // Build the livre list to add in the order
        JSONArray livres = new JSONArray();
        double total = 0.0;
        for(int i = 0; i < lvrs.size(); i++) {
            JSONObject livre = lvrs.getJSONObject(i);
            if(livre.getDouble("prix") < 100.0) {
                   total += livre.getDouble("prix");
                   livres.add(livre);
            }
        }

        // Format the price
        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(2);
        String totalStr = format.format(total);

        // Build the order
        JSONObject order = new JSONObject();
        order.accumulate("id", "1321033823");
        order.accumulate("total", totalStr);
        order.accumulate("date", "11/11/2011");
        order.accumulate("validation", true);
        order.accumulate("livres", livres);

        System.out.println(order);
    }
}