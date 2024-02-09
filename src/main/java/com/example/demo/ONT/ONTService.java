package com.example.demo.ONT;

import com.example.demo.ONT.Entity.ONT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ONTService {
    @Autowired
    ONTRepository ontRepository;

    public ONT saveOrCreate(ONT body){
        return ontRepository.save(body);
    }

    public List<ONT> getAllOnt(){
        return ontRepository.findAll();
    }

    public Optional<ONT> getOntById(Long id){
        return ontRepository.findById(id);
    }

    public Optional<ONT> deleteById(Long id){
        Optional<ONT> ontEntity = ontRepository.findById(id);
        ontRepository.deleteById(id);
        return ontEntity;
    }
    public boolean existsById(Long id){
        return  ontRepository.existsById(id);
    }
}
