package ma.mourad.gestetud.web;

import lombok.AllArgsConstructor;
import ma.mourad.gestetud.entities.Etudiant;
import ma.mourad.gestetud.services.IServiceEtudiant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PC
 **/
@Controller
@AllArgsConstructor
public class EtudiantController {
    private IServiceEtudiant serviceEtudiant;

    @GetMapping( value = {"/","/index"})
    public String index(Model model){
        model.addAttribute("etudiants",serviceEtudiant.getAllEtudiants());
        model.addAttribute("etudiant",new Etudiant());
        return "index";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("etudiant") Etudiant e){
        serviceEtudiant.addEtudiant(e);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        serviceEtudiant.deleteEtudiant(id);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String update(Model model,@PathVariable("id")Long id){
        model.addAttribute("etudiant",serviceEtudiant.getEtudiant(id));
        return "update";
    }
    @PostMapping("/upd")
    public String upd(@ModelAttribute("etudiant")Etudiant e){
        serviceEtudiant.updateEtudiant(e.getId(),e);
        return "redirect:/";
    }


}
