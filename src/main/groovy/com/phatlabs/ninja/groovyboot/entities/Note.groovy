package com.phatlabs.ninja.groovyboot.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.Canonical
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name="notes")
@Canonical
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters= true)
class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @NotEmpty
    String title

    @NotEmpty
    String content

}
