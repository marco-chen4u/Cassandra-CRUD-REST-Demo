package com.marco.cassandra.pojo;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Table("location")
public class Location implements Serializable {
    // fields
    @PrimaryKey
    private LocationKey key;

    @Column("latitude")
    private double latitude;

    @Column("longitude")
    private double longitude;

    // constructor
    public Location(LocationKey key, double latitude, double longitude) {
        this.key = key;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // methods
    public LocationKey getKey() {
        return key;
    }

    public void setKey(LocationKey key) {
        this.key = key;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "key=" + key +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
