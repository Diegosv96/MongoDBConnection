package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Alumno {
    private Double rating;
    private int age, calificaation;
    private String name, gender, email, phone, higher_grade;
}
