package com.bigdata.app.repo;

import com.bigdata.app.entity.WeatherData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRepo extends CassandraRepository<WeatherData, Long> {
}
