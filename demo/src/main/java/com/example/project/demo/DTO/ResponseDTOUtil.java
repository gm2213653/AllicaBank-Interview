package com.example.project.demo.DTO;

public class ResponseDTOUtil {
    
    public static ResponseDTO buildSuccessResponse(Object data) {
        return ResponseDTO.builder()
                .message("Success")
                .data(data).build();
    }
    
    public static ResponseDTO buildFailureResponse() {
        return ResponseDTO.builder()
                .message("Failure")
                .data(null).build();
    }
}