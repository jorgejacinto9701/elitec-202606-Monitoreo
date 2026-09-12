package com.empresa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rol_has_opcion")
public class RolHasOpcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RolHasOpcionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idrol")
    @JoinColumn(name = "idrol")
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idopcion")
    @JoinColumn(name = "idopcion")
    private Opcion opcion;
}
