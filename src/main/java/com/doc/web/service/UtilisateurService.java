package com.doc.web.service;

import com.doc.web.model.Utilisateur;

public interface UtilisateurService {
    Utilisateur findOne(Long id);

    Utilisateur findOne(String username);

    Utilisateur save(Utilisateur utilisateur);
}
