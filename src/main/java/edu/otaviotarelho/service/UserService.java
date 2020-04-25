package edu.otaviotarelho.service;

import com.google.gson.Gson;
import edu.otaviotarelho.exception.RequestNotValidException;
import edu.otaviotarelho.model.Contact;
import edu.otaviotarelho.model.UserModel;
import org.springframework.stereotype.Service;
import sun.misc.Request;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private Validator validator;

    public UserService() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public String save(UserModel user){
        Set<ConstraintViolation<Contact>> violations =  validator.validate(user.getContact());

        if(!violations.isEmpty()){
            Set<String> conditions =
                    violations.stream().map( x -> x.getPropertyPath() + " " + x.getMessage() ).collect(Collectors.toSet());
            throw new RequestNotValidException(conditions.toString());
        }

        return new Gson().toJson(user);
    }

}
