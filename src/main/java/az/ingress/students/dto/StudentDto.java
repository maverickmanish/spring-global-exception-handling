package az.ingress.students.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class StudentDto {

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer age;
}
