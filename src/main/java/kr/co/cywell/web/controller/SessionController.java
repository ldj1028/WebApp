package kr.co.cywell.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @GetMapping("/session")
    public String cywellSession(HttpSession session) {
        Integer index = (Integer)session.getAttribute("session_counter");
        String msg = "";
        if(index == null) {
            index = 1;
        }else {
            index = index.intValue() + 1;
        }
        session.setAttribute("session_counter", index);
        msg += "Session Counter : " + session.getAttribute("session_counter") + "</br>";
        msg += "Session ID : " + session.getId() + "</br>";
        msg += "Session Creation Time : " + session.getCreationTime() + "</br>";
        return "Session Counter : " + session.getAttribute("session_counter");
    }

}