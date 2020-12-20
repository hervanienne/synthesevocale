package jp.project.fab.service;

import jp.project.fab.model.Commandes;
import jp.project.fab.repository.ICommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeService implements ICommandeService{

    @Autowired
    private ICommandeRepository cdeRepository;

    @Override
    public void saveCommande(String commande, List<String> indices) {
        Commandes comm = new Commandes();
        comm.setOrdre(commande);
        cdeRepository.save(comm);
    }

    @Override
    public List<Commandes> getCommandes() {
        return cdeRepository.findAll();
    }
}
