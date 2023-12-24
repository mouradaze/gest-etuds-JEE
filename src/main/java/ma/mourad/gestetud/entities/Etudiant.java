package ma.mourad.gestetud.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.mourad.gestetud.enums.Level;

/**
 * @author PC
 **/
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cin;
    @Enumerated(EnumType.STRING)
    private Level nivEtud;
}
