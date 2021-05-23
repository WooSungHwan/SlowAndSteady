package sas.study.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sas.study.blog.configuration.PostgresProperties;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    PostgresProperties postgresProperties;

    @Test
    void contextLoads() {
        assertThat(postgresProperties).extracting("url").isEqualTo("jdbc:postgresql://localhost:5432/blog");
        assertThat(postgresProperties).extracting("driverClassName").isEqualTo("org.postgresql.Driver");
        assertThat(postgresProperties).extracting("username").isEqualTo("studyfarmuser");
        assertThat(postgresProperties).extracting("password").isEqualTo("studyfarm1!@#");
    }

}
