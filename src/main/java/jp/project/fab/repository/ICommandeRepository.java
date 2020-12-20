package jp.project.fab.repository;

import jp.project.fab.model.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommandeRepository extends JpaRepository<Commandes,Long> {
}
