package pl.pb.web.spring.jsf.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeRedirection {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        System.out.println("home");
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }







}
