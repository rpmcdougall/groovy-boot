package com.phatlabs.ninja.groovyboot.repository

import com.phatlabs.ninja.groovyboot.entities.Note
//import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface NoteRepository extends JpaRepository<Note, Long> {
}
