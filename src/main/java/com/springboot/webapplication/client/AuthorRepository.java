package com.springboot.webapplication.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query(value = "select * from authors a where lower(a.firstname) = lower(:filterText) or lower(a.lastname) = lower(:filterText)", nativeQuery = true)
    List<Author> Search(@Param("filterText") String filterText);
}
