package sky.pro.maven_project.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="city")
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityID;

    @Column(name = "city_name")
    private String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City() {
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityID == city.cityID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityID, cityName);
    }

    @Override
    public String toString() {
        return "Город: " + cityName;
    }
}
