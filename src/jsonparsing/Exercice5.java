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
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Generate JSON Build a full order from catalog
 */
public class Exercice5 {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws Exception {
        String json = utilities.FileReader.loadFileIntoString("json/catalogue.json");
        JSONArray lvrs = JSONArray.fromObject(json);

        // Build the livre list to add in the order
        JSONArray livres = new JSONArray();
        double total = 0.0;
        for (int i = 0; i < lvrs.size(); i++) {
            JSONObject livre = lvrs.getJSONObject(i);
            if (livre.getDouble("prix") < 100.0) {
                total += livre.getDouble("prix");
                livres.add(livre);
            }
        }

        // Format the price
        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(2);
        String totalStr = format.format(total);

        //get current date time with Date()
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
         String dateOrder = dateFormat.format(date);;
        // Build the order
        JSONObject order = new JSONObject();
        order.accumulate("id", "1321033823");
        order.accumulate("total", totalStr);
        order.accumulate("date", dateOrder);
        order.accumulate("validation", true);
        order.accumulate("livres", livres);

        System.out.println(order);

    }
}
