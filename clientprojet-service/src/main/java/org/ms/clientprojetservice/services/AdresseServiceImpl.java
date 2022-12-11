package org.ms.clientprojetservice.services;

import lombok.AllArgsConstructor;
import org.ms.clientprojetservice.entities.Adresse;
import org.ms.clientprojetservice.repository.AdresseRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@AllArgsConstructor
public class AdresseServiceImpl implements AdresseService{
    private AdresseRepository adresseRepository;
    @Override
    public void deleteById(Long id) throws IOException {
        adresseRepository.deleteById(id);
    }

    @Override
    public Adresse save(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public Adresse findById(long id) {
        return adresseRepository.findById(id).get();
    }

    @Override
    public List<Adresse> findAll() {
        return adresseRepository.findAll();
    }
}
