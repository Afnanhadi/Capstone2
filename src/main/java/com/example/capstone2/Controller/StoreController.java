package com.example.capstone2.Controller;

import com.example.capstone2.Api.ApiResponse;
import com.example.capstone2.Model.Store;
import com.example.capstone2.Service.StoreService;
import com.example.capstone2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreController {
    private final StoreService storeService;
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(storeService.getAllStore());

    }
    @PostMapping("/add")
    public ResponseEntity addStore(@RequestBody @Valid Store store){
        storeService.addStore(store);
        return ResponseEntity.status(200).body(new ApiResponse("add store"));
    }
    @PutMapping("/update/{Id}")
    public ResponseEntity UpdateStore(@RequestBody @Valid Store store,@PathVariable Integer Id){
        storeService.UpdateStore(store,Id);
        return ResponseEntity.status(200).body(new ApiResponse("Update Store"));
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteStore(@PathVariable Integer Id){
        storeService.deleteStore(Id);
        return ResponseEntity.status(200).body(new ApiResponse("Delete Store"));
    }
    @PutMapping("/change/{Id}")
    public ResponseEntity changeStatus(@PathVariable Integer Id){
        storeService.changeStatus(Id);
        return ResponseEntity.status(200).body(new ApiResponse("change Status"));
    }


}