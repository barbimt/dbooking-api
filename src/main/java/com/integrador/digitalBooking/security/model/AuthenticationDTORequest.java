package com.integrador.digitalBooking.security.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationDTORequest {
    String email;
    String clave;
}
