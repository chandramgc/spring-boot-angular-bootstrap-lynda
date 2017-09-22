package org.artha.springbootangularjs.model.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationRequest {

	private long id;
	private long roomId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkin;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkout;

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public ReservationRequest() {
		super();
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ReservationRequest [roomId=" + roomId + ", checkin=" + checkin + ", checkout=" + checkout + "]";
	}

	public ReservationRequest(long roomId, LocalDate checkin, LocalDate checkout) {
		super();
		this.roomId = roomId;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

}
