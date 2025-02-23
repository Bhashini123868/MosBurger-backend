package edu.icet.service;

import edu.icet.dto.Item;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getAllItems();

    void addItem(String itemId, String itemName, int price, MultipartFile image);

    Optional<Item> getItemById(Long id);

    void updateItem(Long id, String itemName, int price);

    void deleteItem(Long id);
}
