package com.phatlabs.ninja.groovyboot.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.Canonical
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name="notes")
@Canonical
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = ["createdAt", "updatedAt"], allowGetters= true)
class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @Column(nullable = false)
    String title

    @Column(nullable = false)
    String content

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    Date createdAt

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    Date updatedAt

}
