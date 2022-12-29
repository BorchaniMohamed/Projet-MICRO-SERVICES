package org.ms.produitprojetservice.services;

import lombok.AllArgsConstructor;
import org.ms.produitprojetservice.entities.Fournisseur;
import org.ms.produitprojetservice.repository.FournisseurRepository;
import org.ms.produitprojetservice.repository.StockItemRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class FournisseurServiceImpl implements FournisseurService{
    private FournisseurRepository fournisseurRepository;
    private StockItemRepository stockItemRepository;
    @Override
    public void deleteById(Long id) throws IOException {
        fournisseurRepository.deleteById(id);
    }

    @Override
    public Fournisseur save(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur findById(long id) {
        return fournisseurRepository.getById(id);
    }

    @Override
    public List<Fournisseur> findAll() {
        return fournisseurRepository.findAll();
    }

    @Override
    public List<Fournisseur> findNewFournisseus() {
        Date date = new Date();
        return fournisseurRepository.findFournisseurByAccountOpenedDate(date);
    }
}
