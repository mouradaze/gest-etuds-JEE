package ma.mourad.gestetud.repositories;

import ma.mourad.gestetud.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author PC
 **/
@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
}
