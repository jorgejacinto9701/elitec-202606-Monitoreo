package com.empresa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "catalogo")
public class Catalogo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCatalogo")
    private Integer idCatalogo;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

}
