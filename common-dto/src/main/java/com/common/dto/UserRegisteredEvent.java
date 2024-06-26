package com.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class UserRegisteredEvent implements Serializable {
    private UUID id;
    private String username;
    private String email;
}