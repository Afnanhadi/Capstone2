package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.Store;
import com.example.capstone2.Repostore.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<Store> getAllStore(){
        return storeRepository.findAll();
    }
    public void addStore(Store store){
        storeRepository.save(store);
    }
    public void UpdateStore(Store store, Integer Id){
        Store store1= storeRepository.findStoreById(Id);
        if(store1==null){
            throw new ApiException("not found id");
        }

        store1.setAddress(store.getAddress());
        store1.setNameStore(store.getNameStore());
        store1.setState(store.getState());
        storeRepository.save(store1);
    }
    public void deleteStore(Integer Id){
        Store store= storeRepository.findStoreById(Id);
        if(store==null){
            throw new ApiException("not found id");
        }
        storeRepository.delete(store);
    }
   public void changeStatus(Integer Id){
        Store store1= storeRepository.findStoreById(Id);
        if(store1==null){
            throw new ApiException("not found id");
        }
        if (store1.getState().equals("Available")){
            store1.setState("Locked");
        }
         else if (store1.getState().equals("Locked")){
                store1.setState("Available");
            }
        }
    }

