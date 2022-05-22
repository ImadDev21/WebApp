package com.springboot.webapplication.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorDao;

    @Autowired
    public AuthorService(AuthorRepository authorDao){this.authorDao=authorDao;}

    public List<Author> getAuthor(){
        return authorDao.findAll();
    }


    public String createAuthor(Author author)
    {

        try{
            authorDao.save(author);

        }catch (Exception e){
            return "Client not found";
        }
        return author.getId()+ author.getFirstName()+" Has been created succefylly ";
    }
}
