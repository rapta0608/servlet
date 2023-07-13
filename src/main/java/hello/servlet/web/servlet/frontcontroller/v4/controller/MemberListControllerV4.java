package hello.servlet.web.servlet.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.servlet.frontcontroller.ModelView;
import hello.servlet.web.servlet.frontcontroller.v3.ControllerV3;
import hello.servlet.web.servlet.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository=MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> params,Map<String,Object> model) {

        List<Member> all = memberRepository.findAll();
        model.put("members",all);

        return "members";

    }
}
