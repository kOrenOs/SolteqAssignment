package databaseControllers;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import databaseEntity.EntityDefinition;
import databaseEntity.Salary;
import databaseEntity.Staffperson;

public class StaffPersonDBOperations extends OperationClass {

	public StaffPersonDBOperations() {
	}

	/**
	 * registration of operation provider in constructor
	 * 
	 * @param newProvider
	 *            instance of operation provider class (interface)
	 */
	public StaffPersonDBOperations(StatusUpdateInterface newProvider) {
		super(newProvider);
	}

	/**
	 * Override method which send input data to parent class.
	 */
	@Override
	public List<EntityDefinition> select(List<String> columnNames, List<String> boundingParameters, String orderBy) {
		return super.select(columnNames, boundingParameters, orderBy);
	}

	/**
	 * Logic realization of function select. Select data with specific
	 * parameters and return list of selected entities- Staffpersons.
	 */
	@Override
	protected List<EntityDefinition> selectProcess(List<String> columnNames, List<String> boundingParameters,
			String orderBy, Session session) {
		List<EntityDefinition> outputList = null;

		QueryCreator queryParameters = new QueryCreator();
		
		String orderByTranslated = null;
		if(orderBy != null){
			orderByTranslated = translateColumnNames(Arrays.asList(orderBy), new Staffperson()).get(0);
		}
		String queryCode = queryParameters.getQueryString(translateColumnNames(columnNames, new Staffperson()),
				boundingParameters, orderByTranslated);
		if (queryCode == null) {
			return null;
		}

		Query query = session.createQuery("from Staffperson" + queryCode);
		outputList = query.list();

		return outputList;
	}

	/**
	 * Override method which send input data to parent class.
	 */
	@Override
	public EntityDefinition select(EntityDefinition entity) {
		return super.select(entity);
	}

	/**
	 * Logic realization of function select. Select and return entity-
	 * Staffperson, with specific primary key.
	 */
	@Override
	protected EntityDefinition selectProcess(EntityDefinition entity, Session session) {
		Staffperson mockedStaffperson = (Staffperson) entity;

		Staffperson selectedStaffperson = (Staffperson) session.get(Staffperson.class,
				mockedStaffperson.getPersonalId());
		return selectedStaffperson;
	}

	/**
	 * Override method which send input data to parent class.
	 */
	@Override
	public Serializable add(EntityDefinition newPerson) {
		return super.add(newPerson);
	}

	/**
	 * Logic realization of function add. Try to add entity to database.
	 */
	@Override
	protected Serializable addProcess(EntityDefinition newPerson, Session session) {
		return session.save((Staffperson) newPerson);
	}

	/**
	 * Override method which send input data to parent class.
	 */
	@Override
	public boolean update(EntityDefinition targetPerson) {
		return super.update(targetPerson);
	}

	/**
	 * Logic realization of function update. Try to update entity which is in
	 * the database yet.
	 */
	@Override
	protected void updateProcess(EntityDefinition targetPerson, Session session) {
		Staffperson targetRetypedPerson = (Staffperson) targetPerson;

		Staffperson updatePerson = (Staffperson) session.get(Staffperson.class, targetRetypedPerson.getPersonalId());
		updatePerson.copyParameters(targetRetypedPerson);
		session.update(updatePerson);
	}

	/**
	 * Override method which send input data to parent class.
	 */
	@Override
	public boolean delete(EntityDefinition person) {
		return super.delete(person);
	}

	/**
	 * Logic realization of function delete. Try to delete entity with specific
	 * primary key from database.
	 */
	@Override
	protected void deleteProcess(EntityDefinition person, Session session) {
		Staffperson deletePerson = (Staffperson) session.get(Staffperson.class, ((Staffperson) person).getPersonalId());
		session.delete(deletePerson);
	}

	/**
	 * Override method which send input data to parent class.
	 */
	@Override
	public int groupDelete(List<String> columnNames, List<String> boundingParameters) {
		return super.groupDelete(columnNames, boundingParameters);
	}

	/**
	 * Logic realization of function delete. Try to delete all entities with
	 * specific parameters from database.
	 */
	@Override
	protected int groupDeleteProcess(List<String> columnNames, List<String> boundingParameters, Session session) {
		int output = 0;

		QueryCreator queryParameters = new QueryCreator();

		Query query = session.createQuery("delete Staffperson" + queryParameters
				.getQueryString(translateColumnNames(columnNames, new Staffperson()), boundingParameters, null));
		output = query.executeUpdate();

		return output;
	}
}
