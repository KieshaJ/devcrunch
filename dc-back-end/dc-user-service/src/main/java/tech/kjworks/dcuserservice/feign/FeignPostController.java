package tech.kjworks.dcuserservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("dc-post-service")
public interface FeignPostController {
    
}
