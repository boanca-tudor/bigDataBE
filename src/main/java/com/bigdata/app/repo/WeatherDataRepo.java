package com.bigdata.app.repo;

import com.bigdata.app.entity.WeatherData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WeatherDataRepo extends CassandraRepository<WeatherData, UUID> {
}
