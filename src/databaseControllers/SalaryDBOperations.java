package databaseControllers;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.hibernate.PropertyValueException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import constants.DatabaseConstants;
import databaseEntity.EntityDefinition;
import databaseEntity.Salary;
import databaseEntity.SalaryId;
import databaseEntity.Staffperson;

/**
 * Class extends OperationClass. This class is realization of logic methods for
 * operations with database entity- Salary.
 */
public class SalaryDBOperations extends OperationClass {

	/**
	 * registration of operation provider in constructor
	 * 
	 * @param newProvider
	 *            instance of operation provider class (interface)
	 */
	public SalaryDBOperations(StatusUpdateInterface newProvider) {
		super(newProvider);
	}

	public SalaryDBOperations() {
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
	 * parameters and return list of selected entities- Salaries.
	 */
	@Override
	protected List<EntityDefinition> selectProcess(List<String> columnNames, List<String> boundingParameters,
			String orderBy, Session session) {

		List<EntityDefinition> outputList = null;

		QueryCreator queryParameters = new QueryCreator();
		
		String orderByTranslated = null;
		if(orderBy != null){
			orderByTranslated = translateColumnNames(Arrays.asList(orderBy), new Salary()).get(0);
		}
		
		String queryCode = queryParameters.getQueryString(translateColumnNames(columnNames, new Salary()),
				boundingParameters, orderByTranslated);
		
		if (queryCode == null) {
			return null;
		}

		Query query = session.createQuery("from Salary" + queryCode);
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
	 * Logic realization of function select. Select and return entity- Salary,
	 * with specific primary key.
	 */
	@Override
	protected EntityDefinition selectProcess(EntityDefinition entity, Session session) {
		Salary mockedSalary = (Salary) entity;

		Salary selectedSalary = (Salary) session.get(Salary.class, mockedSalary.getId());
		return selectedSalary;
	}

	/**
	 * Override method which send input data to parent class.
	 */
	@Override
	public Serializable add(EntityDefinition newSalary) {
		return super.add(newSalary);
	}

	/**
	 * Logic realization of function add. Try to add entity to database.
	 */
	@Override
	protected Serializable addProcess(EntityDefinition newSalary, Session session) {
		Salary correctedSalary = getCorrectInstance((Salary) newSalary, session);
		return session.save(correctedSalary);
	}

	/**
	 * Override method which send input data to parent class.
	 */
	@Override
	public boolean update(EntityDefinition targetSalary) {
		return super.update(targetSalary);
	}

	/**
	 * Logic realization of function update. Try to update entity which is in
	 * the database yet.
	 */
	@Override
	protected void updateProcess(EntityDefinition targetSalary, Session session) {
		Salary targetRetypedSalary = (Salary) targetSalary;

		Salary updateSalary = (Salary) session.get(Salary.class, targetRetypedSalary.getId());
		updateSalary.copyParameters(targetRetypedSalary);
		session.update(updateSalary);
	}

	/**
	 * Override method which send input data to parent class.
	 */
	@Override
	public boolean delete(EntityDefinition salary) {
		return super.delete(salary);
	}

	/**
	 * Logic realization of function delete. Try to delete entity with specific
	 * primary key from database.
	 */
	@Override
	protected void deleteProcess(EntityDefinition salary, Session session) {
		SalaryId salaryId = ((Salary) salary).getId();

		Salary deleteSalary = (Salary) session.get(Salary.class, salaryId);
		session.delete(deleteSalary);
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

		Query query = session.createQuery("delete Salary" + queryParameters
				.getQueryString(translateColumnNames(columnNames, new Salary()), boundingParameters, null));
		output = query.executeUpdate();

		return output;
	}

	/**
	 * Check if salary owner exists and create new instance of salary with
	 * correct data.
	 * 
	 * @param dataInstance
	 *            mocked salary instance
	 * @param openedSession
	 *            opened session
	 * @return return data correct, checked salary instance
	 */
	private Salary getCorrectInstance(Salary dataInstance, Session openedSession) {
		if (dataInstance == null) {
			return null;
		}

		// get owner ID from salary mock
		SalaryId dataSalaryID = dataInstance.getId();

		if (dataSalaryID == null) {
			return null;
		}

		// try to find salary owner
		Staffperson salaryOwner = (Staffperson) openedSession.get(Staffperson.class, dataSalaryID.getPersonalId());

		if (salaryOwner == null) {
			return null;
		}
		return new Salary(dataSalaryID, salaryOwner, dataInstance.getSalarySum(), dataInstance.getExtraSalary());
	}
}
