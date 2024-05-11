package com.evaluacion.backend.service;

import com.evaluacion.backend.entity.Visitor;
import com.evaluacion.backend.repository.VisitorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VisitorService {
    private final VisitorRepository visitorRepository;

    public Visitor saveVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }
    public List<Visitor> listVisitors() {
        return visitorRepository.findAll();
    }
    public Visitor getVisitorByIp(String ip) {
        Visitor visitorInList = visitorRepository. findVisitorByIp(ip);

        if(visitorInList != null) {
            return visitorInList;
        }
        return null;
    }
}
