package com.jrsf.consumerwikimedia.repository;

import com.jrsf.consumerwikimedia.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long>{
}
