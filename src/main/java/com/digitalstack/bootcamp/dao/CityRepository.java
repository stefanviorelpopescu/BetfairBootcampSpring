package com.digitalstack.bootcamp.dao;

import com.digitalstack.bootcamp.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long>
{
}
