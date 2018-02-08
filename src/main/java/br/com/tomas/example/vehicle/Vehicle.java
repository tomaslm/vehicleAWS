package br.com.tomas.example.vehicle;

import br.com.tomas.example.common.BasicId;
import br.com.tomas.example.vehicle.type.VehicleType;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author tomaslm
 */
@Data
@Entity
public class Vehicle extends BasicId implements Serializable {

    private String name;
    private String desc;
    @ManyToOne(optional = false)
    private VehicleType type;
    private String plate;

}
