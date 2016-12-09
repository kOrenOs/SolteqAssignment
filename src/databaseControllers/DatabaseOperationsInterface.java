package databaseControllers;

import java.io.Serializable;
import java.util.List;

import databaseEntity.EntityDefinition;

/*
 * Interface for mapping all entity database operations.
 */
public interface DatabaseOperationsInterface {

	// based on the column names and bounding parameters can select data
	List<EntityDefinition> select(List<String> columnNames, List<String> boundingParameters, String orderBy);

	// unique select- return just one entity with attributed primary key
	EntityDefinition select(EntityDefinition entity);

	// add new entity to database
	Serializable add(EntityDefinition newEntity);

	// update entity to database, will be used data from target entity
	boolean update(EntityDefinition targetEntity);

	// delete entity, which primary key is same with target entity
	boolean delete(EntityDefinition targetEntity);

	// can delete group which is selected with the attributed parameters
	int groupDelete(List<String> columnNames, List<String> boundingParameters);
}
