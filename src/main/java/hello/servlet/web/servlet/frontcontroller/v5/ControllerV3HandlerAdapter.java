package hello.servlet.web.servlet.frontcontroller.v5;

import hello.servlet.web.servlet.frontcontroller.ModelView;
import hello.servlet.web.servlet.frontcontroller.v3.ControllerV3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handle) {
        return (handle instanceof ControllerV3);
    }

    @Override
    public ModelView handler(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controller=(ControllerV3) handler;

        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);
        return mv;
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
