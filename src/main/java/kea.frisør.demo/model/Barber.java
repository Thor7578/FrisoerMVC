package kea.frisør.demo.model;

import java.util.*;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Barber
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int barber_id;


    public Barber(int barber_id, String name) {}
    public Barber (){ }

    @ManyToMany(mappedBy = "barbers")
    public Set<Cut> cuts;

    public String name;

    public Set<Cut> getCuts() {return cuts;}

    public void setCuts(Set<Cut> cuts) {this.cuts = cuts; }

    public int getId() {return barber_id; }

    public void setId(int id) {this.barber_id = id;}

    public String getname() {return name;}

    public void setName(String name) {this.name = name;}

    @Override
    public String toString()
    {
        return "Barber{" +
                "barber_id=" + barber_id +
                ", name='" + name + '\'' +
                '}';
    }

}
