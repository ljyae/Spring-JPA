package com.oraclejava.boothello2.repos;

import org.springframework.data.repository.CrudRepository;

import com.oraclejava.boothello2.entities.Impression;

public interface ImpressionRepository extends CrudRepository<Impression, Integer>{

}
