package com.example.redisdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author: Staro
 * @date: 2020/5/19 17:42
 * @Description:
 */
@RestController
public class HttpSessionController {
    @RequestMapping("/uid")
    public String uid(HttpSession session){
        UUID uid = (UUID)session.getAttribute("uid");
        if (uid==null){
            uid=UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }
}
