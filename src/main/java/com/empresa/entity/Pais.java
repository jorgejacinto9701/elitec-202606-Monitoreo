package com.empresa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pais")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPais")
    private Integer idPais;

    @Column(name = "iso", length = 2)
    private String iso;

    @Column(name = "nombre", length = 80)
    private String nombre;
}
