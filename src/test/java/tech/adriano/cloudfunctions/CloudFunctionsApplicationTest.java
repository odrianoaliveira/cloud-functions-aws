package tech.adriano.cloudfunctions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@FunctionalSpringBootTest
@AutoConfigureWebTestClient
public class CloudFunctionsApplicationTest {

    @Autowired
    private WebTestClient client;

    @Test
    public void test() {
        client.post().uri("/").body(Mono.just(5), Integer.class).exchange()
                .expectStatus().isOk().expectBody(Integer.class).isEqualTo(120);
    }

}