package databaseControllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import constants.DatabaseConstants;
import databaseEntity.EntityDefinition;
import databaseEntity.Salary;

/**
 * This abstract class packing all common functionality of database operations.
 * Another database operations classes extends this abstract class
 */
public abstract class OperationClass implements DatabaseOperationsInterface {

	// result status of last operation
	protected String actualOperationStatus = null;
	// connected provider, where will be send operation status
	private StatusUpdateInterface provider = null;

	public OperationClass() {
	}

	/**
	 * registration of operation provider in constructor
	 * 
	 * @param newProvider
	 *            instance of operation provider class (interface)
	 */
	public OperationClass(StatusUpdateInterface newProvider) {
		provider = newProvider;
	}

	/**
	 * Set new operation provider.
	 * 
	 * @param newProvider
	 *            new operation provider
	 */
	public void setProvider(StatusUpdateInterface newProvider) {
		provider = newProvider;
	}

	/**
	 * Update operation status of operation provider
	 */
	protected void updateProviders() {
		provider.setActualStatus(actualOperationStatus);
	}

	/**
	 * Select data of specific column names and parameters. This class contain
	 * all catch blocks and real functionality is in the selectProcess class
	 */
	public List<EntityDefinition> select(List<String> columnNames, List<String> boundingParameters, String orderBy) {
		Session session = null;
		Transaction tx = null;

		List<EntityDefinition> result = null;
		try {
			// create session
			session = HibernateUtil.openSession();
			// create transaction
			tx = session.getTransaction();
			// open transaction
			tx.begin();

			result = selectProcess(columnNames, boundingParameters, orderBy, session);

			// commit transaction
			tx.commit();

			// catch blocks
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_DUPLICITE;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_ENTITY_NOT_EXIST;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} catch (PropertyValueException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_NULL_PROPERTY;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_UNKNOWN;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		// setting operation status and sending it to provider
		actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_SUCCESS;
		updateProviders();

		return result;
	};

	/**
	 * Select entity with specific primary key. This class contain all catch
	 * blocks and real functionality is in the selectProcess class
	 */
	public EntityDefinition select(EntityDefinition entity) {
		Session session = null;
		Transaction tx = null;

		EntityDefinition result = null;
		try {
			// create session
			session = HibernateUtil.openSession();
			// create transaction
			tx = session.getTransaction();
			// open transaction
			tx.begin();

			result = selectProcess(entity, session);

			// commit transaction
			tx.commit();

			// catch blocks
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_DUPLICITE;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_ENTITY_NOT_EXIST;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} catch (PropertyValueException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_NULL_PROPERTY;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_UNKNOWN;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		// setting operation status and sending it to provider
		actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_SUCCESS;
		updateProviders();

		return result;
	};

	/**
	 * Add entity to database. This class contain all catch blocks and real
	 * functionality is in the addProcess class. Return primary key of inserted entity
	 */
	public Serializable add(EntityDefinition newEntity) {
		Session session = null;
		Transaction tx = null;
		Serializable result = null;
		
		try {
			// create session
			session = HibernateUtil.openSession();
			// create transaction
			tx = session.getTransaction();
			// open transaction
			tx.begin();

			result = addProcess(newEntity, session);

			// commit transaction
			tx.commit();

			// catch blocks
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_DUPLICITE;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_ENTITY_NOT_EXIST;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} catch (PropertyValueException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_NULL_PROPERTY;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_UNKNOWN;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return null;
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		// setting operation status and sending it to provider
		actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_SUCCESS;
		updateProviders();

		return result;
	};

	/**
	 * Update entity to database. This class contain all catch blocks and real
	 * functionality is in the updateProcess class
	 */
	public boolean update(EntityDefinition targetEntity) {
		Session session = null;
		Transaction tx = null;

		try {
			// create session
			session = HibernateUtil.openSession();
			// create transaction
			tx = session.getTransaction();
			// open transaction
			tx.begin();

			updateProcess(targetEntity, session);

			// commit transaction
			tx.commit();

			// catch blocks
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_DUPLICITE;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return false;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_ENTITY_NOT_EXIST;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return false;
			}
		} catch (PropertyValueException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_NULL_PROPERTY;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_UNKNOWN;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return false;
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		// setting operation status and sending it to provider
		actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_SUCCESS;
		updateProviders();

		return true;
	}

	/**
	 * Delete entity to database. This class contain all catch blocks and real
	 * functionality is in the updateProcess class
	 */
	public boolean delete(EntityDefinition entity) {
		Session session = null;
		Transaction tx = null;

		try {
			// create session
			session = HibernateUtil.openSession();
			// create transaction
			tx = session.getTransaction();
			// open transaction
			tx.begin();

			deleteProcess(entity, session);

			// commit transaction
			tx.commit();

			// catch blocks
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_DUPLICITE;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return false;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_ENTITY_NOT_EXIST;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return false;
			}
		} catch (PropertyValueException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_NULL_PROPERTY;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_UNKNOWN;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return false;
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		// setting operation status and sending it to provider
		actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_SUCCESS;
		updateProviders();

		return true;
	}

	/**
	 * Delete entity group, which is correct for selected parameters. This class
	 * contain all catch blocks and real functionality is in the updateProcess
	 * class
	 */
	public int groupDelete(List<String> columnNames, List<String> boundingParameters) {
		Session session = null;
		Transaction tx = null;

		int result = 0;
		try {
			// create session
			session = HibernateUtil.openSession();
			// create transaction
			tx = session.getTransaction();
			// open transaction
			tx.begin();

			result = groupDeleteProcess(columnNames, boundingParameters, session);

			// commit transaction
			tx.commit();

			// catch blocks
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_DUPLICITE;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return 0;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_ENTITY_NOT_EXIST;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return 0;
			}
		} catch (PropertyValueException e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_NULL_PROPERTY;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_ERROR_UNKNOWN;
			updateProviders();
			if (tx != null) {
				tx.rollback();
				return 0;
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		// setting operation status and sending it to provider
		actualOperationStatus = DatabaseConstants.DB_OPERATION_RESULT_SUCCESS;
		updateProviders();

		return result;
	}

	/**
	 * Logic function for select function
	 * 
	 * @param columnNames
	 *            column parameters
	 * @param boundingParameters
	 *            parameters of select
	 * @param session
	 *            created session
	 * @return selected list of entities
	 */
	protected List<EntityDefinition> selectProcess(List<String> columnNames, List<String> boundingParameters,
			String orderBy, Session session) {
		return null;
	}

	/**
	 * Logic function for select function
	 * 
	 * @param columnNames
	 *            target entity
	 * @param session
	 *            created session
	 * @return one selected entity
	 */
	protected EntityDefinition selectProcess(EntityDefinition entity, Session session) {
		return null;
	}

	/**
	 * Logic function for add function
	 * 
	 * @param newEntity
	 *            entity for insert
	 * @param session
	 *            created session
	 * @return primary key of inserted entity
	 */
	protected Serializable addProcess(EntityDefinition newEntity, Session session) {
		return null;
	}

	/**
	 * Logic function for update function
	 * 
	 * @param newEntity
	 *            entity for update
	 * @param session
	 *            created session
	 */
	protected void updateProcess(EntityDefinition targetEntity, Session session) {
	}

	/**
	 * Logic function for delete function
	 * 
	 * @param newEntity
	 *            entity for delete
	 * @param session
	 *            created session
	 */
	protected void deleteProcess(EntityDefinition entity, Session session) {
	}

	/**
	 * Logic function for group delete function
	 * 
	 * @param columnNames
	 *            column parameters
	 * @param boundingParameters
	 *            parameters of selection for delete
	 * @param session
	 *            created session
	 */
	protected int groupDeleteProcess(List<String> columnNames, List<String> boundingParameters, Session session) {
		return 0;
	}

	/**
	 * Method translate relative column names to entity column names
	 * 
	 * @param columnNames
	 *            list of relative column names
	 * @return list of real entity column names
	 */
	protected List<String> translateColumnNames(List<String> columnNames, EntityDefinition entity) {
		if (columnNames == null) {
			return null;
		}

		List<String> translatedColumns = new ArrayList<>();

		for (String columnName : columnNames) {
			translatedColumns.add(entity.getColumnName(columnName));
		}

		return translatedColumns;
	}
}
