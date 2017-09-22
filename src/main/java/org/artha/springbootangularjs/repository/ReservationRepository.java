package org.artha.springbootangularjs.repository;

import org.artha.springbootangularjs.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationEntity,Long> {
	

}
