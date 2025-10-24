package it.sts.stscasostudiocrud.services;

import java.util.List;

import it.sts.stscasostudiocrud.dtos.UserDto;

public interface CrudService<ReadDto, Key> {

    List<ReadDto> readAll();

    ReadDto read(Key key);

    ReadDto create(ReadDto dto);

    ReadDto update(Key key, UserDto userDto);

    void delete(Key key);
}
