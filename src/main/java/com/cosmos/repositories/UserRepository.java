package com.cosmos.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.cosmos.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CosmosRepository<User,String> {
}
