package sas.study.blog.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Getter
@Validated
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "spring.datasource")
public class PostgresProperties {

    @NotEmpty
    private final String url;

    @NotEmpty
    private final String driverClassName;

    @NotEmpty
    private final String username;

    @NotEmpty
    private final String password;

}
