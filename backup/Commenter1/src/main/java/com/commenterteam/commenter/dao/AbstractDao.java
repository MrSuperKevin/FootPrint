/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<PK extends Serializable, T> {
	
    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
            this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager getEntityManager(){
            return this.entityManager;
    }

    protected T getByKey(PK key) {
            return (T) entityManager.find(persistentClass, key);
    }

    protected void persist(T entity) {
            entityManager.persist(entity);
    }

    protected void update(T entity) {
            entityManager.merge(entity);
    }

    protected void delete(T entity) {
            entityManager.remove(entity);
    }

}
