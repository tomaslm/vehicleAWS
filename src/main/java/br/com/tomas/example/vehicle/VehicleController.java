package br.com.tomas.example.vehicle;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tomaslm
 */
public class VehicleController {

    @Autowired
    public VehicleRepository vehicleRepository;
}
