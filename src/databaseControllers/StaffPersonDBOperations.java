package databaseControllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import databaseEntity.HibernateUtil;
import databaseEntity.Staffperson;

public class StaffPersonDBOperations {
	
	public List<Staffperson> selectStaffPerson(List<String> columnNames, List<String> boundingParameters){
		
		List<Staffperson> outputList = null;
		
		Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        
	        QueryCreator queryParameters = new QueryCreator();
	        Query query = session.createQuery("from Staffperson"+
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
	
	public boolean addStaffPerson(Staffperson newPerson){
		
		Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        
	        session.save(newPerson);
	        
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
	
	public boolean updateStaffPerson(Staffperson targetPerson){
		
		Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        
	        Staffperson updatePerson = (Staffperson)session.get(Staffperson.class, targetPerson.getPersonalId());
	        updatePerson.copyParameters(targetPerson);
	        session.update(updatePerson);
	       
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
	
	public boolean deleteStaffPerson(int personalId){
		
		Session session = HibernateUtil.openSession();
	    Transaction tx = null;
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        
	        Staffperson deletePerson = (Staffperson)session.get(Staffperson.class, personalId);
	        session.delete(deletePerson);
	        
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
	
	/*Query query = session.createQuery("from Staffperson s join fetch s.salaries where s.personalId='12'");
    List<Staffperson> list = query.list();
    System.out.println(list.size());*/
}
