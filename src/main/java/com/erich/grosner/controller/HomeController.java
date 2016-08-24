package com.erich.grosner.controller;


import com.erich.grosner.model.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(path = "/")
    public String home(Model m) {

        BlogPost bp = new BlogPost();
        bp.setBody("this is my new blog!");
        bp.setTitle("New Blog!");
        bp.setDate("August");
        bp.setTags("General");
        m.addAttribute("post", bp);

        return "index";
    }
}
