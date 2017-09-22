package org.artha.springbootangularjs.converter;

import org.artha.springbootangularjs.entity.ReservationEntity;
import org.artha.springbootangularjs.model.response.ReservationResponse;
import org.springframework.core.convert.converter.Converter;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse>{

	@Override
	public ReservationResponse convert(ReservationEntity source) {
		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setCheckin(source.getCheckin());
		reservationResponse.setCheckout(source.getCheckout());
		reservationResponse.setId(source.getId());
		return reservationResponse;
	}
	

}
