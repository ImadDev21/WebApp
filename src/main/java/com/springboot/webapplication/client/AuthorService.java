package com.springboot.webapplication.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorDao;

    @Autowired
    public AuthorService(AuthorRepository authorDao){this.authorDao=authorDao;}

    public List<Author> getAuthor(){
        return authorDao.findAll();
    }

    public List<Author> getAuthorByName(String filterText){
        if (filterText == null || filterText.isEmpty())
            return authorDao.findAll();
        else return authorDao.Search(filterText);
    }

    public long countAuthors (){
        return authorDao.count();
    }
    public String createAuthor(Author author)
    {
        try{
            authorDao.save(author);

        }catch (Exception e){
            return "Author not found";
        }
        return author.getFirstName() + " Has been created successfully";
    }

    public String delete(long id) {
        try {
            Author author = authorDao.getById(id);
            authorDao.delete(author);
        } catch(Exception ex) {
            return "Error precess D failed";
        }
        return " account is successfully deleted";
    }

    public String update(long id, String email) {
        try {
            Author author = authorDao.getById(id);
            // if the new email is not match the old one then we update it else we have an ERROR
            if (!(author.getEmail().equals(email)) ) {
                author.setEmail(email);
                authorDao.save(author);
            }
            else return "New email matches the old one";
        } catch (Exception ex) {
            return "Error process UP failed";
        }
        return "account is successfully updated";
    }
}
