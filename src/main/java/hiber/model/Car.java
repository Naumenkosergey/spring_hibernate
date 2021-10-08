package hiber.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cars")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public User setUserFromCar(User user) {
        this.user = user;
        return this.user;
    }
}
