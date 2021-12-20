package fr.lernejo.navy_battle;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PostRequestTest {
    private final PostRequest client = new PostRequest(8098);
    private final serverHttp server = new serverHttp(8097);

    @Test
    void PostRequst() throws IOException {
        server.Create(9816);
        org.assertj.core.api.Assertions.assertThatNoException().isThrownBy(() -> client.send("http://localhost:8097"));
    }

    @Test
    void PostRequest_fire() {
        org.assertj.core.api.Assertions.assertThatNoException().isThrownBy(() -> client.sendFireRequest("http://localhost:8097", "A10"));
    }

    @Test
    void port_should_be_8098() {
        org.assertj.core.api.Assertions.assertThat(client.getMyPort()).isEqualTo(8098);
    }

    
}
