package com.pharmacy.PharmacyApi.user;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Users")
@Entity(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
}
