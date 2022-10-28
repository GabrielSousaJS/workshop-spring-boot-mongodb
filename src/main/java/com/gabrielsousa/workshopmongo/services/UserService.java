package com.gabrielsousa.workshopmongo.services;

import com.gabrielsousa.workshopmongo.domain.User;
import com.gabrielsousa.workshopmongo.dto.UserDTO;
import com.gabrielsousa.workshopmongo.repositories.UserRepository;
import com.gabrielsousa.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Not found user ID"));
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO objDto) {
        User obj = new User(objDto.getId(), objDto.getName(), objDto.getEmail());
        return obj;
    }
}
