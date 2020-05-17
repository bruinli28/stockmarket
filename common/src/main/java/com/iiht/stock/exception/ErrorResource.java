package com.iiht.stock.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResource {
    private String code;
    private String message;
    private List<FieldErrorResource> fieldErrors;

    public ErrorResource(String invalidRequest, String message, List<FieldErrorResource> fieldErrorResources) {

        this.code = invalidRequest;
        this.message = message;
        this.fieldErrors = fieldErrorResources;
    }

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public List<FieldErrorResource> getFieldErrors() {
		return fieldErrors;
	}
}
