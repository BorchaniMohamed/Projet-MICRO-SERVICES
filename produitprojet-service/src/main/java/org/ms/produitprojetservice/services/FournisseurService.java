package org.ms.produitprojetservice.services;

import org.ms.produitprojetservice.entities.Fournisseur;

import java.io.IOException;
import java.util.List;

public interface FournisseurService {
    void deleteById(Long id) throws IOException;
    Fournisseur save(Fournisseur fournisseur);
    Fournisseur findById(long id);
    List<Fournisseur> findAll();
    List<Fournisseur> findNewFournisseus();
}
