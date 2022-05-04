package org.example.JD2_Maven.home_work_2.aviasales.dto;

public class Airport {

    private String airport_code;

    private String airport_name;

    private String city;

    private String coordinate;

    private String timeZone;

    public Airport(String airport_code, String airport_name, String city, String coordinate, String timeZone) {
        this.airport_code = airport_code;
        this.airport_name = airport_name;
        this.city = city;
        this.coordinate = coordinate;
        this.timeZone = timeZone;
    }

    public String getAirport_code() {
        return airport_code;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public String getCity() {
        return city;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public String getTimeZone() {
        return timeZone;
    }

    @Override
    public String toString() {
        return "Код: '" + airport_code + '\'' +
                ", имя: '" + airport_name + '\'' +
                ", город: '" + city + '\'' +
                ", координаты: '" + coordinate + '\'' +
                ", временная зона: '" + timeZone + '\'';
    }
}
