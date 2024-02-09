package com.example.demo.UserNode;

import com.example.demo.UserNode.Entity.UserNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserNodeService {
    @Autowired
    UserNodeRepository userNodeRepository;

    public UserNode saveOrCreate(UserNode body){
        return userNodeRepository.save(body);
    }

    public List<UserNode> getAllUserNode(){
        return userNodeRepository.findAll();
    }

    public Optional<UserNode> getUserNodeById(Long id){
        return userNodeRepository.findById(id);
    }

    public Optional<UserNode> deleteById(Long id){
        Optional<UserNode> UserNodeEntity = userNodeRepository.findById(id);
        userNodeRepository.deleteById(id);
        return UserNodeEntity;
    }
    public boolean existsById(Long id){
        return  UserNodeRepository.existsById(id);
    }
}
