package com.doc.web.security;

import com.doc.web.model.Utilisateur;
import com.doc.web.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String)authentication.getCredentials();
        Utilisateur utilisateur = utilisateurService.findOne(username);

        if(utilisateur == null || !bCryptPasswordEncoder.matches(password, utilisateur.getPassword())){
            throw new BadCredentialsException("Username or password incorrect");
        }
        return new UsernamePasswordAuthenticationToken(utilisateur, password);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
