package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;


@WebServlet(name = "requestHeaderServlet", urlPatterns =  "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        printStartLine(request);
        printHeaders(request);

    }

    private static void printStartLine(HttpServletRequest request) {
        System.out.println("---Request Line - start");

        System.out.println("request.getMethod() : " + request.getMethod()); //GET
        System.out.println("request.getProtocol() : " + request.getProtocol());//HTTP/1.1

        System.out.println("request.getScheme() = " + request.getScheme() );//http
        System.out.println("request.getURL () = " + request.getRequestURL());
        //request-test
        System.out.println("request.getURI() = " + request.getRequestURI());
        //username = hi
        System.out.println("request.getQueryString() : " + request.getQueryString());
        System.out.println("request.isSecure(): " + request.isSecure()); // https 사용 유무

        System.out.println("---Request-Line END -------");
        System.out.println();
    }

    //Header 모든 정보

    private void printHeaders(HttpServletRequest request) {

        System.out.println("Headers - start -- ");

        //Header 모든 정보 뽑는 방법 1(옛날 방법)

        //request.getHeaderNames()라고 하면 HTTP 모든 요청의 헤더를 뽑을 수 있다.
//        Enumeration<String>headerNames = request.getHeaderNames();
//
//        while(headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName+" = " + headerName);
//        }

        //Header 모든 정보 뽑는 방법 2 (요즘 스타일)


        request.getHeaderNames().asIterator().forEachRemaining(headerName-> System.out.println(headerName+" :"+headerName));

        System.out.println("Headers - end ---");
        System.out.println();

    }

    public void HeaderUtils(HttpServletRequest httpServletRequest) {

    }


}

