package com.vramires.springapi.rest_integration.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ClientDTO {

    private String name;
    private String email;
    private String phone;

}
