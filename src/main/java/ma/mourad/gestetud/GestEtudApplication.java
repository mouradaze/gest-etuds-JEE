package ma.mourad.gestetud;

import ma.mourad.gestetud.entities.Etudiant;
import ma.mourad.gestetud.enums.Level;
import ma.mourad.gestetud.repositories.EtudiantRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestEtudApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestEtudApplication.class, args);
    }

    @Bean
    CommandLineRunner run(EtudiantRepo etudiantRepo){
        return args -> {
            etudiantRepo.save(Etudiant.builder().name("Mourad").cin("AA457884").nivEtud(Level.UNIVERSITÉ).build());
            etudiantRepo.save(Etudiant.builder().name("Amine").cin("AB698512").nivEtud(Level.COLLÉGE).build());
            etudiantRepo.save(Etudiant.builder().name("Youssef").cin("AE33654").nivEtud(Level.LYCÉE).build());
        };
    }

}
