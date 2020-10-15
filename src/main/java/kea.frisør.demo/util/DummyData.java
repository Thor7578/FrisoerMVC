package kea.frisør.demo.util;

import kea.frisør.demo.model.Barber;
import kea.frisør.demo.model.Cut;
import kea.frisør.demo.repository.BarberRepository;
import kea.frisør.demo.repository.BarberToolsRepository;
import kea.frisør.demo.repository.BookingRepository;
import kea.frisør.demo.repository.CutRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DummyData
{
    CutRepository cutRepository;
    BarberRepository barberRepository;
    BookingRepository bookingRepository;
    BarberToolsRepository barberToolsRepository;

    public DummyData(CutRepository cutRepository, BarberRepository barberRepository, BookingRepository bookingRepository, BarberToolsRepository barberToolsRepository)
    {
       this.cutRepository = cutRepository;
       this.barberRepository = barberRepository;
       this.bookingRepository = bookingRepository;
       this.barberToolsRepository = barberToolsRepository;
    }

    // All dummy data contained within this class
    public void createDummyData()
    {
        createCut("Kvindeklip", "Voksen", 600, createBarber("Thor Hansen"));
        createCut("Herreklip", "Voksen", 350, createBarber("Bodil Larsen"));
        createCut("Børneklip", "Barn", 150, createBarber("Lise-Lotte Kofoed"));
        createCut("Pensionistklip", "Pensionist", 100, createBarber("Emil Bjergaard"));
    }

    //CRUD Methods under Dummy Data
    //

    // Create Cut Method
    private Cut createCut(String title, String Category, int price, Barber barbers)
    {
        Set<Barber> barbersSet = new HashSet<>();

        Cut cut = new Cut();
        cut.setTitle(title);
        cut.setCategory(Category);
        cut.setBarbers((Set<Barber>) barbers);
        cut.setPrice(price);

        System.out.println(cut.toString());

        Cut saved = cutRepository.save(cut);
        System.out.println(saved);
        return saved;
    }

    // Create Barber method
    private Barber createBarber(String name)
    {
        Barber barber = new Barber();

        barber.setName(name);

        barberRepository.save(barber);

        return barber;
    }
}
