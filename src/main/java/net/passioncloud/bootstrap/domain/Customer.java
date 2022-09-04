package net.passioncloud.bootstrap.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class Customer {
    private int id;
    private String name;
}
