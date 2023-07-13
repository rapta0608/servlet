package hello.servlet.web.servlet.frontcontroller.v3.controller;

import hello.servlet.web.servlet.frontcontroller.v3.ControllerV3;
import hello.servlet.web.servlet.frontcontroller.ModelView;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> params) {
          return new ModelView("new-form");
    }
}
