package org.ms.clientprojetservice.services;

import org.ms.clientprojetservice.entities.Adresse;

import java.io.IOException;
import java.util.List;

public interface AdresseService {
    void deleteById(Long id) throws IOException;
    Adresse save(Adresse adresse);
    Adresse findById(long id);
    List<Adresse> findAll();
    List<Adresse> findNewAdresse();
}
