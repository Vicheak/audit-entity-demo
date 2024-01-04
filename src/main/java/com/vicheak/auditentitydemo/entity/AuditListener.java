package com.vicheak.auditentitydemo.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class AuditListener {

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyOperation(Object object) {
        //cast to bar POJO
        //System.out.println(object);
        BarJpaAudit bar = (BarJpaAudit) object;
        System.out.println(bar);
    }

}
