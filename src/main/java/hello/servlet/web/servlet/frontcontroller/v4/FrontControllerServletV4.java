package hello.servlet.web.servlet.frontcontroller.v4;

import hello.servlet.web.servlet.frontcontroller.ModelView;
import hello.servlet.web.servlet.frontcontroller.MyView;

import hello.servlet.web.servlet.frontcontroller.v4.controller.MemberFormControllerV4;

import hello.servlet.web.servlet.frontcontroller.v4.controller.MemberListControllerV4;

import hello.servlet.web.servlet.frontcontroller.v4.controller.MemberSaveControllerV4;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FrontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {

        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String requestURI = request.getRequestURI();
        ControllerV4 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        Map<String, String> paramsMap = createParamMap(request);
        Map<String,Object> model=new HashMap<>();
        String viewName = controller.process(paramsMap, model);

        MyView view = viewResolver(viewName);

        //리턴해줄값 , request,response
        view.render(model, request, response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        Map<String, String> paramsMap = new HashMap<>();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            paramsMap.put(name, request.getParameter(name));
        }
        return paramsMap;
    }
}
