/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import ecuaciones.Triangulo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author rod06
 */
@WebServlet(name = "TriangleServlet", urlPatterns = {"/TriangleServlet"})
public class TriangleServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TriangleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TriangleServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        int base = Integer.parseInt(request.getParameter("baseTriangulo"));
        int altura = Integer.parseInt(request.getParameter("alturaTriangulo"));
        
        Triangulo triangulo = new Triangulo(base, altura);
        
        triangulo.obtenerArea();
        triangulo.obtenerPerimetro();
        int area = triangulo.getArea();
        int perimetro = triangulo.getPerimetro();
        
        HttpSession session = request.getSession();
        String nombre = (String) session.getAttribute("nombre");
        if(nombre == null){
            nombre = request.getParameter("nombre");
            session.setAttribute("nombre", nombre);
        }
        
        Cookie baseCookie = new Cookie("base", String.valueOf(base));
        Cookie alturaCookie = new Cookie("altura", String.valueOf(altura));
        Cookie areaCookie = new Cookie("area", String.valueOf(area));
        Cookie perimetroCookie = new Cookie("perimetro", String.valueOf(perimetro));
        response.addCookie(baseCookie);
        response.addCookie(alturaCookie);
        response.addCookie(areaCookie);
        response.addCookie(perimetroCookie);
        
        response.sendRedirect("resultado.jsp");
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
