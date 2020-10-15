package kea.frisør.demo.repository;

import kea.frisør.demo.model.Barber;
import org.springframework.data.repository.CrudRepository;

public interface BarberRepository extends CrudRepository <Barber,Integer>
{
    Barber findBarberByNameContaining(String name);
}
