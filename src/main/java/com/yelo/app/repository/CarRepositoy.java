/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yelo.app.repository;

import com.yelo.app.entity.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ahmed Hafez
 */
@Repository
public interface CarRepositoy extends JpaRepository<Car, Long> {

    @Query(value = "select * from car c where c.name like :key or c.owner like :key", nativeQuery = true)
    public List<Car> SearchByNameOrOwner(@Param("key") String key);
}
