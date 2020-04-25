package edu.otaviotarelho.model;


import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class Contact {

    @NotNull
    private String address;
}
