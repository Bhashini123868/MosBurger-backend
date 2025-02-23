package edu.icet.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private Integer id;
    private String name;
    private String address;
    private Integer contactInfo;
}
