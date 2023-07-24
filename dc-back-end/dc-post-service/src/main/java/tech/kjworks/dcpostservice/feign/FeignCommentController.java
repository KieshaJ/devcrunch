package tech.kjworks.dcpostservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "commentClient")
public interface FeignCommentController {
    
}
