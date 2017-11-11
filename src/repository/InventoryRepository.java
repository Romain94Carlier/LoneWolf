package repository;

public class InventoryRepository {
	private static InventoryRepository instance = new InventoryRepository();
	
	private InventoryRepository() {
	}
	
	public static InventoryRepository getInstance() {
		return instance;
	}
}
