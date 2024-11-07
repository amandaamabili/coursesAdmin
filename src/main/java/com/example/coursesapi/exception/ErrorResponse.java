package com.example.coursesapi.exception;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    private HttpStatus status;
    private String error;

    public ErrorResponse(String message, HttpStatus status, String error) {
        this.message = message;
        this.status = status;
        this.error = error;
    }

}