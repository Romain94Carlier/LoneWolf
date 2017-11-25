package main.java.service;

import main.java.repository.InventoryRepository;

public class InventoryService {
	
	
	private InventoryRepository inventoryRepository;
	
	public InventoryService() {
//		currentPage = new WelcomePage(
//				new PageOption(2, "Take left"), 
//				new PageOption(46, "Go straight"), 
//				new PageOption(123, "Take right"));
		inventoryRepository = inventoryRepository.getInstance();
		inventoryRepository.loadStartInventory();
	}
}
