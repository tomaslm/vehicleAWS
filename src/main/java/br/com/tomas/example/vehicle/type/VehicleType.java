package br.com.tomas.example.vehicle.type;

import br.com.tomas.example.common.BasicId;
import java.io.Serializable;
import javax.persistence.Entity;
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
@Table(name = "vehicle_type")
public class VehicleType extends BasicId implements Serializable {

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    private String description;
}
