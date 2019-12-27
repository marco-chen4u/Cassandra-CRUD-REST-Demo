package com.marco.cassandra.controller;

import com.marco.cassandra.pojo.Result;
import com.marco.cassandra.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/vehicle-tracker")
@Api(value = "Vehicle Tracker RestController")
public class VehicleTrackerController {

    @Autowired
    private LocationService locationService;

    /**
     * find all locations
     */
    @ApiOperation(value = "get all locations", notes = "Get all locations")
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, "successfully found", locationService.findAll());
    }

    /**
     * find all locations by vehicleId and date
     * @param vehicleId
     * @param date
     * @return
     */
    @ApiOperation(value = "get all locations by vehicleId and date", notes = "Get all locations by vehicleId and date")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vehicleId", value = "vehicle id", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "date", value = "date", required = true, dataType = "string", paramType = "path")}
    )
    @RequestMapping(value = "/{vehicleId}/{date}", method = RequestMethod.GET)
    public Result findByIdAndDate(@PathVariable String vehicleId, @PathVariable String date) {
        return new Result(true, "successfully found", locationService.findByIdAndDate(vehicleId, date));
    }

    /**
     * find all locations by vehicleId, date and time
     * @param vehicleId
     * @param date
     * @param time
     * @return
     */
    @ApiOperation(value = "get all locations by vehicleId, date and time", notes = "Get all locations by vehicleId, date and time")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vehicleId", value = "vehicle id", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "date", value = "yyyy-mm-dd", required = true, dataType = "string", example = "2020-01-29", paramType = "path"),
            @ApiImplicitParam(name = "time", value = "hh:mm:ss", required = false, dataType = "string",  example= "08:40:00", paramType = "path")}
    )
    @RequestMapping(value = "/{vehicleId}/{date}/{time}", method = RequestMethod.GET)
    public Result findByIdAndDateFilterByTime(@PathVariable String vehicleId, @PathVariable String date, @PathVariable String time) throws Exception{
        return new Result(true, "successfully found", locationService.findByIdAndDateAndTimeGreaterThanEqual(vehicleId, date, time));
    }


}
