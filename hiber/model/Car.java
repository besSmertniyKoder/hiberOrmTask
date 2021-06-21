package hiber.model;


import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;


    @Column
    private int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {}


    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
