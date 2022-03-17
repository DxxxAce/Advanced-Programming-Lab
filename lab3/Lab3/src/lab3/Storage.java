package lab3;

public interface Storage {
	
	int getStorageCapacity();

	default long getStorageCapacity(StorageUnit storageUnit) {
		
		long capacity = getStorageCapacity();
		
		switch (storageUnit) {
		
			case MEGABYTE:
				
				capacity *= 1024;
				break;
			
			case KILOBYTE:
				
				capacity *= 1024 * 1024;
				break;
				
			case BYTE:
				
				capacity *= 1024 * 1024 * 1024;
				break;
				
			default:
				
				break;
		}
		
		return capacity;
	}
}
