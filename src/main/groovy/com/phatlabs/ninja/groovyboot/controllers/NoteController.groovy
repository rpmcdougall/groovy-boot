package com.phatlabs.ninja.groovyboot.controllers

import com.phatlabs.ninja.groovyboot.entities.Note
import com.phatlabs.ninja.groovyboot.exception.ResourceNotFoundException
import com.phatlabs.ninja.groovyboot.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

@RestController
@RequestMapping("/api")
class NoteController {

    @Autowired
    NoteRepository noteRepository

    @GetMapping("/notes")
    List<Note> getAllNotes() {
        noteRepository.findAll()
    }

    @PostMapping("/notes")
    Note createNote(@Valid @RequestBody Note note) {
        noteRepository.save(note)
    }

    @GetMapping("/notes/{id}")
    Note getNoteById(@PathVariable(value="id") Long noteId){
        noteRepository.findById(noteId)
            .orElseThrow { e -> new ResourceNotFoundException("Note", "id", noteId)
        }
    }

    @PutMapping("/notes/{id}")
    Note updateNote(@PathVariable(value="id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow { e -> new ResourceNotFoundException("Note", "id", noteId)}

        note.title = note.getTitle()
        note.content = note.getContent()

        Note updatedNote = noteRepository.save(note)
        updatedNote
    }

    @DeleteMapping("/notes/{id}")
    ResponseEntity<?> deleteNote(@PathVariable(value="id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow { e -> new ResourceNotFoundException("Note", "id", noteId)}

        noteRepository.delete(note)
        ResponseEntity.ok().build()
    }

}
