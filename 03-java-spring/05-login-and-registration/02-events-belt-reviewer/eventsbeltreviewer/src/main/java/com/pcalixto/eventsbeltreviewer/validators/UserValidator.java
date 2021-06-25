package com.pcalixto.eventsbeltreviewer.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pcalixto.eventsbeltreviewer.models.User;
import com.pcalixto.eventsbeltreviewer.repositories.UserRepository;

@Component()
public class UserValidator implements Validator {
	private final UserRepository userRepository;
		 
	public UserValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match", "Passwords do not match");
        }
        
        if (this.userRepository.findByEmail(user.getEmail()) != null) {
        	errors.rejectValue("email", "Unique", "Email already exists");
        }
    }
}
