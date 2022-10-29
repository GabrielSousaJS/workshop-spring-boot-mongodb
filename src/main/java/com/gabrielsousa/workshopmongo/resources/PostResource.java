package com.gabrielsousa.workshopmongo.resources;

import com.gabrielsousa.workshopmongo.domain.Post;
import com.gabrielsousa.workshopmongo.resources.util.URL;
import com.gabrielsousa.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        List<Post> list = service.findyByTitle(text);
        text = URL.decodeParam(text);
        return ResponseEntity.ok().body(list);
    }

}
