package com.cosmos.responsebeans;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String userId;
}
