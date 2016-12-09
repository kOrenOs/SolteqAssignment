package databaseControllers;

/**
 * This interface provide observer design pattern. With this interface is
 * possible to update operation status of database functions easier.
 */
public interface StatusUpdateInterface {
	void setActualStatus(String status);
}
