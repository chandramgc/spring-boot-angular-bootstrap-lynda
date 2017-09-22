package org.artha.springbootangularjs.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.artha.springbootangularjs.controller.ResourceConstants;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Reservation")
public class ReservationEntity {
	
	@Override
	public String toString() {
		return "ReservationEntity [id=" + id + ", checkin=" + checkin + ", checkout=" + checkout + ", roomEntity="
				+ roomEntity + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ResourceConstants.DATE_RESPONSE_PATTERN)
	private LocalDate checkin;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ResourceConstants.DATE_RESPONSE_PATTERN)
	private LocalDate checkout;
	
	@ManyToOne
	private RoomEntity roomEntity;

	public ReservationEntity() {
		super();
	}

	public ReservationEntity(LocalDate checkin, LocalDate checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public RoomEntity getRoomEntity() {
		return roomEntity;
	}

	public void setRoomEntity(RoomEntity roomEntity) {
		this.roomEntity = roomEntity;
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
