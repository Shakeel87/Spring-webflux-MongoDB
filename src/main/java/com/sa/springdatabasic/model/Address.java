package com.sa.springdatabasic.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Valid
public class Address {


    @NotNull
    private String addressLine;
    @NotNull
    private  int zipCode;
    @NotNull
    @NotBlank
    private  String state;
    @NotNull
    @NotBlank
    private String country;

}
