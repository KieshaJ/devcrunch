package tech.kjworks.dcpostservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@EnableMongoRepositories("tech.kjworks.dcpostservice.repository")
public class MongoConfig {
    @Bean
    ValidatingMongoEventListener validatingMongoEventListener(
        final LocalValidatorFactoryBean factory
    ) {
        return new ValidatingMongoEventListener(factory);
    }
}
