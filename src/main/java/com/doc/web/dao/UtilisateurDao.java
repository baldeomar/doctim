package com.doc.web.dao;

import com.doc.web.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>{

    Utilisateur findByUsername(String username);
}
