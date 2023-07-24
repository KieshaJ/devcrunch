package tech.kjworks.dccommentservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "userClient")
public interface FeignUserController {

}
