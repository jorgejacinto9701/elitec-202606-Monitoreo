package com.empresa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "datacatalogo")
public class DataCatalogo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDataCatalogo")
    private Integer idDataCatalogo;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCatalogo", nullable = false)
    private Catalogo catalogo;
}
