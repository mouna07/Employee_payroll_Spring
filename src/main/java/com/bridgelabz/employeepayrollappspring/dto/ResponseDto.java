package com.bridgelabz.employeepayrollappspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    private String message;
    private String statusCode;
    private Object data;


}
