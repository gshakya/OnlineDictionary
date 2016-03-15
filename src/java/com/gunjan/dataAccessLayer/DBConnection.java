/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunjan.dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 984852
 */
public class DBConnection {

    private static DBConnection connection;
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private WordMap wordMap = new WordMap();

    private DBConnection() {
        conn = null;

        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost/entries" , "entries" , "mysql");

            stmt = conn.createStatement();
            if (stmt.execute("SELECT * FROM entries")) {
                rs = stmt.getResultSet();
            }
            
            while(rs.next()) { 
                String word = rs.getString("word");
//                System.out.println("-------Word--------"+word);
                String wordtype = rs.getString("wordtype");
                if(wordtype==null){
                    wordtype = "";
                }
                String definition = rs.getString("definition");
//                System.out.println(definition);
                Definition def = new Definition(wordtype, definition);
//                 System.out.println("Word Definiton:----------"+def);
                wordMap.put(word,def );
             }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
    
   public static DBConnection getConnection(){
       if(connection== null){
           connection = new DBConnection();
       }
       return connection;
   }
   
   public ArrayList<Definition> getDefinition(String word){
       return wordMap.get(word);
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

