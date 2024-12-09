package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Item;
import ma.ac.emi.co_transport_de_colis.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(String idItem) {
        return itemRepository.findById(idItem);
    }

    public Item updateItem(String idItem, Item updatedItem) {
        return itemRepository.findById(idItem)
                .map(item -> {
                    item.setPhoto(updatedItem.getPhoto());
                    item.setDescription(updatedItem.getDescription());
                    item.setQuantity(updatedItem.getQuantity());
                    item.setDimension(updatedItem.getDimension());
                    item.setWeight(updatedItem.getWeight());
                    return itemRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found : " + idItem));
    }

    public void deleteItem(String idItem) {
        itemRepository.deleteById(idItem);
    }
}
