package org.estsoft.blogcrudassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlogCrudAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogCrudAssignmentApplication.class, args);
    }

}
