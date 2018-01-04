package com.example.synchronizer.repository;

import com.example.synchronizer.model.HumanModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HumanRepository {

    int count();

    HumanModel fetchById(int id);

    List<HumanModel> fetchAll();
}
