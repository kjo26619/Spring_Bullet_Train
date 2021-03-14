package com.challenge.topcoder.bullettrain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {

    private String message;
    private List<String> errorList;

    public GenericResponse(String message, List<String> errorList) {
        this.message = message;
        this.errorList = errorList;
    }
}
