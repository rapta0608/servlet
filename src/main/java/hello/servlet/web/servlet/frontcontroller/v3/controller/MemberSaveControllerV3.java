package hello.servlet.web.servlet.frontcontroller.v3.controller;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.servlet.frontcontroller.v3.ControllerV3;
import hello.servlet.web.servlet.frontcontroller.ModelView;

import java.util.HashMap;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository=MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> params) {

        String username = params.get("username");
        int age = Integer.parseInt(params.get("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member",member);

        return modelView;
    }
}
