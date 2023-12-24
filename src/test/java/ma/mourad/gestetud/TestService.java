package ma.mourad.gestetud;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.mourad.gestetud.entities.Etudiant;
import ma.mourad.gestetud.enums.Level;
import ma.mourad.gestetud.repositories.EtudiantRepo;
import ma.mourad.gestetud.services.IServiceEtudiant;
import ma.mourad.gestetud.services.ServiceEtudiant;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author PC
 **/
public class TestService {


    static AnnotationConfigApplicationContext context = null;
    @BeforeAll
    static void init() {
        context = new AnnotationConfigApplicationContext(GestEtudApplication.class);

    }
    @AfterAll
    static void close() {
        context.close();
    }
    private IServiceEtudiant serviceEtudiant = context.getBean(ServiceEtudiant.class);
    @Test
    void testCreate() {

        Assertions.assertAll("err",()->Assertions.assertEquals(Etudiant.builder().id(1L).name("z").cin("z").nivEtud(Level.UNIVERSITÉ).build(),
                serviceEtudiant.addEtudiant(Etudiant.builder().name("z").cin("z").nivEtud(Level.UNIVERSITÉ).build()),"Ess"));

    }
    @Test
    void testRead(){
        serviceEtudiant.addEtudiant(Etudiant.builder().name("test").cin("test").nivEtud(Level.LYCÉE).build());
        Assertions.assertAll("Read id",
                ()->Assertions.assertEquals(1L,serviceEtudiant.getEtudiant(1L).getId(),"Id not good"));
        Assertions.assertAll("Read name",
                ()->Assertions.assertEquals("test",serviceEtudiant.getEtudiant(1L).getName(),"Name not good"));
        Assertions.assertAll("Read cin",
                ()->Assertions.assertEquals("test",serviceEtudiant.getEtudiant(1L).getCin(),"Cin not good"));
        Assertions.assertAll("Read nivEtud",
                ()->Assertions.assertEquals(Level.LYCÉE,serviceEtudiant.getEtudiant(1L).getNivEtud(),"nivEtud not good"));
    }
}
