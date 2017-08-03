package web;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping(value = "/user")
    public String userpage(){
        return "user";
    }
    @PostMapping(value = "/adduser")
    public String add(@ModelAttribute User user){
        System.out.println(user.getAge());
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
