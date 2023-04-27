package com.digitalstack.bootcamp.dao;

import com.digitalstack.bootcamp.entity.Author;
import com.digitalstack.bootcamp.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long>
{
    List<Author> findAllByNameContainingAndCity(String name, City city);
}
