package br.com.tomas.example.vehicle;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
public class VehicleController {

    private static final Logger log = Logger.getLogger(VehicleController.class.getName());

    @Autowired
    public VehicleRepository vehicleRepository;

    /**
     * Returns all vehicles
     *
     * @param filter
     * @param sortDirection
     * @param pageIndexØ
     * @return
     */
    @GetMapping("/vehicles")
    public ResponseEntity<Page<Vehicle>> getAllVehicles(Optional<String> filter,
            Optional<String> sortDirection,
            Optional<String> sortId,
            Optional<Integer> pageIndex,
            Optional<Integer> pageSize) {
        return ResponseEntity.ok(vehicleRepository.findByNameLike(filter.orElse("%"), new PageRequest(
                pageIndex.orElse(0),
                pageSize.orElse(Integer.MAX_VALUE),
                Sort.by(sortDirection.map(str -> Direction.fromString(str)).orElse(Direction.DESC),
                        sortId.orElse("ID")))));
    }

    /**
     * Creates a new vehicle
     *
     * @return
     */
    @PostMapping("/vehicles")
    public ResponseEntity<Void> createVehicle(@RequestBody Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Finds a vehicle by id
     *
     * @return
     */
    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> findOneVehicle(@PathVariable final Long id) {
        return this.vehicleRepository.findById(id).map(v -> ResponseEntity.ok(v))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Updates the info of a vehicle by id
     *
     * @param newValues
     * @return
     */
    @PutMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle,
            @PathVariable final Long id) {
        if (!this.vehicleRepository.existsById(id)) {
            log.warning("Trying to update vehicle with invalid id(" + id + ")");
            return ResponseEntity.notFound().build();
        }
        vehicle.setID(id);
        vehicleRepository.save(vehicle);
        return ResponseEntity.noContent().build();
    }

    /**
     * Deletes a vehicle by id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable final Long id) {
        if (!this.vehicleRepository.existsById(id)) {
            log.warning("Trying to delete vehicle with invalid id(" + id + ")");
            return ResponseEntity.notFound().build();
        }
        try {
            this.vehicleRepository.deleteById(id);
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Error deleting vehicle ", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();
    }
}
