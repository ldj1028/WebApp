package kr.co.cywell.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @GetMapping("/session")
    public String cywellSession(HttpSession session) {
        Integer index = (Integer)session.getAttribute("session_counter");

        if(index == null) {
            index = 1;
        }else {
            index = index.intValue() + 1;
        }
        session.setAttribute("session_counter", index);
        System.out.println("here!!!!!!");
        return "Session Counter : " + session.getAttribute("session_counter");
    }

}