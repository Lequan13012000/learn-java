package com.example.demo.repository;

import com.example.demo.entity.Cate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CateRepository {
    @Query(value = "SELECT * \n" +
            "FROM cate \n" +
            "WHERE name LIKE %:name% \n" +
            "AND cd = :cd \n" +
            "ORDER BY CAST(val AS UNSIGNED), created_at ASC \n" +
            "LIMIT :limit OFFSET :offset\n", nativeQuery = true)
    List<Cate> findByNameContainingAndCdSortedByValAndCreatedAt(@Param("name") String name, @Param("cd") String cd, @Param("limit") int limit,
                                                                @Param("offset") int offset);

    @Query(value = "SELECT COUNT(*) FROM cate WHERE name LIKE %:name% AND cd = :cd", nativeQuery = true)
    long countFindByNameContainingAndCdSortedByValAndCreatedAt(@Param("name") String name, @Param("cd") String cd);
}
