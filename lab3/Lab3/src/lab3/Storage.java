package lab3;

/**
 * Storage interface.
 * @author alinh
 *
 */
public interface Storage {
	
	/**
	 * Abstract method (storage capacity getter).
	 * @return Storage capacity value.
	 */
	int getStorageCapacity();

	/**
	 * Default method (storage capacity getter).
	 * @param storageUnit Storage unit.
	 * @return Storage capacity value.
	 */
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
