package org.artha.springbootangularjs.converter;

import org.artha.springbootangularjs.entity.ReservationEntity;
import org.artha.springbootangularjs.model.request.ReservationRequest;

import org.springframework.core.convert.converter.Converter;

public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest, ReservationEntity>{

	@Override
	public ReservationEntity convert(ReservationRequest source) {
		ReservationEntity reservationEntity = new ReservationEntity();
		reservationEntity.setCheckin(source.getCheckin());
		reservationEntity.setCheckout(source.getCheckout());
		//if(source.getId() != null)
			reservationEntity.setId(source.getId());
		return reservationEntity;
	}

}
