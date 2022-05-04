package org.example.JD2_Maven.home_work_2.aviasales.dao_airports.api;

import org.example.JD2_Maven.home_work_2.aviasales.dto.Airport;

import java.util.List;

public interface IAirportDao extends AutoCloseable {

    List<Airport> getAll();

    Airport get(String code);
}
