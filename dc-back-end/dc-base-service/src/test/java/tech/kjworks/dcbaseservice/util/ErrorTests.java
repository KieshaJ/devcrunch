package tech.kjworks.dcbaseservice.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.kjworks.dcbaseservice.util.exception.Error;

class ErrorTests {
    private String message;
    private Integer status;
    private Long timestamp;
    private Error e;

    @BeforeEach
    void init() {
        message = "test";
        status = 200;
        timestamp = 0L;
        e = new Error(message, status, timestamp);
    }

    @Test
    void errorConstructor() {
        assertEquals(message, e.getMessage());
    }

    @Test
    void errorGetters() {
        assertEquals(message, e.getMessage());
        assertEquals(status, e.getStatus());
        assertEquals(timestamp, e.getTimestamp());
    }

    @Test
    void errorSetters() {
        String newMessage = "test1";
        Integer newStatus = 404;
        Long newTimestamp = 1L;

        e.setMessage(newMessage);
        e.setStatus(newStatus);
        e.setTimestamp(newTimestamp);

        assertEquals(newMessage, e.getMessage());
        assertEquals(newStatus, e.getStatus());
        assertEquals(newTimestamp, e.getTimestamp());
    }
}
