package kea.frisør.demo.controller;


import kea.frisør.demo.repository.BarberRepository;
import kea.frisør.demo.repository.CutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CutController
{
    @Autowired
    CutRepository cutRepository;
    @Autowired
    BarberRepository barberRepository;

    //CRUD Methods

    //Create
    @RequestMapping(value = "/create-cut", method = RequestMethod.GET)
    public String createCut()
    {
        return "create-cut";
    }

    //Read all
    @GetMapping("/cuts")
    public String readAllCuts(Model model)
    {
        model.addAttribute("cuts", cutRepository.findAll());
        return "cuts";
    }

    @PostMapping("/edit-cut")
    public String editCut(@RequestParam int cutID, Model model) {
        model.addAttribute("cut", cutRepository.findById(cutID).get());
        return "edit-cut";
    }
/*
    //Update
    @RequestMapping(value = "/saveCut", method = RequestMethod.POST)
    public String updateCut(@RequestParam int cutID,
                            @RequestParam String title,
                            @RequestParam String category,
                            @RequestParam int price,
                            @RequestParam(required=false) String visibleOnSite,
                            Model model)

}
*/
}