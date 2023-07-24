package tech.kjworks.dccommentservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("dc-user-service")
public interface FeignUserController {

}
