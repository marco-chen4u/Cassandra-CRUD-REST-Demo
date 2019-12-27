package com.marco.cassandra.pojo;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.Date;

@PrimaryKeyClass
public class LocationKey implements Serializable {
    //fields
    @PrimaryKeyColumn(name = "vehicle_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)//composite Row-Key
    private String vehicleId;

    @PrimaryKeyColumn(name = "date", ordinal = 1, type = PrimaryKeyType.PARTITIONED)//composite Row-Key
    private String date;

    @PrimaryKeyColumn(name = "time", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)//Column-Key
    private Date time;

    // constructor
    public LocationKey(String vehicleId, String date, Date time) {
        this.vehicleId = vehicleId;
        this.date = date;
        this.time = time;
    }

    // methods
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationKey)) return false;

        LocationKey that = (LocationKey) o;

        if (!getVehicleId().equals(that.getVehicleId())) return false;
        if (!getDate().equals(that.getDate())) return false;
        return getTime().equals(that.getTime());
    }

    @Override
    public int hashCode() {
        int result = getVehicleId().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getTime().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LocationKey{" +
                "vehicleId='" + vehicleId + '\'' +
                ", date='" + date + '\'' +
                ", time=" + time +
                '}';
    }
}
