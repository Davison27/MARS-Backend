package com.david.citasMedicas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_table")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor  //For having the default constructor
@Data //Shortcut for having @Setter, @Getter, @EqualsAndHashCode & @RequiredArgsConstructor
public class User {

    @Id @NonNull @Column(name = "user_id")
    private String user;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "surnames")
    private String surnames;

}

