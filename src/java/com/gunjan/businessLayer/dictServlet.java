/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunjan.businessLayer;

import com.gunjan.dataAccessLayer.DBConnection;
import com.gunjan.dataAccessLayer.Definition;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author 984852
 */
public class dictServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String queryWord = request.getParameter("word").trim();
//        System.out.println("queryword----------------" + queryWord);
//        DBConnection conn = DBConnection.getConnection();
//        System.out.println("conn  ------------------------" + conn);
//        ArrayList<Definition> wordDefinitions = conn.getDefinition(queryWord);
//        if (wordDefinitions != null) {
//            String definitions = wordDefinitions.stream().map(d -> "<br>" + d).collect(Collectors.joining());
//            request.setAttribute("definitions", definitions);
//        }
        String JSONObject = getJSONObjectForWord(queryWord);
        request.getSession().setAttribute("JSONObject", JSONObject);

        RequestDispatcher dispatch = request.getRequestDispatcher("getJSON.jsp");
        dispatch.forward(request, response);

    }

    protected String getJSONObjectForWord(String word) throws IOException {
        DBConnection conn = DBConnection.getConnection();
        ArrayList defs = conn.getDefinition(word);
        if(defs == null){
            defs = new ArrayList();
        }
        Iterator<Definition> it = defs.iterator();
        JSONArray defList = new JSONArray();
        while (it.hasNext()) {
            Definition d = (Definition) it.next();
            JSONObject obj = new JSONObject();
            obj.put("type", d.getType());
            obj.put("definition", d.getDefinition());
            defList.add(obj);
        }
        JSONObject mainObj = new JSONObject();
        mainObj.put("word", word);
        mainObj.put("definitions", defList);

        StringWriter out = new StringWriter();
        mainObj.writeJSONString(out);

        String jsonText = out.toString();
        return jsonText;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("definitions", "No Definition Found");
        System.out.println("Get Method");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("definitions", "No Definition Found");
        System.out.println("Post Method");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
