package com.vicheak.auditentitydemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Entity
//@Table(name = "bars")
//@EntityListeners(AuditListener.class)
public class BarJpaAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "operation")
    private String operation;

    @Column(name = "timestamp")
    private Long timestamp;

    //internal callback methods corresponding lifecycle events
    //here are the implementation of all the callback methods
    @PrePersist
    public void onPrePersist(){
        audit("INSERT");
    }

    @PreUpdate
    public void onPreUpdate(){
        audit("UPDATE");
    }

    @PreRemove
    public void onPreRemove(){
        audit("DELETE");
    }

    private void audit(String operation){
        setOperation(operation);
        setTimestamp(new Date().getTime());
    }

}
