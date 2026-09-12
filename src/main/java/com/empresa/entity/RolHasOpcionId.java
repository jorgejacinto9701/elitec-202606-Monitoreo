package com.empresa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RolHasOpcionId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "idrol")
    private Integer idrol;

    @Column(name = "idopcion")
    private Integer idopcion;
}
