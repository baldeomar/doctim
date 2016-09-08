package com.doc.web.service.impl;

import com.doc.web.dao.UtilisateurDao;
import com.doc.web.model.Utilisateur;
import com.doc.web.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    UtilisateurDao utilisateurDao;

    @Override
    public Utilisateur findOne(Long id) {
        return utilisateurDao.findOne(id);
    }

    @Override
    public Utilisateur findOne(String username) {
        return utilisateurDao.findByUsername(username);
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurDao.save(utilisateur);
    }
}
