package it.sts.stscasostudiocrud.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotNull(message = "inserire nome")
    @NotBlank(message = "Il nome non può essere vuoto")
    private String name;

    @NotBlank(message = "Il cognome non può essere vuoto")
    @NotNull(message = "inserire cognome")
    private String surname;

    @NotNull(message = "inserire email")
    @NotBlank(message = "La mail non può essere vuota")
    @Email(message = "Email non valida", regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @NotBlank(message = "Il nubero di cellulare non può essere vuoto")
    @NotNull(message = "inserire cell")
    @Pattern(regexp = "^\\d{10}$", message = "Il numero di telefono deve avere 10 cifre")
    private String tel;

    @PastOrPresent(message = "La data di nascita non può essere nel futuro")
    @NotNull(message = "inserire data di nascita")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

}
