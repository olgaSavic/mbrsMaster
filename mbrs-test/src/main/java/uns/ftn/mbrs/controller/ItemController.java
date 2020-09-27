package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.ItemService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;


    @GetMapping(value = "allItems")
    public String getAllItem(Model model) {
        List<Item> allItems = this.itemService.getAll();
        model.addAttribute("items", allItems);
        return "ItemList";
    }

    @GetMapping(value = "item/new")
    public String newItem(Model model) {
        model.addAttribute("item", new Item());
        return "ItemForm";
    }

    @GetMapping(value = "item/edit")
    public String editItem(@RequestParam("id") String id, Model model) {
        Item item = itemService.getOne(Long.parseLong(id)).orElse(null);
        model.addAttribute("item", item);
        return "ItemForm";
    }

    @GetMapping(value = "item/{id}")
    public String showItemDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("item", itemService.getOne(id).orElse(null));
        return "ItemDetails";
    }


    @GetMapping("item/delete")
    public String deleteItem(@RequestParam("id") String id, Model model) {
        itemService.delete(Long.parseLong(id));
        List<Item> allItems = this.itemService.getAll();
        model.addAttribute("items", allItems);
        return "ItemList";
    }


    @PostMapping(value = "addItem")
    public String addItem(@ModelAttribute Item item, Model model) {
        itemService.add(item);
        List<Item> allItems = this.itemService.getAll();
        model.addAttribute("items", allItems);
        return "ItemList";
    }






}



