package databaseControllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import databaseEntity.HibernateUtil;
import databaseEntity.Salary;
import databaseEntity.SalaryId;
import databaseEntity.Staffperson;

public class SalaryDBOperations {
	
private Salary getCorrectInstance(Salary dataInstance, Session openedSession){
	if(dataInstance == null){
		return null;
	}
	SalaryId dataSalaryID = dataInstance.getId();
	
	if(dataSalaryID == null){
		return null;
	}
	Staffperson salaryOwner = (Staffperson)openedSession.get(Staffperson.class, dataSalaryID.getPersonalId());
	
	if(salaryOwner == null){
		return null;
	}
	return new Salary(dataSalaryID, salaryOwner, dataInstance.getSalarySum(), dataInstance.getExtraSalary());
}

	public List<Salary> selectSalary(List<String> columnNames, List<String> boundingParameters){
	
		List<Salary> outputList = null;
		
		Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        
	        QueryCreator queryParameters = new QueryCreator();
	        Query query = session.createQuery("from Salary"+
	        		queryParameters.getQueryString(columnNames, boundingParameters));
	        outputList = query.list();
	        
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	            return null;
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return outputList;
	}

	public boolean addSalary(Salary newSalary){
		
		Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        
	        Salary correctedSalary = getCorrectInstance(newSalary, session);
	        session.save(correctedSalary);
	        
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	            return false;
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return true;
	}
	
	public boolean updateSalary(Salary targetSalary){
		
		Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        
	        Salary updateSalary = (Salary)session.get(Salary.class, targetSalary.getId());
	        updateSalary.copyParameters(targetSalary);
	        session.update(updateSalary);
	       
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	            return false;
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return true;
	}
	
	public boolean deleteStaffPerson(SalaryId salaryId){
		
		Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        
	        Salary deleteSalary = (Salary)session.get(Salary.class, salaryId);
	        session.delete(deleteSalary);
	        
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	            return false;
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return true;
	}
}
