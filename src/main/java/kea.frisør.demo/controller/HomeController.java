package kea.frisør.demo.controller;


import kea.frisør.demo.model.Barber;
import kea.frisør.demo.model.Cut;
import kea.frisør.demo.repository.BarberRepository;
import kea.frisør.demo.repository.BarberToolsRepository;
import kea.frisør.demo.repository.BookingRepository;
import kea.frisør.demo.repository.CutRepository;
import kea.frisør.demo.util.DummyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    @Autowired
    private BarberRepository barberRepository;
    @Autowired
    private CutRepository cutRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BarberToolsRepository barberToolsRepository;


    @GetMapping("/")
    public String index (Model model)
    {
        Iterable<Cut> cuts = cutRepository.findCutsByVisibleOnSiteTrue(); // Read method from repository

        System.out.println("Printing cuts just before they are shown");
        cuts.forEach(System.out::println);

        model.addAttribute("cuts", cuts);
        return "cuts";
    }

    @GetMapping("/testdata")
    private String generateDummyData(){
        createDummyData();
        return "home-page";
    }

    private void createDummyData()
    {
        DummyData data = new DummyData(cutRepository, barberRepository, bookingRepository, barberToolsRepository);
        data.createDummyData();
    }

    public BarberRepository getBarberRepository()
    {
        return barberRepository;
    }
    public void setBarberRepository(BarberRepository barberRepository)
    {
        this.barberRepository = barberRepository;
    }
    public CutRepository getCutRepository()
    {
        return cutRepository;
    }
    public void setCutRepository(CutRepository cutRepository)
    {
        this.cutRepository = cutRepository;
    }
}
