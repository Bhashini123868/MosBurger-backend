package edu.icet.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private Long id;
    private String itemId;
    private String itemName;
    private int price;
    private String imageName;

    public Item(String itemId, String itemName, int price, String imageName) {
    }
}
