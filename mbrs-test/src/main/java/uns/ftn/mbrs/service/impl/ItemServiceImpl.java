package uns.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uns.ftn.mbrs.repository.ItemRepository;
import uns.ftn.mbrs.service.ItemService;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import java.util.Date;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List < Item > getAll() {
    return this.itemRepository.findAll();
    }

    @Override
    public Optional <Item> getOne(Long id) {
    return this.itemRepository.findById(id);
    }

    @Override
    public void update(Item item) {
    this.itemRepository.save(item);
    }

    @Override
    public void add(Item item) {
    this.itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        Optional <Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
        itemRepository.delete(item.get());
        }
    }
}


