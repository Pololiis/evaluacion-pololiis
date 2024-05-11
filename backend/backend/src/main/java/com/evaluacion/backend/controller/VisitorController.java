package com.evaluacion.backend.controller;

import com.evaluacion.backend.entity.Visitor;
import com.evaluacion.backend.service.VisitorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class VisitorController {
    private final VisitorService visitorService;

    @PostMapping("/home")
    public Visitor saveVisitor(Visitor visitor) {
        return visitorService.saveVisitor(visitor);
    }

    @GetMapping("/record")
    public List<Visitor> listVisitors() {
        return visitorService.listVisitors();
    }
}
