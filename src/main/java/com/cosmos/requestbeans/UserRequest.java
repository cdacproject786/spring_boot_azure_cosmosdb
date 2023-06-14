package com.cosmos.requestbeans;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {

    @NotNull
    @NotEmpty
    private String id;

    @NotEmpty
    @NotNull
    private String firstName;

    @NotEmpty
    @NotNull
    private String lastName;

    @NotEmpty
    @NotNull
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String userId;
}
