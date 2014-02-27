import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DisplayEmail extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ln = System.lineSeparator();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>"+ln
                +"<html>"+ln
                +"<head>"+ln
                +"<title>Servlet DisplayEmail</title>"+ln
                +"</head>"+ln
                +"<h1> Thanks for joining our EmailList</h1>"+ln
                +"<p>Here id the information you enterd:</p>"+ln
                +"<table cellspacing=\"5\" cellpading = \"5\" border = \"1\">"+ln
                +"<tr><td align =\"right\">First name:</td>"+ln
                +"<td>"+firstName+"</td>"+ln
                +"</tr>"+ln
                +"<tr><td align =\"right\">Last name:</td>"+ln
                +"<td>"+lastName+"</td>"+ln
                +"</tr>"+ln
                +"<tr><td align =\"right\">Email address:</td>"+ln
                +"<td>"+emailAddress+"</td>"+ln
                +"</tr>"+ln
                +"</table>"+ln
                +"<body>"+ln
                +"<body>"+ln
                +"<body>"+ln
                +"<h1>Servlet DisplayEmail at " + request.getContextPath() + "</h1>"+ln
                +"</body>"+ln
                +"</html>");
            
        } finally {
            out.close();
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
