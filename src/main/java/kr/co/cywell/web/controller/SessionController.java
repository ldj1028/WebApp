package kr.co.cywell.web.controller;

import javax.servlet.http.HttpSession;

import kr.co.cywell.web.util.CommonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class SessionController {
    @GetMapping("/session")
    public String cywellSession(HttpSession session) throws UnknownHostException {
        CommonUtil cu = new CommonUtil();
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
        msg += "Session Creation Time : " + cu.changeTimeFormat(session.getCreationTime()) + "</br>";
        msg += "Session Last Accessed Time : " + cu.changeTimeFormat(session.getLastAccessedTime()) + "</br>";
        msg += "Host Name : " + InetAddress.getLocalHost().getHostName() + "</br>";
        return msg;
    }

}