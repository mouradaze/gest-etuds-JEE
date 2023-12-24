package ma.mourad.gestetud.services;

import lombok.AllArgsConstructor;
import ma.mourad.gestetud.entities.Etudiant;
import ma.mourad.gestetud.repositories.EtudiantRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PC
 **/
@Service
@AllArgsConstructor
public class ServiceEtudiant implements IServiceEtudiant{
    private EtudiantRepo etudiantRepo;
    @Override
    public Etudiant getEtudiant(Long id) {
        return etudiantRepo.findById(id).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepo.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepo.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Long id, Etudiant e) {
        System.out.println(e);
        Etudiant x = etudiantRepo.findById(id).map(et->{
            et.setName(e.getName());
            et.setCin(e.getCin());
            et.setNivEtud(e.getNivEtud());
            return etudiantRepo.save(et);
        }).orElse(null);

        return etudiantRepo.save(x);
    }

    @Override
    public boolean deleteEtudiant(Long id) {
        Etudiant x = etudiantRepo.findById(id).orElse(null);
        if(x!=null){
            etudiantRepo.delete(x);
            return true;
        }
        return false;
    }
}
