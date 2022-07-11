package com.integrador.digitalBooking.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
