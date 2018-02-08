package br.com.tomas.example.vehicle;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author tomaslm
 */
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {

}
