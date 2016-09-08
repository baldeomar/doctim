package com.doc.web.validators;

import com.doc.web.model.Utilisateur;
import com.doc.web.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UtilisateurValidator implements Validator{

    @Autowired
    UtilisateurService utilisateurService;

    @Override
    public void validate(Object o, Errors errors) {
        Utilisateur utilisateur = (Utilisateur) o;
        if(StringUtils.isEmpty(utilisateur.getUsername())){
            errors.rejectValue("username", "main.empty");
        }else{
            String emailPattern = "^[_A-Za-z0-9-+]+"
                    + "(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)"
                    + "*(.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(utilisateur.getUsername());
            if (!matcher.matches()) {
                errors.rejectValue("username", "inscription.invalid.username");
            }else{
                Utilisateur existingUser = utilisateurService.findOne(utilisateur.getUsername());
                if(existingUser != null){
                    errors.rejectValue("username", "inscription.existed.username");
                }
            }
        }
        if(StringUtils.isEmpty((utilisateur.getPassword()))){
            errors.rejectValue("password", "main.empty");
        }
        if(StringUtils.isEmpty(utilisateur.getMatchingPassword())){
            errors.rejectValue("matchingPassword", "main.empty");
        }

        if(!StringUtils.isEmpty(utilisateur.getPassword())
                && !StringUtils.isEmpty(utilisateur.getMatchingPassword())
                && !utilisateur.getPassword().equals(utilisateur.getMatchingPassword())){
            errors.rejectValue("matchingPassword", "inscription.password.not.match");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
