package com.example.capstone2.Controller;

import com.example.capstone2.Api.ApiResponse;
import com.example.capstone2.Model.Product;
import com.example.capstone2.Model.User;
import com.example.capstone2.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getAllProduct(){
        return ResponseEntity.status(200).body(productService.getAllStore());

    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product){
        productService.addProduct(product);
        return ResponseEntity.status(200).body(new ApiResponse("add Product"));
    }
    @PutMapping("/update/{IdUser}")
    public ResponseEntity UpdateProduct(@RequestBody @Valid Product product,@PathVariable Integer IdUser){
        productService.UpdateProduct(product,IdUser);
        return ResponseEntity.status(200).body(new ApiResponse("Update Product"));
    }
    @DeleteMapping("/delete/{IdUser}")
    public ResponseEntity deleteProduct(@PathVariable  Integer IdUser){
        productService.deleteProduct(IdUser);
        return ResponseEntity.status(200).body(new ApiResponse("Delete Product"));
    }
    @GetMapping("/buy/{Id}/{IdUser}")
    public ResponseEntity buyProduct(Product product, User user, @PathVariable Integer Id,@PathVariable Integer IdUser){
        productService.buyProduct(product,user,Id,IdUser);
        return ResponseEntity.status(200).body(new ApiResponse("buy Product"));
    }

}