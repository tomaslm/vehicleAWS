package br.com.tomas.example.vehicle.type;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tomaslm
 */
@RestController
public class VehicleTypeController {

    private static final Logger log = Logger.getLogger(VehicleTypeController.class.getName());

    @Autowired
    public VehicleTypeRepository vehicleTypeRepository;

    /**
     * Returns all vehicle types
     *
     * @return
     */
    @GetMapping("/vehicleTypes")
    public ResponseEntity<Iterable<VehicleType>> getAllVehicleTypes() {
        return ResponseEntity.ok(vehicleTypeRepository.findAll());
    }

    /**
     * Creates a new vehicle type
     *
     * @return
     */
    @PostMapping("/vehicleTypes")
    public ResponseEntity<Void> createVehicleType(@RequestBody VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Finds a vehicle type by id
     *
     * @return
     */
    @GetMapping("/vehicleType/{id}")
    public ResponseEntity<VehicleType> findOneVehicleType(@PathVariable final Long id) {
        return this.vehicleTypeRepository.findById(id).map(v -> ResponseEntity.ok(v))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Updates the info of a vehicle type by id
     *
     * @param newValues
     * @return
     */
    @PutMapping("/vehicleType/{id}")
    public ResponseEntity<VehicleType> updateVehicleType(@RequestBody VehicleType vehicleType,
            @PathVariable final Long id) {
        if (!this.vehicleTypeRepository.existsById(id)) {
            log.warning("Trying to update vehicle type with invalid id(" + id + ")");
            return ResponseEntity.notFound().build();
        }
        vehicleType.setID(id);
        vehicleTypeRepository.save(vehicleType);
        return ResponseEntity.noContent().build();
    }

    /**
     * Deletes a vehicle type by id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/vehicleType/{id}")
    public ResponseEntity<VehicleType> deleteVehicleType(@PathVariable final Long id) {
        if (!this.vehicleTypeRepository.existsById(id)) {
            log.warning("Trying to delete vehicle type with invalid id(" + id + ")");
            return ResponseEntity.notFound().build();
        }
        try {
            this.vehicleTypeRepository.deleteById(id);
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Error deleting vehicle type ", ex);
        }
        return ResponseEntity.noContent().build();
    }
}
