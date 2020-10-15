/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

/**
 *
 * @author minho
 */
public class ShoppingListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String param = (String) request.getParameter("action");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("username");
        
        System.out.println(param);
        
        if(param != null) {
        
        if(param.equals("logout")) {
            
            session.invalidate();
            session = request.getSession();
            
            response.sendRedirect("/JSTL/shoppinglist");
        } }
        
        else {
        if(name == null) {
        
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request,response); 
        }
        
        else {
            
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            request.setAttribute("name", name);
            request.setAttribute("items", items);
            
             getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
               .forward(request,response); 
               
        }
        }
            
    }   
        
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        HttpSession session = request.getSession();
        String action = (String) request.getParameter("action");
        
        System.out.println(action);
        
        if(action.equals("register")) {
            
            String username = (String) request.getParameter("name");
            ArrayList<String> items = new ArrayList<>();
            
            session.setAttribute("username", username);
            session.setAttribute("itemsList", items);
            
            request.setAttribute("name", username);
            request.setAttribute("itemList", items);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request,response); 
        }
        
        else if(action.equals("add")) {
            
            String item = (String) request.getParameter("add_item");
            ArrayList<String> updateList;
            
            if(session.getAttribute("itemList") == null) {
                updateList = new ArrayList<String>();
            }
            
            else {
                updateList = (ArrayList<String>) session.getAttribute("itemList");
            }
            
          updateList.add(item);
          session.setAttribute("itemList", updateList);
          String username = (String) session.getAttribute("username");
          
          request.setAttribute("itemList", updateList);
          request.setAttribute("name", username);
          
          getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request,response); 
            
        }
        
        else if(action.equals("delete")) {
            
            String item = (String) request.getParameter("item");
            ArrayList<String> updateList = (ArrayList<String>) session.getAttribute("itemList");
            
            for(int i=0; i<updateList.size(); i++) {
                
                if(updateList.get(i).equals(item)) {
                    updateList.remove(i);
                }
                
            }
          
          session.setAttribute("itemList", updateList);
          String username = (String) session.getAttribute("username");
          
          request.setAttribute("itemList", updateList);
          request.setAttribute("name", username);
          
          getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request,response); 
        }   
     }
}
        
        
        
        