package com.evaluacion.backend.dto;

import lombok.Data;

@Data
public class VisitorHomeDTO {
    private Long id;
    private String ip;
    private String date;
    private String hour;
}
