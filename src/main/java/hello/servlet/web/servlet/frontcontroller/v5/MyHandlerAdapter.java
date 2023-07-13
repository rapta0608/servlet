package hello.servlet.web.servlet.frontcontroller.v5;

import com.sun.org.apache.xpath.internal.operations.Mod;
import hello.servlet.web.servlet.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
    boolean supports(Object handle);

    ModelView handler(HttpServletRequest request, HttpServletResponse response,Object handler) throws ServletException, IOException;
}
