package com.bridgelabz.database.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
@Validated
public class MessageDTO{
    @NotEmpty
    @Pattern(regexp = "^[A-Z].{2,}$", message = "Title should start with a capital letter and have a minimum of three characters")
    @NotEmpty(message = "the title cant be null")
    public String title;
    @NotEmpty(message = "the  author cant be null")
    public String author;
    @Size(max = 50, message = "Description should be less than 50 characters")
    @NotEmpty
    public String discription;
    public LocalDate startDate;
    public LocalDate endDate;
}

