package az.ingress.students.errors;

import az.ingress.students.exception.ErrorResponse;
import org.springframework.http.HttpStatus;

public enum Errors implements ErrorResponse {
    STUDENT_NOT_FOUND( "STUDENT_NOT_FOUND",HttpStatus.NOT_FOUND , "Student with id {id} not found");

    String key;
    HttpStatus httpStatus;
    String message;

    Errors(String key, HttpStatus httpStatus, String message) {
        this.message = message;
        this.key = key;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
