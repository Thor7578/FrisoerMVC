package kea.frisør.demo.model;

import org.springframework.data.annotation.Id;
import ch.qos.logback.core.boolex.EvaluationException;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cut
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToMany
    public Set<Barber> barbers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cut")
    public Set<Booking> bookings;

    public String title;
    public String category;
    public String barber;
    public int price;

    public Cut(int id, String title, String category, int price)
    {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public Cut(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Barber> getBarbers() {
        return barbers;
    }

    public void setBarbers(Set<Barber> barbers) {
        this.barbers = barbers;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Cut{" +
                "id=" + id +
                ", barber=" + barbers +
                ", name of cut='" + title + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
