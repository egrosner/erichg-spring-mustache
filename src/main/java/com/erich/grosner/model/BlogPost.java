package com.erich.grosner.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
@Entity
public class BlogPost
 {
     @GeneratedValue(generator = "uuid2")
     @GenericGenerator(name = "uuid2", strategy = "uuid2")
     @Column(columnDefinition = "BINARY(16)")
     @Id
     private UUID Id;

     @Column(length = 100)
     private String title;

     @Column
     private LocalDateTime postDate;

     @Column
     private String body;

     @Column(length = 200)
     private String tags;
}
