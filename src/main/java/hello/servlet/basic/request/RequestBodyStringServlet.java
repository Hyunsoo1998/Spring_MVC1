package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //아래와 같이 받으면 메시지 body의 내용을 bytecode로 바로 얻을 수 있다.
        ServletInputStream inputStream = request.getInputStream();

        //스프링의 StreamUtils를 사용하면 여러가지 변환 과정을 스프링이 제공하는 유틸리티 클래스를 사용 할 수 있음.
        //꺼낼때 인코딩 정보를 알려줘야한다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("okok");

    }
}
