package org.artha.springbootangularjs.model.response;

import java.time.LocalDate;

import org.artha.springbootangularjs.controller.ResourceConstants;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationResponse {

	@Override
	public String toString() {
		return "ReservationResponse [id=" + id + ", checkin=" + checkin + ", checkout=" + checkout + "]";
	}

	private long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ResourceConstants.DATE_RESPONSE_PATTERN)
	private LocalDate checkin;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ResourceConstants.DATE_RESPONSE_PATTERN)
	private LocalDate checkout;

	public ReservationResponse() {
		super();
	}

	public ReservationResponse(long id, LocalDate checkin, LocalDate checkout) {
		super();
		this.id = id;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public long getId() {
		return id;
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
