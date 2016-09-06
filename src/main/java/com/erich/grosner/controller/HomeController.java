package com.erich.grosner.controller;


import com.erich.grosner.model.BlogPost;
import com.erich.grosner.model.UserLogin;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model m) {

        BlogPost bp = new BlogPost();
        bp.setBody("this is my new blog!");
        bp.setTitle("New Blog!");
        bp.setDate("August");
        bp.setTags("General");

        BlogPost newBP = new BlogPost();
        newBP.setBody("Another post already??");
        newBP.setTitle("omg!");
        newBP.setDate("August 31st");
        newBP.setTags("cool");

        List<BlogPost> posts = new ArrayList<>();

        posts.add(newBP);
        posts.add(bp);

        m.addAttribute("blogPosts", posts);
        //m.addAllAttributes(posts);

        Map<String, Object> test = m.asMap();

        m.addAttribute("isBlog", true);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model m) {
        m.addAttribute("isLogin", true);

        return "index";
    }

    /*@RequestMapping(value = "/loginuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String loginUser(UserLogin userLogin, Model m) {
        System.out.println("hellooo");
        return "index";
    }*/

    @RequestMapping("/create")
    public String create(Model m) {
        m.addAttribute("isCreatePost", true);
        return "index";
    }
}
