package hello.servlet.web.servlet.frontcontroller.v5;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FrontControllerV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerV5 extends HttpServlet {
    private final Map<String,Object> handlerMappingMap=new HashMap<>();
}
