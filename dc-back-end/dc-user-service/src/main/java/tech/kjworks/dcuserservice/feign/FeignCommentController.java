package tech.kjworks.dcuserservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("dc-comment-service")
public interface FeignCommentController {
    
}
