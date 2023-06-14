package com.cosmos.entities;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.*;
import org.springframework.data.annotation.Id;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Container(containerName = "user_container")
public class User {

    @Id
    @GeneratedValue
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    @PartitionKey
    private String userId;

}
