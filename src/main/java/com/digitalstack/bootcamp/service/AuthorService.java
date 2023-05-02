package com.digitalstack.bootcamp.service;

import com.digitalstack.bootcamp.converters.AuthorConverter;
import com.digitalstack.bootcamp.dao.AuthorRepository;
import com.digitalstack.bootcamp.dao.CityRepository;
import com.digitalstack.bootcamp.dto.AuthorDto;
import com.digitalstack.bootcamp.entity.Author;
import com.digitalstack.bootcamp.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService
{
    final CityRepository cityRepository;
    final AuthorRepository authorRepository;

    public AuthorService(CityRepository cityRepository, AuthorRepository authorRepository)
    {
        this.cityRepository = cityRepository;
        this.authorRepository = authorRepository;
    }

    public void init() {
        City city = new City();
        city.setName("Iasi");
        cityRepository.save(city);

        Author author = new Author();
        author.setName("Ion");
        author.setCity(city);
        authorRepository.save(author);
    }

    public List<AuthorDto> testAuthors()
    {
        Optional<City> foundCity = cityRepository.findById(1L);
        if (foundCity.isEmpty()) {
            return null;
        }
        System.out.println(foundCity.get().getAuthors());

        List<Author> authors = authorRepository.findAllByNameContainingAndCity("on", foundCity.get());

        return AuthorConverter.modelsToDtos(authors);
    }
}
