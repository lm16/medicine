package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import service.impl.UserServiceImpl;

@Controller
public class UserController {

    private UserService userService = new UserServiceImpl();

    @RequestMapping(value="/validate.do", method=RequestMethod.POST)
    public @ResponseBody String validate(@RequestBody User user){

        String result = userService.validate(user);

        return result;
    }
}
