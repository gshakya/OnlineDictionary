/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.gunjan.dataAccessLayer.DBConnection;
import com.gunjan.dataAccessLayer.Definition;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author 984852
 */
public class DBConnectionTest {
      
    public static void main(String[] args) throws IOException{
       
//        conn.getDefinition("Good").stream().forEach(d->System.out.println(d));
        
        getJSON();
    }
    public static void getJSON() throws IOException{
        DBConnection conn = DBConnection.getConnection();
        String word = "Help";
        ArrayList defs = conn.getDefinition(word);
        Iterator<Definition>  it = defs.iterator();
        JSONArray defList = new JSONArray();
        while(it.hasNext()){
            Definition  d = (Definition) it.next();
            JSONObject obj = new JSONObject();
            obj.put("type", d.getType());
            obj.put("definition",d.getDefinition());
            defList.add(obj);
        }
        JSONObject mainObj = new JSONObject();
        mainObj.put(word, defList);
        
      StringWriter out = new StringWriter();
      mainObj.writeJSONString(out);
      
      String jsonText = out.toString();
      System.out.print(jsonText);
        
    }
    
    
}
