package com.fmr.java8.case_study.model;

import java.util.Objects;

public class AppResponse<T> {

    String message;

    T response;

    String errors;

    public AppResponse(final T response) {
        this.message = "Operation Successful";
        this.response = response;
    }

    public AppResponse(final String message, final String errors) {
        this.message = message;
        this.errors = errors;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setResponse(final T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public void setErrors(final String errors) {
        this.errors = errors;
    }

    public String getErrors() {
        return errors;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof AppResponse)) return false;
        final AppResponse that = (AppResponse) o;
        return message.equals(that.message) &&
                   Objects.equals(response, that.response) &&
                   Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, response, errors);
    }

    @Override
    public String toString() {
        return "AppResponse{" +
                   "message='" + message + '\'' +
                   ", response='" + response + '\'' +
                   ", errors='" + errors + '\'' +
                   '}';
    }
}
