package it.sts.stscasostudiocrud.repositories;

import org.springframework.data.repository.ListCrudRepository;

import it.sts.stscasostudiocrud.models.User;

public interface UserRepository extends ListCrudRepository<User, Long> {

}
