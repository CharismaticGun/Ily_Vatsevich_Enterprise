package org.example.JD2_Maven.home_work_2.aviasales.dao_airports;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.example.JD2_Maven.home_work_2.aviasales.dao_airports.api.IAirportDao;
import org.example.JD2_Maven.home_work_2.aviasales.dto.Airport;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportPullDao implements IAirportDao {

    private final DataSource ds;

    public AirportPullDao() {

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

    public List<Airport> getAll(){

        List<Airport> airports = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT\n" +
                             "    airport_code,\n" +
                             "    airport_name,\n" +
                             "    city,\n" +
                             "    coordinates,\n" +
                             "    timezone\n" +
                             "FROM\n" +
                             "    bookings.airports\n" +
                             "ORDER BY\n" +
                             "    city ASC;");
             ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()){
                airports.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return airports;
    }

    public Airport get(String code){
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT\n" +
                     "    airport_code,\n" +
                     "    airport_name,\n" +
                     "    city,\n" +
                     "    coordinates,\n" +
                     "    timezone\n" +
                     "FROM\n" +
                     "    bookings.airports\n" +
                     "WHERE airport_code = ?;");
             ) {
            statement.setString(1,code);
            try(ResultSet set = statement.executeQuery()) {
                while (set.next()){
                    return map(set);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    private Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

    private Airport map(ResultSet rs) throws SQLException {
        return new Airport(
                rs.getString("airport_code"),
                rs.getString("airport_name"),
                rs.getString("city"),
                rs.getString("coordinates"),
                rs.getString("timezone")
        );
    }

    @Override
    public void close() throws Exception {
        DataSources.destroy(ds);
    }
}

