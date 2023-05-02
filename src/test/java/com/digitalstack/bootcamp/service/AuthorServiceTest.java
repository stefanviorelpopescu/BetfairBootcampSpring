package com.digitalstack.bootcamp.service;

import com.digitalstack.bootcamp.BootcampApplication;
import com.digitalstack.bootcamp.dao.AuthorRepository;
import com.digitalstack.bootcamp.dao.CityRepository;
import com.digitalstack.bootcamp.entity.Author;
import com.digitalstack.bootcamp.entity.City;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {BootcampApplication.class})
class AuthorServiceTest
{
    @Autowired
    static CityRepository cityRepository;

    @Autowired
    static AuthorRepository authorRepository;


    @BeforeAll
    public static void setUp() {
//        City city = new City();
//        city.setName("Iasi");
//        cityRepository.save(city);
//
//        Author author = new Author();
//        author.setName("Ion");
//        author.setCity(city);
//        authorRepository.save(author);
    }

    @Test
    public void testAuthors() {
        //given
        Optional<City> foundCity = cityRepository.findById(1L);
        assertTrue(foundCity.isPresent());

        //when
        List<Author> authors = authorRepository.findAllByNameContainingAndCity("on", foundCity.get());

        //then
        assertNotNull(authors);
        assertTrue(authors.size() > 0);
    }
}