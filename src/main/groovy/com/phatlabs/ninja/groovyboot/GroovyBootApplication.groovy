package com.phatlabs.ninja.groovyboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class GroovyBootApplication {

    static void main(String[] args) {
        SpringApplication.run GroovyBootApplication, args
    }
}
