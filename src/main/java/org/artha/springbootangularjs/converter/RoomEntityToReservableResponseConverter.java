package org.artha.springbootangularjs.converter;
import org.artha.springbootangularjs.model.Links;
import org.artha.springbootangularjs.model.Self;
import org.artha.springbootangularjs.model.response.ReservableRoomResponse;
import org.springframework.core.convert.converter.Converter;
import org.artha.springbootangularjs.controller.ResourceConstants;
import org.artha.springbootangularjs.entity.RoomEntity;

public class RoomEntityToReservableResponseConverter implements Converter<RoomEntity, ReservableRoomResponse> {

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {
		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
		reservationResponse.setId(source.getId());
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice(Integer.valueOf(source.getPrice()));
		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());;
		links.setSelf(self);
		reservationResponse.setLinks(links);
		return reservationResponse;
	}
	
}
