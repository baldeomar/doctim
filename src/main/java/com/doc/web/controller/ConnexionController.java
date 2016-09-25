package com.doc.web.controller;

import com.doc.web.application.ApplicationUrl;
import com.doc.web.application.PageMapper;
import com.doc.web.model.Utilisateur;
import com.doc.web.service.UtilisateurService;
import com.doc.web.validators.UtilisateurValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConnexionController {

    @Autowired
    UtilisateurValidator utilisateurValidator;

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final String MODEL_ATTRIBUTE_UTILISATEUR_FORM = "userForm";
    private static final String MODEL_ATTRIBUTE_REGISTER_URL = "registerSubmitUrl";
    private static final String MODEL_ATTRIBUTE_CANCEL_URL = "cancelUrl";

    @RequestMapping(value = ApplicationUrl.REGISTER_PRE)
    public String registerPre(Model model){
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute(MODEL_ATTRIBUTE_UTILISATEUR_FORM, utilisateur);
        model.addAttribute(MODEL_ATTRIBUTE_REGISTER_URL, ApplicationUrl.REGISTER_POST);
        model.addAttribute(MODEL_ATTRIBUTE_CANCEL_URL, ApplicationUrl.HOME);
        return PageMapper.REGISTER;
    }

    @RequestMapping(value = ApplicationUrl.REGISTER_POST, method = RequestMethod.POST)
    public String registerPost(@ModelAttribute (name = "userForm") Utilisateur utilisateur, Model model, BindingResult result){
        utilisateurValidator.validate(utilisateur, result);
        if(result.hasErrors()){
            model.addAttribute(MODEL_ATTRIBUTE_UTILISATEUR_FORM, utilisateur);
            model.addAttribute(MODEL_ATTRIBUTE_REGISTER_URL, ApplicationUrl.REGISTER_POST);
            model.addAttribute(MODEL_ATTRIBUTE_CANCEL_URL, ApplicationUrl.HOME);
            return PageMapper.REGISTER;
        }
        utilisateur.setPassword(bCryptPasswordEncoder.encode(utilisateur.getPassword()));
        utilisateurService.save(utilisateur);
        return PageMapper.HOME;
    }

    @RequestMapping(value = ApplicationUrl.LOGIN_PRE, method = RequestMethod.GET)
    public String getLoginForm(){
        return PageMapper.LOGIN;
    }
}
