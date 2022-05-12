package com.lab9.repositories;

import com.lab9.entities.AbstractEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public abstract class DataRepository
        <T extends AbstractEntity, ID extends Serializable> {

    protected final EntityManager em;
    private final Class<T> type;

    public DataRepository(Class<T> type) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        this.em = emf.createEntityManager();

        this.type = type;
    }

    public T findById(ID id) {

        return em.find(type, id);
    }

    public void create(T object) {

        persist(object);
    }

    public boolean persist(T entity) {

        try {

            beginTransaction();
            em.persist(entity);
            commit();
            return true;
        }
        catch (Exception e) {

            handleException(e);
            rollback();
            return false;
        }
    }

    private void beginTransaction() {

        em.getTransaction().begin();
    }

    public void commit() {

        em.getTransaction().commit();
    }

    private void handleException(Exception e) {

        e.printStackTrace();
    }

    private void rollback() {

        em.getTransaction().rollback();
    }
}
