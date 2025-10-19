// package com.framework.servlet;

// import java.io.IOException;
// import java.io.PrintWriter;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class FrontServlet extends HttpServlet {

//     @Override
//     public void service(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {
//         response.setContentType("text/plain");
//         PrintWriter out = response.getWriter();
//         out.println("URL demandée: " + request.getRequestURL().toString());
//         System.out.println("URL demandée: " + request.getRequestURL().toString());
//     }

//     @Override
//     public void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {
//         service(request, response);
//     }

//     @Override
//     public void doPost(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {
//         service(request, response);
//     }
// }

package com.framework.servlet;
//package com.framework.servlet;;;;;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontServletBis extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        chercherRessource(req, res);
    }

    private void chercherRessource(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String path = req.getRequestURI().substring(req.getContextPath().length());
        boolean resourceExist = getServletContext().getResource(path) != null;

        if (resourceExist) {
            RequestDispatcher defaultDispatcher = getServletContext().getNamedDispatcher("default");
            if (defaultDispatcher != null) {
                defaultDispatcher.forward(req, res);
            } else {
                res.getWriter().println(path);
            }
        } else {
            res.getWriter().println(path);
        }
    }
}
