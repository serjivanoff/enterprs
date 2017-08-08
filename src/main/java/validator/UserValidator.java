package validator;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import service.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"login","This field is REQUIRED");
        if(user.getLogin().length()<8 || user.getLogin().length()>32)errors.rejectValue("login","Login has to be not less than 8 and not more than 32 symbols");
        if(userService.getByLogin(user.getLogin())!=null)errors.rejectValue("login","User with such login already exists");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","This field is REQUIRED");
        if(user.getPassword().length()<8 || user.getPassword().length()>32)errors.rejectValue("password","Password has to be not less than 8 and not more than 32 symbols");
        if(!user.getConfirmPassword().equals(user.getPassword()))errors.rejectValue("confirmPassword","Passwords are not equals");
    }
}
