/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunjan.dataAccessLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 984852
 */
public class DBConnection {
    private WordMap wordDefinition = new WordMap() ;
    private static DBConnection connection;

    private DBConnection() {
        wordDefinition.put("A", new Definition("n", "A no 1"));
        wordDefinition.put("A", new Definition("v", "A no 2"));
        wordDefinition.put("A", new Definition("adj", "A no 3"));
        
        wordDefinition.put("B", new Definition("n", "B no 1"));
        wordDefinition.put("B", new Definition("v", "B no 2"));
        wordDefinition.put("B", new Definition("adj", "B no 3"));
    }
    
    
    public static DBConnection  getConnection(){
        if (connection == null){
            connection = new DBConnection();
        }
        return connection;
    }
    
    public ArrayList<Definition> findDefinitions (String word) {
        return wordDefinition.get(word);
    }
    
    
}

class WordMap<String, Definition> {

    private Map<String, ArrayList<Definition>> m = new HashMap<>();

    public void put(String k, Definition v) {
        if (m.containsKey(k)) {
            m.get(k).add(v);
        } else {
            ArrayList<Definition> arr = new ArrayList<>();
            arr.add(v);
            m.put(k, arr);
        }
    }

    public ArrayList<Definition> get(String k) {
        return m.get(k);
    }

    public Definition get(String k, int index) {
        return m.get(k).size() - 1 < index ? null : m.get(k).get(index);
    }

}

