package fr.lernejo.navy_battle;
import org.junit.jupiter.api.Test;



public class CallHandlerTest {
    private final serverHttp server = new serverHttp(8088);
        private final CallHandler callHandler = new CallHandler();


   @Test
   void body_Ok() {
       org.assertj.core.api.Assertions.assertThat(callHandler.getBody()).isEqualTo("OK");
   }

   @Test
   void body_KO() {
       org.assertj.core.api.Assertions.assertThat(callHandler.getBody()).isNotEqualTo("KO");
   }

   @Test
    void code_test_200() {
       org.assertj.core.api.Assertions.assertThat(callHandler.getCode_test()).isEqualTo(200);
   }

   @Test
    void code_test_404() {
       org.assertj.core.api.Assertions.assertThat(callHandler.getCode_test()).isNotEqualTo(404);
   }

   
}