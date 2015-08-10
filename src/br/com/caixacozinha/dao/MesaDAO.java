package br.com.caixacozinha.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caixacozinha.entity.MesaEntity;

public class MesaDAO {
    protected EntityManager entityManager;
 
    public MesaDAO() {
        entityManager = getEntityManager();
    }
 
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CaixaCozinha");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
 
    public MesaEntity getById(final int id) {
        return entityManager.find(MesaEntity.class, id);
    }
 
    @SuppressWarnings("unchecked")
    public List<MesaEntity> findAll() {
        return entityManager.createQuery("FROM " + MesaEntity.class.getName()).getResultList();
    }
 
    public void persist(MesaEntity mesa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(mesa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(MesaEntity mesa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(mesa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(MesaEntity mesa) {
        try {
            entityManager.getTransaction().begin();
            mesa = entityManager.find(MesaEntity.class, mesa.getId());
            entityManager.remove(mesa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(final int id) {
        try {
            MesaEntity mesa = getById(id);
            remove(mesa);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}