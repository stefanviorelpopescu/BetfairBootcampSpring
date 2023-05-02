package com.digitalstack.bootcamp.converters;

import com.digitalstack.bootcamp.dto.AuthorDto;
import com.digitalstack.bootcamp.entity.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorConverter
{
    public static AuthorDto modelToDto(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .city(author.getCity().getName())
                .build();
    }

    public static List<AuthorDto> modelsToDtos(List<Author> authors) {
        return authors.stream()
                    .map(AuthorConverter::modelToDto)
                    .collect(Collectors.toList());
    }
}
