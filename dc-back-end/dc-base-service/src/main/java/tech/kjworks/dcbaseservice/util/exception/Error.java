package tech.kjworks.dcbaseservice.util.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
    private String message;
    private Integer status;
    private Long timestamp;

    public Error() {}

    public Error(String message,
        Integer status,
        Long timestamp) {
            this.message = message;
            this.status = status;
            this.timestamp = timestamp;
        }
}
