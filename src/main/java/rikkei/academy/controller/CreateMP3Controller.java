package rikkei.academy.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateMP3Controller", value = "/mp3")
public class CreateMP3Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action  = request.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            case "create":
                showUploadMP3(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action  = request.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            case "create":
                actionUploadMP3(request,response);
                break;
        }
    }
    public void showUploadMP3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/upload/upload_file.jsp");
        dispatcher.forward(request,response);
    }
    public void actionUploadMP3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mp3 = request.getParameter("mp3");
        request.setAttribute("mp3", mp3);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
}
