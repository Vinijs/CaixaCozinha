package br.com.caixacozinha.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.caixacozinha.entity.ProdutoEntity;

public class ProdutoDAO {
    protected EntityManager entityManager;
 
    public ProdutoDAO() {
        entityManager = getEntityManager();
    }
 
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CaixaCozinha");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
 
    public ProdutoEntity getById(final int id) {
        return entityManager.find(ProdutoEntity.class, id);
    }
 
    @SuppressWarnings("unchecked")
    public List<ProdutoEntity> findAll() {
        return entityManager.createQuery("FROM " + ProdutoEntity.class.getName()).getResultList();
    }
 
    public void persist(ProdutoEntity produto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(ProdutoEntity produto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(produto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(ProdutoEntity produto) {
        try {
            entityManager.getTransaction().begin();
            produto = entityManager.find(ProdutoEntity.class, produto.getId());
            entityManager.remove(produto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(final int id) {
        try {
            ProdutoEntity produto = getById(id);
            remove(produto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

