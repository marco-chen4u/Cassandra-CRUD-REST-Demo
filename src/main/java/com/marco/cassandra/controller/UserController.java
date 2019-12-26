package com.marco.cassandra.controller;

import com.marco.cassandra.pojo.Result;
import com.marco.cassandra.pojo.User;
import com.marco.cassandra.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Api(value = "User RestController")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * find all users
     */
    @ApiOperation(value = "get all users", notes = "Get all users")
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, "successfully found", userService.findAll());
    }

    /**
     * find all users filtered by age
     * @param age
     * @return
     */
    @ApiOperation(value = "get all users filtered by age", notes = "Get all users filtered by age")
    @ApiImplicitParam(name = "age", value = "user's age", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/getFilterByAge/{age}", method = RequestMethod.GET)
    public Result getUserFilterByAge(@PathVariable int age) {
        return new Result(true, "sucessfully found", userService.findByAgeGreaterThanEqual(age));
    }

    /**
     * find a user
     */
    @ApiOperation(value = "get user", notes = "Get user based on id")
    @ApiImplicitParam(name = "id", value = "user's id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable Integer id) {
        return new Result(true, "found successfully", userService.findById(id));
    }

    /**
     * add a user
     */
    @ApiOperation(value = "create new user", notes = "Create new user")
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody User user) {
        userService.add(user);
        return new Result(true, "create successfully");
    }

    /**
     * update a user
     */
    @ApiOperation(value = "update a user", notes = "Update a user")
    @ApiImplicitParam(name = "id", value = "user's id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody User user, @PathVariable Integer id) {
        user.setId(id);
        userService.update(user);
        return new Result(true, "update successfully");
    }

    /**
     * delete an article
     */
    @ApiOperation(value = "Delete user", notes = "Delete user based on user id")
    @ApiImplicitParam(name = "id", value = "user's id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return new Result(true, "deleted successfully");
    }
}
