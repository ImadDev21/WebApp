package com.springboot.webapplication.client;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<Client, Long>{
        /*@Query("select c from Clients c " +
                "where lower(c.nom) like lower(concat('%', :Username, '%')) "+
                "lower(c.prenom) like lower(concat('%', :Password, '%'))")
        boolean search(@Param("Username") String username, @Param("Password") String password);*/
}
