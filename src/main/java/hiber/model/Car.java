package hiber.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "car")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    private long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
}
