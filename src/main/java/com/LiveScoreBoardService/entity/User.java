package com.LiveScoreBoardService.entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String name;
    private String email;

    private String password;

    private String role;

    private String token;

    private Date created;
}
