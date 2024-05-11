package com.evaluacion.backend.service;

import com.evaluacion.backend.dto.VisitorHomeDTO;
import com.evaluacion.backend.dto.VisitorRecordDTO;
import com.evaluacion.backend.entity.Visitor;
import com.evaluacion.backend.repository.VisitorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VisitorService {
    private final VisitorRepository visitorRepository;

    public Visitor saveHomeVisitor(VisitorHomeDTO visitorHomeDTO) {
        Visitor visitor = new Visitor();
        visitor.setIp(visitorHomeDTO.getIp());
        visitor.setDate(visitorHomeDTO.getDate());
        visitor.setHour(visitorHomeDTO.getHour());

        return visitorRepository.save(visitor);
    }

    public Visitor saveRecordVisitor(VisitorRecordDTO visitorRecordDTO) {
        Optional<Visitor> visitor = visitorRepository.findById(visitorRecordDTO.getId());

        if(visitor.isPresent()) {
            Visitor presentVisitor = visitor.get();
            presentVisitor.setIsBlocked(visitorRecordDTO.getIsBlocked());
            presentVisitor.setCategory(visitorRecordDTO.getCategory());
            presentVisitor.setComment(visitorRecordDTO.getComment());

            return visitorRepository.save(presentVisitor);
        }

        return null;
    }
    public List<VisitorHomeDTO> listVisitorsHome() {
        List<VisitorHomeDTO> visitorsHome = visitorRepository.findAll()
                .stream()
                .map(visitor -> {
                    VisitorHomeDTO visitorHomeDTO = new VisitorHomeDTO();
                    visitorHomeDTO.setId(visitor.getId());
                    visitorHomeDTO.setIp(visitor.getIp());
                    visitorHomeDTO.setDate(visitor.getDate());
                    visitorHomeDTO.setHour(visitor.getHour());

                    return visitorHomeDTO;
                })
                .collect(Collectors.toList());

        return visitorsHome;
    }
    public List<VisitorRecordDTO> listVisitorsRecord() {
        List<VisitorRecordDTO> visitorsRecord = visitorRepository.findAll()
                .stream()
                .map(visitor -> {
                    VisitorRecordDTO visitorRecordDTO = new VisitorRecordDTO();
                    visitorRecordDTO.setId(visitor.getId());
                    visitorRecordDTO.setIp(visitor.getIp());
                    visitorRecordDTO.setIsBlocked(visitor.getIsBlocked());
                    visitorRecordDTO.setCategory(visitor.getCategory());
                    visitorRecordDTO.setComment(visitor.getComment());

                    return visitorRecordDTO;
                })
                .collect(Collectors.toList());

        return visitorsRecord;
    }
    public Optional<VisitorRecordDTO> getVisitorByIp(String ip) {
        Optional<Visitor> visitorToFind = visitorRepository.findVisitorByIp(ip);

        if(visitorToFind.isPresent()) {
            Visitor visitor = visitorToFind.get();
            VisitorRecordDTO visitorRecordDTO = new VisitorRecordDTO();
            visitorRecordDTO.setId(visitor.getId());
            visitorRecordDTO.setIp(visitor.getIp());
            visitorRecordDTO.setIsBlocked(visitor.getIsBlocked());
            visitorRecordDTO.setCategory(visitor.getCategory());
            visitorRecordDTO.setComment(visitor.getComment());

            return Optional.of(visitorRecordDTO);
        }
        return Optional.empty();
    }
}
