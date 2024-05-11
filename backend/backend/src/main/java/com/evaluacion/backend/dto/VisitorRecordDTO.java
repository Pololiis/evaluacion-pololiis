package com.evaluacion.backend.dto;

import com.evaluacion.backend.entity.Category;
import lombok.Data;

@Data
public class VisitorRecordDTO {
    private Long id;
    private String ip;
    private Integer totalVisits;
    private Boolean isBlocked = false;
    private Category category;
    private String comment;
}
