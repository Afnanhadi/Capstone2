package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.Product;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repostore.ProductRepostory;
import com.example.capstone2.Repostore.UserRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepostory productRepostory;
    private final UserRepostory userRepostory;
    public List<Product> getAllStore(){
        return productRepostory.findAll();
    }
    public void addProduct(Product product){
        productRepostory.save(product);
    }
    public void UpdateProduct(Product product, Integer id){
        Product product1=productRepostory.findAllById(id);
        if(product1==null){
            throw new ApiException("not found id");
        }

        product1.setProducts(product.getProducts());
        product1.setProductsPrice(product.getProductsPrice());
        productRepostory.save(product1);
    }
    public void deleteProduct(Integer id){
        Product product=productRepostory.findAllById(id);
        if(product==null){
            throw new ApiException("not found id");
        }
        productRepostory.delete(product);
    }
    public void buyProduct(Product product, User user, Integer Id,Integer IdUser) {
        Product product1 = productRepostory.findAllById(Id);
        if (product1 == null) {
            throw new ApiException("not found Id product");
        }
        User user1 = userRepostory.findUserById(IdUser);
        if (user1 == null) {
            throw new ApiException("not found Id User");
        }
        if (user1.getSalary() >= product1.getProductsPrice()) {
            user1.setSalary(user1.getSalary() - product1.getProductsPrice() );
            user1.setPoints(user1.getPoints() + 0.5);
            userRepostory.save(user1);
            productRepostory.save(product1);
        } else {
            throw new ApiException("The balance is insufficient");

        }
    }
}