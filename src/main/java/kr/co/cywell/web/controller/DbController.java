package kr.co.cywell.web.controller;


import kr.co.cywell.web.config.DBConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbController {

    @GetMapping("/ds")
    public String connDS() {
        DBConfig dbc = new DBConfig();
        String msg = "";
        try {
            msg = dbc.connectionDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}