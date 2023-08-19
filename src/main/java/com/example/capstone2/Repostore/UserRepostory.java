package com.example.capstone2.Repostore;

import com.example.capstone2.Model.User;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepostory extends JpaRepository<User,Integer> {
    User findUserById (Integer Id);

    List<User> findUserByName (String name);
    List<User> findUserByPoints (Double points);
    boolean existsByEmailAndPassword(String password,String email);
    User findAllByPoints (Double points );
  //  @Query("select c from User c where c.points>=?1")
  // User findUserByPointsGreaterThanEqual (Double ProductsPrice);

}