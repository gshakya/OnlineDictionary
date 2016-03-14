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
    
}

class WordMap<String, Word> {

    private Map<String, ArrayList<Word>> m = new HashMap<>();

    public void put(String k, Word v) {
        if (m.containsKey(k)) {
            m.get(k).add(v);
        } else {
            ArrayList<Word> arr = new ArrayList<>();
            arr.add(v);
            m.put(k, arr);
        }
    }

    public ArrayList<Word> get(String k) {
        return m.get(k);
    }

    public Word get(String k, int index) {
        return m.get(k).size() - 1 < index ? null : m.get(k).get(index);
    }

}

class Word {

   private String type;
   private String meaning;

    public Word(String type, String meaning) {
        this.type = type;
        this.meaning = meaning;
    }

    public String getType() {
        return type;
    }

    public String getMeaning() {
        return meaning;
    }
    
    
}
