package dev.amigocode.customer;

public record CustomerUpdateRequest (  String name,
                                       String email,
                                       Integer age
){

}
