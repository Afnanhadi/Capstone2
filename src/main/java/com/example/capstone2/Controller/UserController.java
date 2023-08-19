package com.example.capstone2.Controller;

import com.example.capstone2.Api.ApiResponse;
import com.example.capstone2.Model.User;
import com.example.capstone2.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/User")
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(userService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user){
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("add user"));
    }
    @PutMapping("/update/{Id}")
    public ResponseEntity updateUser(@RequestBody @Valid User user, @PathVariable  Integer Id){
        userService.updateUser(user,Id);
        return ResponseEntity.status(200).body(new ApiResponse("Update user"));
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteUser(@PathVariable Integer Id){
        userService.deleteUser(Id);
        return ResponseEntity.status(200).body(new ApiResponse("delete user"));
    }
    @GetMapping("/Search/{name}")
    public ResponseEntity nameUser(@PathVariable String name){
        return ResponseEntity.status(200).body( userService.nameUser(name));
    }

     @PostMapping("/check")
    public ResponseEntity LoginPasswordEmail(String password, String email,@RequestBody @Valid User user){

        userService.checkPasswordEmail(user.getPassword(),user.getEmail());

     return ResponseEntity.status(200).body(new ApiResponse("Login"));
    }

    @GetMapping("/checkPoints/{ProductsPrice}/{Id}")
    public ResponseEntity checkPoints(@PathVariable Double ProductsPrice,@PathVariable Integer Id){
        userService.buyByPoints(ProductsPrice,Id);
        return ResponseEntity.status(200).body(new ApiResponse("The product was successfully"));

    }
}
