package ma.mourad.gestetud.services;

import ma.mourad.gestetud.entities.Etudiant;

import java.util.List;

/**
 * @author PC
 **/
public interface IServiceEtudiant {
    Etudiant getEtudiant(Long id);
    List<Etudiant> getAllEtudiants();
    Etudiant addEtudiant(Etudiant e);
    Etudiant updateEtudiant(Long id,Etudiant e);
    boolean deleteEtudiant(Long id);
}
