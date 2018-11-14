/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlPack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pedago
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {
    
    
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
        
            int maxi = 100;
            int mini = 0;
        
            HttpSession session = ((HttpServletRequest)request).getSession(true);
            String customer = (String) session.getAttribute("customer");
            
            
                           
                String playerName = request.getParameter("playerName");
                customer = playerName;

                if (playerName == null){ // Pas connecté, on va vers la page de login 
                    request.getRequestDispatcher("Login.jsp").forward(request, response); 
                }

                else{ // connecté, on continue le traitement de la requête
                    String bas = "bas";
                    String haut = "haut";

                    request.getSession(true).setAttribute("customer",playerName);
                    request.getSession(true).setAttribute("mini",mini);
                    request.getSession(true).setAttribute("maxi",maxi);

                    int nombreAleatoire = mini + (int)(Math.random() * ((maxi - mini) + 1));
                    
                    request.getSession(true).setAttribute("tentative",nombreAleatoire);

                    int proposition = request.getIntHeader("nombre");

                    if (proposition < nombreAleatoire) request.getSession(true).setAttribute("hauteur",bas);

                    else if (proposition > nombreAleatoire) request.getSession(true).setAttribute("hauteur",haut);

                    else request.getRequestDispatcher("Victoire.jsp").forward(request, response); 

                    request.getRequestDispatcher("jeu/Jeu.jsp").forward(request, response); 
                }
           
              
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
