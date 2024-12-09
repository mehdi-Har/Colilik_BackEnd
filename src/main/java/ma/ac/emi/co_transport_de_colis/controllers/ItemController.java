package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.Item;
import ma.ac.emi.co_transport_de_colis.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{idItem}")
    public Optional<Item> getItemById(@PathVariable String idItem) {
        return itemService.getItemById(idItem);
    }

    @PutMapping("/{idItem}")
    public Item updateItem(@PathVariable String idItem, @RequestBody Item updatedItem) {
        return itemService.updateItem(idItem, updatedItem);
    }

    @DeleteMapping("/{idItem}")
    public void deleteItem(@PathVariable String idItem) {
        itemService.deleteItem(idItem);
    }
}
