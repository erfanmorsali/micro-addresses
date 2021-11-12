package com.example.microaddresses.modules.consumers;

public class UserDeletedEvent {
    String message;
    Long userId;

    public UserDeletedEvent() {
    }

    public UserDeletedEvent(String message, Long id) {
        this.message = message;
        this.userId = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
