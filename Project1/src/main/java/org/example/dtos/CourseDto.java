package org.example.dtos;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Objects;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CourseDto {

    @NotEmpty(message = "Name cannot be empty")
    @NotNull
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Description cannot be empty")
    @NotNull(message = "Description cannot be null")
    @NotBlank(message = "Name cannot be empty")
    private String description;

    @NotNull(message = "Credits cannot be empty")
    @Positive(message = "Credits must be a positive number")
    private Integer credits;
}