package tech.kjworks.dcpostservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("dc-comment-service")
public interface FeignCommentController {
    
}
