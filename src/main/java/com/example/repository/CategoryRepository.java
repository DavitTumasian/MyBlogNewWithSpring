package com.example.repository;

import com.example.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "update CategoryEntity category set category.name=:qCategoryname where category.id=:qId")
    void updateCategory(@Param("qCategoryname") String name, @Param("qId") long id);

}
