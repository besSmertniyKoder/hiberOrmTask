package hiber.model;


import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Column(name = "model",length = 40,columnDefinition = "char default 50")
    private String model;

    @Column(name = "series",length = 50,columnDefinition = "int default 100")
    private int series;

    public Car(String model,int series,User user) {
        this.user = user;
        this.model = model;
        this.series = series;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Car() {

    }

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


    @OneToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
