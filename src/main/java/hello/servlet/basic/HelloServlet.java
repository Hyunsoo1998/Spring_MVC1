package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;


@WebServlet(name = "HelloServlet", urlPatterns =  "/hello")
public class HelloServlet extends HttpServlet {


    //?username = kim 이부분이 쿼리 파라미터

    //서블릿이 호출 되면 서비스 메서드가 호출된다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.service(req, resp);

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //request.getParameter로 쉽게 조회할수있음.

        String username = request.getParameter("username");
        System.out.println("username = " + username);



        //setContentType과 setCharacterEncoding은 Header정보에 들어간다.
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");


        response.getWriter().write("hello"+ username);

    }
}