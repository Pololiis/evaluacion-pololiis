package com.evaluacion.backend.controller;

import com.evaluacion.backend.dto.VisitorHomeDTO;
import com.evaluacion.backend.dto.VisitorRecordDTO;
import com.evaluacion.backend.entity.Visitor;
import com.evaluacion.backend.service.VisitorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class VisitorController {
    private final VisitorService visitorService;

    @PostMapping("/home")
    public Visitor saveHomeVisitor(@RequestBody VisitorHomeDTO visitorHomeDTO) {
        return visitorService.saveHomeVisitor(visitorHomeDTO);
    }
    @PostMapping("/record")
    public Visitor saveRecordVisitor(@RequestBody VisitorRecordDTO visitorRecordDTO) {
        return visitorService.saveRecordVisitor(visitorRecordDTO);
    }
    @GetMapping("/home")
    public List<VisitorHomeDTO> listVisitorsHome() {
        return visitorService.listVisitorsHome();
    }
    @GetMapping("/record")
    public List<VisitorRecordDTO> listVisitorsRecord() {
        return visitorService.listVisitorsRecord();
    }
    @GetMapping("/{ip}")
    public VisitorRecordDTO findVisitorByIp(@RequestParam String ip) {
        Optional<VisitorRecordDTO> visitorToFind = visitorService.getVisitorByIp(ip);
        if (visitorToFind.isPresent()) {
            VisitorRecordDTO visitorRecordDTO = visitorToFind.get();
            return visitorRecordDTO;
        }
        return null;
    }
}
