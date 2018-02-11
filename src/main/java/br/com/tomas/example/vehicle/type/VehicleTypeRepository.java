package br.com.tomas.example.vehicle.type;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author tomaslm
 */
public interface VehicleTypeRepository extends PagingAndSortingRepository<VehicleType, Long> {

    Page<VehicleType> findByNameLike(String name, Pageable page);

}
