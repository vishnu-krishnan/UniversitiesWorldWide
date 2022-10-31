package com.study.repository;

import com.study.entity.UniversityDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityDetailsRepository extends CrudRepository<UniversityDetails,String> {
}