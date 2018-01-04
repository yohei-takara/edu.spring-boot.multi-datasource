package com.example.synchronizer.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HumanRepository {

    int count();
}
