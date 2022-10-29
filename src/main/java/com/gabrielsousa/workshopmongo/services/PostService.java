package com.gabrielsousa.workshopmongo.services;

import com.gabrielsousa.workshopmongo.domain.Post;
import com.gabrielsousa.workshopmongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.get();
    }

    public List<Post> findyByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
