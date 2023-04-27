package com.digitalstack.bootcamp;

import com.digitalstack.bootcamp.dao.AuthorRepository;
import com.digitalstack.bootcamp.dao.CityRepository;
import com.digitalstack.bootcamp.entity.Author;
import com.digitalstack.bootcamp.entity.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootcampApplication.class, args);

		postLaunch(context);
	}

	private static void postLaunch(ConfigurableApplicationContext context)
	{
		CityRepository cityRepository = context.getBean(CityRepository.class);
		AuthorRepository authorRepository = context.getBean(AuthorRepository.class);

		City city = new City();
		city.setName("Iasi");
		cityRepository.save(city);

		Author author = new Author();
		author.setName("Ion");
		author.setCity(city);
		authorRepository.save(author);

		Optional<City> foundCity = cityRepository.findById(1L);
		if (foundCity.isEmpty()) {
			return;
		}
		List<Author> authors = authorRepository.findAllByNameContainingAndCity("on", foundCity.get());
		System.out.println(authors);
	}

}
