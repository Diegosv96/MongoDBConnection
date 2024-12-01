package model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Profesor {
    private Double rating;
    private int age;
    private String name, gender, email, title;
    private ArrayList<String> subjects;
}
