package kea.frisør.demo.repository;

import kea.frisør.demo.model.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
}
