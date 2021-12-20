package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Test;


public class FireHandlerTest {
    private final FireHandler fireHandler = new FireHandler();

    @Test
    void verbe_test_Not_Found() {
        org.assertj.core.api.Assertions.assertThat(fireHandler.getVerbe()).isEqualTo(" Not Found ");
    }

    @Test
    void verbe_KO() {
        org.assertj.core.api.Assertions.assertThat(fireHandler.getVerbe()).isNotEqualTo("KO");
    }

    @Test
    void resp_202() {
        org.assertj.core.api.Assertions.assertThat(fireHandler.getResp()).isEqualTo(202);
    }

    @Test
    void resp_404() {
        org.assertj.core.api.Assertions.assertThat(fireHandler.getResp()).isNotEqualTo(404);
    }

    
}