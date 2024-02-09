package com.example.demo.OLT;

import com.example.demo.OLT.Entity.OLT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OLTService {

    @Autowired
    OLTRepository oltRepository;

    public OLT saveOrCreate(OLT body){
        return oltRepository.save(body);
    }

    public List<OLT> getAllOlt(){
        return oltRepository.findAll();
    }

    public Optional<OLT> getOltById(Long id){
        return oltRepository.findById(id);
    }

    public Optional<OLT> deleteById(Long id){
        Optional<OLT> oltEntity = oltRepository.findById(id);
        oltRepository.deleteById(id);
        return oltEntity;
    }
    public boolean existsById(Long id){
        return  oltRepository.existsById(id);
    }
}
