package org.example.JD2_Maven.home_work_2.aviasales.service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightsService {

    private static final String QUERY_FLIGHTS = "SELECT\n" +
            "    flight_id,\n" +
            "    flight_no,\n" +
            "    scheduled_departure,\n" +
            "    scheduled_departure_local,\n" +
            "    scheduled_arrival,\n" +
            "    scheduled_arrival_local,\n" +
            "    scheduled_duration,\n" +
            "    departure_airport,\n" +
            "    departure_airport_name,\n" +
            "    departure_city,\n" +
            "    arrival_airport,\n" +
            "    arrival_airport_name,\n" +
            "    arrival_city,\n" +
            "    status,\n" +
            "    aircraft_code\n" +
            "FROM\n" +
            "    bookings.flights_v\n";

    private static final String QUERY_WHERE = "WHERE\n";

    private static final String QUERY_AND = "AND\n";

    private final StringBuilder sb = new StringBuilder();

    private String dateOut;

    private String airportOut;

    private String dateIn;

    private String airportIn;

    private FlightsService(){}

    private static  class FlightsServiceHolder{
        private static final FlightsService service = new FlightsService();
    }

    public static FlightsService getInstance() {
        return FlightsServiceHolder.service;
    }

    public void setParam(HttpServletRequest request)  {

        if (getSb().toString().equals("")) {

            this.dateOut = formatDate(request.getParameter("dateOut") +
                    " " + request.getParameter("timeOut"));

            this.airportOut = request.getParameter("airportOut");

            this.dateIn = formatDate(request.getParameter("dateIn") +
                    " " + request.getParameter("timeIn"));

            this.airportIn = request.getParameter("airportIn");
        }

    }

    public void setQueryFlights() {

        if (getSb().toString().equals("")) {

            if (!getDateOut().equals("")) {
                sb.append(QUERY_WHERE + "\tscheduled_departure_local = ? ");
            }
            if (!"".equals(getAirportOut()) && getAirportOut() != null) {
                sb.append(sb.length() > 0 ? QUERY_AND : QUERY_WHERE).append("\tdeparture_airport = ? ");
            }
            if (!getDateIn().equals("")) {
                sb.append(sb.length() > 0 ? QUERY_AND : QUERY_WHERE).append("\tscheduled_arrival_local = ? ");
            }
            if (!"".equals(getAirportIn()) && getAirportIn() != null) {
                sb.append(sb.length() > 0 ? QUERY_AND : QUERY_WHERE).append("\tarrival_airport = ? \n");
            }

            sb.append("OFFSET ?\n").append("LIMIT 25;").
                    insert(0, QUERY_FLIGHTS);
        }
    }

    private String formatDate(String date) {
        if (!date.equals(" ")&&!date.contains("null")) {
            return LocalDateTime.parse(date.replace(" ","T")).format(
                    DateTimeFormatter.ISO_LOCAL_DATE_TIME).replace("T"," ");
        } else {
            return "";
        }
    }

    public String getDateOut() {
        return dateOut;
    }

    public String getAirportOut() {
        return airportOut;
    }

    public String getDateIn() {
        return dateIn;
    }

    public String getAirportIn() {
        return airportIn;
    }

    public StringBuilder getSb() {
        return sb;
    }
}
