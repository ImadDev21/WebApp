package com.springboot.webapplication.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;


    @Autowired
    public AuthorController(AuthorService authorService) {

        this.authorService =  authorService;
    }

    @RequestMapping("/showAuthor")
    public List<Author> getAuthor(){
        return authorService.getAuthor();
    }

    @RequestMapping("/listByName")
    public List<Author> getAuthorByName(String filterText){
        return authorService.getAuthorByName(filterText);
    }

    @RequestMapping("/count")
    public long countAuthors(){
        return authorService.countAuthors();
    }

    @RequestMapping("/createAuthor")
    public String createAuthor(Author author){
        return authorService.createAuthor(author);
    }

    @RequestMapping("/deleteAuthor")
    public String delete(long id){
        return authorService.delete(id);
    }

    @RequestMapping("/updateAuthor")
    public String update(long id, String email){
        return authorService.update(id, email);
    }

}
