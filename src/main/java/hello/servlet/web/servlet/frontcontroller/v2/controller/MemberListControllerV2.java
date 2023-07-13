package hello.servlet.web.servlet.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.servlet.frontcontroller.MyView;
import hello.servlet.web.servlet.frontcontroller.v1.ControllerV1;
import hello.servlet.web.servlet.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {
    private MemberRepository memberRepository=MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> all = memberRepository.findAll();

        request.setAttribute("members",all);
        return new MyView("/WEB-INF/views/members.jsp");

    }
}
