package edu.icet.service.impl;

import edu.icet.dto.Item;
import edu.icet.repository.ItemRepository;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;



    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void addItem(String itemId, String itemName, int price, MultipartFile image) {
        String imageName = image.getOriginalFilename(); // You can save the image file later
        Item item = new Item(itemId, itemName, price, imageName);
        itemRepository.save(item);
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public void updateItem(Long id, String itemName, int price) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Item item = existingItem.get();
            item.setItemName(itemName);
            item.setPrice(price);
            itemRepository.save(item);
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
