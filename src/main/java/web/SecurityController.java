package web;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.SecurityService;
import service.UserService;
import validator.UserValidator;

@Controller
public class SecurityController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator validator;

    @GetMapping(value="/registration")
    public String registration(Model model){
        model.addAttribute("userForm",new User());
        return "registration";
    }
    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute User userForm, Model model, BindingResult result){
        if(result.hasErrors()) return "registration";
        userService.create(userForm);
        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());
        return "redirect:/welcome";
    }
    @GetMapping(value="/login")
    public String login(Model model, String error, String logout){
        if(error!=null)model.addAttribute("error","Username or password incorrect");
        if(logout!=null)model.addAttribute("message","Logged out succesfully");
        return "login";
    }
    @GetMapping(value ={"/", "/welcome"})
    public String welcome(Model model){
        return "welcome";
    }
    @GetMapping(value = "admin")
    public String admin(Model model){
        return "admin";
    }
}