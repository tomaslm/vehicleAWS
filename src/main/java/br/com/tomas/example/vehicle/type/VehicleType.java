package br.com.tomas.example.vehicle.type;

import br.com.tomas.example.common.BasicId;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author tomaslm
 */
@Data
public class VehicleType extends BasicId implements Serializable {

    private String name;
    private String desc;
}
