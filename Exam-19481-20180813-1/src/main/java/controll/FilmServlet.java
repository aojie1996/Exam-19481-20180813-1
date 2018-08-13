package controll;

import dao.beanCl;
import impl.ImplDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilmServlet extends HttpServlet {
    ImplDao i = new beanCl();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String flag = request.getParameter("flag");
        if (flag.equals("login")){
            String name = request.getParameter("username");
            request.getSession().setAttribute("userName", name);
            if (i.checkUser(name)){
                request.getRequestDispatcher("success.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
        }else if (flag.equals("showFilm")){
           request.getRequestDispatcher("filmlist.jsp").forward(request,response);
        }else if (flag.equals("delete")){
           String film_id=request.getParameter("film_id");
           if (i.deleteFilm(film_id)){
               request.getRequestDispatcher("success.jsp").forward(request,response);
           }else{
               request.getRequestDispatcher("error.jsp").forward(request,response);
           }
        }else if (flag.equals("update")){
            String filmId=request.getParameter("filmId");
            String filmTitle=request.getParameter("filmTitle");
            String filmdescription=request.getParameter("filmdescription");
            String filmLanguageId=request.getParameter("filmLanguageId");
            if (i.updateFilm(filmId,filmTitle,filmdescription,filmLanguageId)){
                    request.getRequestDispatcher("success.jsp").forward(request,response);
                }else{
                    request.getRequestDispatcher("error.jsp").forward(request,response);
            }
        }else if (flag.equals("add")){
            String filmId=request.getParameter("filmId");
            String filmTitle=request.getParameter("filmTitle");
            String filmdescription=request.getParameter("filmdescription");
            System.out.println(filmdescription);
            String filmLanguageId=request.getParameter("filmLanguageId");
            if (i.addFilm(filmId,filmTitle,filmdescription,filmLanguageId)){
                request.getRequestDispatcher("success.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
        }

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        this.doGet(request,response);
    }
}
