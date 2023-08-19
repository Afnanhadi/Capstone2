package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.Product;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repostore.ProductRepostory;
import com.example.capstone2.Repostore.StoreRepository;
import com.example.capstone2.Repostore.UserRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepostory userRepostory;
    private  final StoreRepository storeRepository;
    private final ProductRepostory productRepostory;
    public List<User> getAll(){
        return userRepostory.findAll();
    }
    public void addUser(User user){
        userRepostory.save(user);
    }
    public void updateUser(User user, Integer Id){
        User user1=userRepostory.findUserById(Id);
        if (user1==null){
            throw new ApiException("id not found");
        }
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setSalary(user.getSalary());
        userRepostory.save(user1);

    }
    public void deleteUser( Integer Id){
        User user1=userRepostory.findUserById(Id);
        if (user1==null){
            throw new ApiException("nof found");
        }
        userRepostory.delete(user1);
    }
    public List<User> nameUser(String name){
        List<User> users=userRepostory.findUserByName(name);
        if (users.isEmpty()){
            throw new ApiException("is Empty");
        }
        return users;
    }


    public boolean checkPasswordEmail(String password,String email){
       boolean users= userRepostory.existsByEmailAndPassword(password,email);
        if (users==false){
            throw new ApiException("is Empty");
        }
          return true;
    }




    public void buyByPoints(Double ProductsPrice,Integer Id){
        User user=userRepostory.findUserById(Id);
        if (user==null){
            throw new ApiException("not found");
        }
        if (user.getPoints()<ProductsPrice){
            throw  new ApiException("The price of the product is larger than points");
        }


    }

}
