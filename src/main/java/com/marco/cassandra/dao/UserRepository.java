package com.marco.cassandra.dao;

import com.marco.cassandra.pojo.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer> {

    @AllowFiltering
    List<User> findByAgeGreaterThanEqual(int age);
}
