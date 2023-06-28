package tech.kjworks.dcgatewayservice.config;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "dc-gateway-service", version = "0.0.1", description = "DevCrunch Gateway service routes"))
public class OpenAPIConfig {
    @Bean
    List<GroupedOpenApi> apis(RouteDefinitionLocator locator) {
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = locator
            .getRouteDefinitions()
            .collectList()
            .block();

        assert definitions != null;

        definitions.stream().filter(definition -> definition
            .getId()
            .matches(".*-service"))
            .forEach(definition -> {
                String name = definition.getId().replace("-service", "");
                groups.add(GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build());
            });
        
        return groups;
    }
}
