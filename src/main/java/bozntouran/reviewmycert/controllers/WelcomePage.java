package bozntouran.reviewmycert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class WelcomePage {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "index";
    }

}
