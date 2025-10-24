package it.sts.stscasostudiocrud.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.sts.stscasostudiocrud.dtos.UserDto;
import it.sts.stscasostudiocrud.models.User;
import it.sts.stscasostudiocrud.repositories.UserRepository;

@Service
public class UserService implements CrudService<UserDto, Long> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto create(UserDto dto) {
        System.out.println("💾 Creo utente: " + dto.getName() + " " + dto.getSurname());
        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        user.setTel(dto.getTel());
        user.setDob(dto.getDob());

        user = userRepository.save(user);
        System.out.println("✅ Salvato utente con ID: " + user.getId());
        return dto;

    }

    @Override
    public List<UserDto> readAll() {
        List<UserDto> dtos = new ArrayList<UserDto>();
        for (User user : userRepository.findAll()) {
            dtos.add(modelMapper.map(user, UserDto.class));
        }
        return dtos;
    }

    @Override
    public UserDto read(Long key) {
        User user = userRepository.findById(key)
                .orElseThrow(() -> new RuntimeException("Utente non trovato con id " + key));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto update(Long key, UserDto updatedUser) {
        if (!userRepository.existsById(key)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato");
        }

        User user = userRepository.findById(key).get();

        user.setName(updatedUser.getName());
        user.setSurname(updatedUser.getSurname());
        user.setEmail(updatedUser.getEmail());
        user.setTel(updatedUser.getTel());
        user.setDob(updatedUser.getDob());

        userRepository.save(user);

        updatedUser.setId(user.getId());
        return updatedUser;
    }

    @Override
    public void delete(Long key) {
        if (userRepository.existsById(key)) {
            userRepository.deleteById(key);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
