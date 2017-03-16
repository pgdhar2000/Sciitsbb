/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.sciits.blockbuster.exception.BlockbusterException;

public abstract class BlockbusterDao<PK extends Serializable, T> {
	@Autowired
	SessionFactory sessionFactory;
	private final Class<T> persistentClass;

	//========================================================================
	
	@SuppressWarnings("unchecked")
	public BlockbusterDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	//========================================================================
	
	protected Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException he) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	//========================================================================
	
	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	//========================================================================
	
	public T saveOrUpdate(T entity) throws BlockbusterException {
		Session session=null;
		try{
			session = getSession();
			session.getTransaction().begin();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
			session.flush();
		}/*catch(HibernateException he){
			session.close();
		}*/

		catch(Exception e) {

			throw new BlockbusterException( e);
		}finally{
			session.close();
		}
		return entity;
	}

	//========================================================================
	
	public void delete(T entity) throws BlockbusterException {
		try {
			getSession().delete(entity);
		} catch (Exception e) {
			throw new BlockbusterException( e);
		}
	}

	//========================================================================
	
	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}

	//========================================================================
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return createEntityCriteria().list();
	}

	//========================================================================
	
	@SuppressWarnings("unchecked")
	public List<T> getAllBySortingByCreatedDate() {
		return createEntityCriteria().addOrder(Order.desc("createdDate")).list();

	}

	//========================================================================
	
	public void closeSession(Session session) {
		session.close();
	}
	
	//========================================================================
}