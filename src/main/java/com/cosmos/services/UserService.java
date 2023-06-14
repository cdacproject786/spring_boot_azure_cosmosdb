package com.cosmos.services;

import com.cosmos.entities.User;
import com.cosmos.exceptions.UserNotFoundException;
import com.cosmos.repositories.UserRepository;
import com.cosmos.requestbeans.UserRequest;
import com.cosmos.responsebeans.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserResponse saveUser(UserRequest userRequest){
       User savedUser = this.userRepository.save(this.modelMapper.map(userRequest,User.class));
       return this.modelMapper.map(savedUser, UserResponse.class);
    }

    public UserResponse findUserById(String id){
        Optional<User> foundUser = this.userRepository.findById(id);
        if(foundUser.isPresent()) {
            UserResponse userResponse = this.modelMapper.map(foundUser.get(), UserResponse.class);
            return userResponse;
        } else
            throw new UserNotFoundException("User with given id not found");

    }

    public List<UserResponse> findAllUsers(){
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users :: add);
        List<UserResponse> responseList = new ArrayList<>(users.size());
        for(User user : users)
            responseList.add(this.modelMapper.map(user, UserResponse.class));
        return responseList;
    }
    
    public UserResponse updateUser(UserRequest newUser){
        Optional<User> foundUser = this.userRepository.findById(newUser.getId());
        if(foundUser.isPresent())
        {
            User userToUpdate = foundUser.get();
            userToUpdate.setEmail(newUser.getEmail());
            userToUpdate.setFirstName(newUser.getFirstName());
            userToUpdate.setLastName(newUser.getLastName());
            User savedUser = this.userRepository.save(userToUpdate);
            return this.modelMapper.map(savedUser, UserResponse.class);
        }
        else throw new UserNotFoundException("User with given id is not present in the database");
    }

    public void deleteuser(String id){
        this.userRepository.deleteById(id);
    }
}
