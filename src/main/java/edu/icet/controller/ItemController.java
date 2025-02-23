package edu.icet.controller;

import edu.icet.dto.Item;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@CrossOrigin
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping("/add-item")
    public String addItem(@RequestParam("itemId") String itemId,
                          @RequestParam("itemName") String itemName,
                          @RequestParam("price") int price,
                          @RequestParam("image") MultipartFile image) {
        itemService.addItem(itemId, itemName, price, image);
        return "Item added successfully!";
    }

    @GetMapping("/{id}")
    public Optional<Item> getItem(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PutMapping("/update-item/{id}")
    public String updateItem(@PathVariable Long id,
                             @RequestParam("itemName") String itemName,
                             @RequestParam("price") int price) {
        itemService.updateItem(id, itemName, price);
        return "Item updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "Item deleted successfully!";
    }
}
