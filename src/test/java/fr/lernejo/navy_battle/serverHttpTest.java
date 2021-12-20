package fr.lernejo.navy_battle;
import org.junit.jupiter.api.*;

public class serverHttpTest {

//pour tester le bon fonctionnement, démarrer un premier programme sur un port (par ex : 9876), puis démarrer le même programme une deuxième fois avec un port différent et l’url du premier (par ex : 8795 http://localhost:9876); ainsi le second programme devrait contacter le premier.
    private final serverHttp server = new serverHttp(9876);

    @Test
    void testing_negative_port_number() {
        int port_neg = -1;
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> server.Create(port_neg));
    }
}
    