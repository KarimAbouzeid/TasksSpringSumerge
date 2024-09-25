package org.example.dtos;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AuthorDto {

    private String name;
    private String email;
    private LocalDate dateOfBirth;


}
