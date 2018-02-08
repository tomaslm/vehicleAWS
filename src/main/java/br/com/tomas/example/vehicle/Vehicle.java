package br.com.tomas.example.vehicle;

import br.com.tomas.example.common.BasicId;
import br.com.tomas.example.vehicle.type.VehicleType;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tomaslm
 */
@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle extends BasicId implements Serializable {

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    private String description;

    @ManyToOne(optional = false)
    private VehicleType type;

    private String plate;

}
