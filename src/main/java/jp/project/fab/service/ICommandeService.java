package jp.project.fab.service;

import jp.project.fab.model.Commandes;

import java.util.List;

public interface ICommandeService {

    public void saveCommande(String commande, List<String> indices);
    public List<Commandes> getCommandes();
}
