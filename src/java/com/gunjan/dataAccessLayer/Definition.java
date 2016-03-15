/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunjan.dataAccessLayer;

/**
 *
 * @author grsky
 */
public class Definition {

    private String type;
    private String meaning;

    public Definition(String type, String meaning) {
        this.type = type;
        this.meaning = meaning;
    }

    public String getType() {
        return type;
    }

    public String getMeaning() {
        return meaning;
    }
    
    @Override
    public String toString(){
        return "("+type+") ::"+meaning;
    }

}
