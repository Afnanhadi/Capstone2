package com.example.capstone2.Repostore;

import com.example.capstone2.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {
    Store findStoreById (Integer Id);
    //boolean findStoreByProductsPriceLessThan (Double Salary);
   // List<Store> findStoreByState (Integer Id);
}