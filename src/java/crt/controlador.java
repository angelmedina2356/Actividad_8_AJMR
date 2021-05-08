/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crt;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Triangulo;
/**
 *
 * @author Angel
 */
public class controlador extends HttpServlet {

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
        if(request.getAttribute("flag")!=null)
        {
            request.setAttribute("flag", 1);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
            
            
        Triangulo t=new Triangulo();
        t.setNum1(Double.parseDouble(request.getParameter("num1")));
        t.setNum2(Double.parseDouble(request.getParameter("num2")));
        t.setName(request.getParameter("name"));
        t.Perimetro();
        t.Area();
        t.Name();
        Cookie ck=new Cookie("num1",t.getNum1()+"");
        response.addCookie(ck);
        ck=new Cookie("num2",t.getNum2()+"");
        response.addCookie(ck);
        ck=new Cookie("perimetro",t.getPerimetro()+"");
        response.addCookie(ck);
        ck=new Cookie("area",t.getArea()+"");
        response.addCookie(ck);
        
        HttpSession sesion=request.getSession(false);
        sesion.setAttribute("name",t.getName());
       
        
        
        request.setAttribute("OnjetoJava", t);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.println("controlador");
            RequestDispatcher a=request.getRequestDispatcher("resultados.jsp");
            a.forward(request, response);
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
