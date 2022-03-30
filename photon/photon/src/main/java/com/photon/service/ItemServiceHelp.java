package com.photon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.photon.model.Item;
import com.photon.repository.ItemRepository;

public class ItemServiceHelp implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public List < Item > getAllItems() {
		return itemRepository.findAll();
	}
	
	@Override
	public void saveItem(Item item) {
		this.itemRepository.save(item);
	}
	
	@Override
	public Item getItemById(long id) {
		Optional < Item > optional = itemRepository.findById(id);
		Item item = null;
		if (optional.isPresent()) {
			item = optional.get();
		} else {
			throw new RuntimeException("item wasn't found by id ::" + id);
		}
		return item;
	}
	
	@Override
	public void deleteItemById(long id) {
		this.itemRepository.deleteById(id);
	}
}
