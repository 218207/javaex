package com.example.exc44;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "calcolator")
@Data
public class Calcoolator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float number1;

    private Float number2;

    private String action;

    private String result;

    public Calcoolator() {
    }
}
