package com.evaluacion.backend.repository;

import com.evaluacion.backend.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    Visitor findVisitorByIp(String ip);
}

