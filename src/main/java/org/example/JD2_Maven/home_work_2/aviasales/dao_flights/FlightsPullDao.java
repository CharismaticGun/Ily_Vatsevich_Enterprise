package org.example.JD2_Maven.home_work_2.aviasales.dao_flights;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.example.JD2_Maven.home_work_2.aviasales.dao_airports.AirportPullDao;
import org.example.JD2_Maven.home_work_2.aviasales.service.FlightsService;
import org.example.JD2_Maven.home_work_2.aviasales.dao_flights.api.IFlightsDao;
import org.example.JD2_Maven.home_work_2.aviasales.dto.Airport;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightsPullDao implements IFlightsDao {

    private final FlightsService service = FlightsService.getInstance();

    private final DataSource ds;

    public FlightsPullDao() {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        try {
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Проверь имя драйвера!",e);
        }
        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("postgres");
        this.ds = pool;
    }

    public List<String[]> addFlights(int offset)  {

        service.setQueryFlights();

        List<String[]> flights = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        String s = service.getSb().toString();

        try(Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(s);
            AirportPullDao dao = new AirportPullDao()) {
            int count = 1;
            if (!service.getDateOut().equals("")) {
                statement.setTimestamp(count, Timestamp.valueOf(service.getDateOut()));
                count++;
            }
            if (!"".equals(service.getAirportOut())&&service.getAirportOut()!=null) {
                for (Airport airport : dao.getAll()) {
                    if (airport.toString().equals(service.getAirportOut())) {
                        statement.setString(count,airport.getAirport_code());
                        count++;
                    }
                }
            }
            if (!service.getDateIn().equals("")) {
                statement.setTimestamp(count, Timestamp.valueOf(service.getDateIn()));
                count++;
            }

            if (!"".equals(service.getAirportIn())&&service.getAirportIn()!=null) {
                for (Airport airport : dao.getAll()) {
                    if (airport.toString().equals(service.getAirportIn())) {
                        statement.setString(count,airport.getAirport_code());
                        count++;
                    }
                }
            }
            statement.setInt(count,offset);
            try(ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    sb.append(map(set));
                    if (sb.toString().endsWith("\n")) {
                        flights.add(sb.toString().split(";"));
                        sb.setLength(0);
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flights;
    }
    private String map(ResultSet set) throws SQLException{

        return  set.getString("flight_id") +  ";" +
                set.getString("flight_no") +  ";" +
                set.getString("scheduled_departure") + ";" +
                set.getString("scheduled_departure_local") + ";" +
                set.getString("scheduled_arrival") + ";" +
                set.getString("scheduled_arrival_local") + ";" +
                set.getString("scheduled_duration") + ";" +
                set.getString("departure_airport") + ";" +
                set.getString("departure_airport_name") + ";" +
                set.getString("departure_city") + ";" +
                set.getString("arrival_airport") + ";" +
                set.getString("arrival_airport_name") + ";" +
                set.getString("arrival_city") + ";" +
                set.getString("status") + ";" +
                set.getString("aircraft_code")+"\n";
    }

    @Override
    public void close() throws Exception {
        DataSources.destroy(this.ds);
    }
}
