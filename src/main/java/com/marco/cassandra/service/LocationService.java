package com.marco.cassandra.service;

import com.marco.cassandra.dao.LocationRepository;
import com.marco.cassandra.pojo.Location;
import com.marco.cassandra.uitls.TimeUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LocationService {
    // fields
    private final String LOCAL_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final int LOCAL_TIME_HOUR_DIFFERENCE = -5;

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public List<Location> findByIdAndDate(String id, String date) {
        return locationRepository.findByVehicleIdAndDate(id, date);
    }

    public List<Location> findByIdAndDateAndTimeGreaterThanEqual(String id, String date, String time) throws Exception{
        //System.out.println("entering findByIdAndDateAndTimeGreaterThanEqual....");
        Date filterTime = TimeUtils.getLocalTime(date, time);
        return locationRepository.findByVehicleIdAndDateAndTimeGreaterThanEqual(id, date, filterTime);
    }
}
