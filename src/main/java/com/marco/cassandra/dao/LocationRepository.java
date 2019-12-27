package com.marco.cassandra.dao;

import com.marco.cassandra.pojo.Location;
import com.marco.cassandra.pojo.LocationKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LocationRepository extends CassandraRepository<Location, LocationKey> {

    @Query("select * from location where vehicle_id = ?0 and date=?1")
    List<Location> findByVehicleIdAndDate(final String vehicleId, final String date);

    @Query("select * from location where vehicle_id = ?0 and date=?1 and time >= ?2 allow filtering")
    List<Location> findByVehicleIdAndDateAndTimeGreaterThanEqual(final String vehicleId, final String date, final Date time);
}
