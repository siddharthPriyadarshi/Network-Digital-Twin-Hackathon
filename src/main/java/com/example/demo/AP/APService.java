package com.example.demo.AP;

import com.example.demo.AP.Entity.AP;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class APService {
    APRepository apRepository;
    public AP saveOrCreate(AP ap){
        return apRepository.save(ap);
    }

    public List<AP> getAllAp(){
        return apRepository.findAll();
    }

    public Optional<AP> getApById(Long id){
        return apRepository.findById(id);
    }

    public Optional<AP> deleteById(Long id){
        Optional<AP> object = apRepository.findById(id);
        apRepository.deleteById(id);
        return  object;
    }

    public boolean existsById(Long id){
        return apRepository.existsById(id);
    }
}
