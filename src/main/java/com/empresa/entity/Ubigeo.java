package com.empresa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ubigeo")
public class Ubigeo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUbigeo")
    private Integer idUbigeo;

    @Column(name = "departamento", length = 45)
    private String departamento;

    @Column(name = "provincia", length = 45)
    private String provincia;

    @Column(name = "distrito", length = 45)
    private String distrito;
}
