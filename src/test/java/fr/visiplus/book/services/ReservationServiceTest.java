package fr.visiplus.book.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.visiplus.book.entities.Reservation;

@SpringBootTest
public class ReservationServiceTest {
	
	@Autowired
	private ReservationService reservationService;
	
	@Test
	public void testIsReservationMoreThan() {
		//Arrange
		int numberOfDays = 7;
		Reservation reservation = new Reservation();
		reservation.setId(Long.valueOf(1));
		reservation.setDateResa(LocalDate.now());		
		
		//Act
		boolean result = reservationService.isReservationMoreThan(reservation, numberOfDays);
		
		//Assert
		assertFalse(result);		
	}

}
