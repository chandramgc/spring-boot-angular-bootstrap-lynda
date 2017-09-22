package org.artha.springbootangularjs.repository;

import java.util.List;

import org.artha.springbootangularjs.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
	RoomEntity findById(Long id);
}
