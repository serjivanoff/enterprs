package web;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/view/{id}")
    public String view(Model model, @PathVariable int id){
        model.addAttribute("contacts",userService.getWithContacts(id).getContacts());
        return "contacts";
    }

    @GetMapping(value = "/user")
    public ModelAndView userpage(){
        return new ModelAndView("user","userForm", new User());
    }

    @PostMapping(value = "/adduser")
    public String add(@ModelAttribute("userForm") User user, BindingResult result) {
        if (!result.hasErrors()) {
            if(user.getRegistered()==null)userService.create(new User(0,user.getFirstName(),user.getMiddleName(),user.getLastName(),user.getAge(),user.getExperience()));
            else userService.update(user);
            }
        return "redirect:/users/";
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

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
         User toUpdate=userService.get(id);
        return new ModelAndView("user","userForm",toUpdate);}

}