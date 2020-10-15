package kea.frisør.demo.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking
{
    @JoinColumn(name = "cut_id")
    @ManyToOne
    Cut cut;

}
