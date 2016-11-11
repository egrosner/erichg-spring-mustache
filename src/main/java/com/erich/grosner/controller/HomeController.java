package com.erich.grosner.controller;


import com.erich.grosner.model.BlogPost;
import com.erich.grosner.model.BlogPostRepository;
import com.erich.grosner.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    BlogPostRepository repo;

    @RequestMapping("/")
    public String home(Model m) {

        List<BlogPost> posts = repo.findAll(new PageRequest(0, 10)).getContent();

        m.addAttribute("blogPosts", posts);

        Map<String, Object> test = m.asMap();

        m.addAttribute("currentPage", "home");

        return "blog/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model m) {
        m.addAttribute("currentPage", "login");
        return "login/index";
    }

    /*@RequestMapping(value = "/loginuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String loginUser(UserLogin userLogin, Model m) {
        System.out.println("hellooo");
        return "index";
    }*/

    @RequestMapping("/create")
    public String create(Model m) {
        m.addAttribute("currentPage", "create");
        return "createpost/index";
    }

    @RequestMapping("/about")
    public String about(Model m) {
        m.addAttribute("currentPage", "about");
        return "about/index";
    }
}
