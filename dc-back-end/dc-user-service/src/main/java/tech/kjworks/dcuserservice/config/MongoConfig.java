package tech.kjworks.dcuserservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MongoConfig {
    @Bean
    ValidatingMongoEventListener validatingMongoEventListener() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        return new ValidatingMongoEventListener(factory);
    }
}
