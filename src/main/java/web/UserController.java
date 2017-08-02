package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public String add(Model model){

        return "users";
    }
       @GetMapping()
       public String getAll(Model model){
            model.addAttribute("users",userService.getAll());
            return "users";}

       @GetMapping(value = "/{id}")
       public String get(Model model,@PathVariable int id){
           model.addAttribute("user",userService.get(id));
           return"user";}

       @GetMapping(value = "/delete/{id}")
       public String delete(Model model, @PathVariable int id){
            userService.delete(id);
            return getAll(model);}
}
