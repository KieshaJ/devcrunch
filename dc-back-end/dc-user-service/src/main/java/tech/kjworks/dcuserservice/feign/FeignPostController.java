package tech.kjworks.dcuserservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "postClient")
public interface FeignPostController {
    
}
