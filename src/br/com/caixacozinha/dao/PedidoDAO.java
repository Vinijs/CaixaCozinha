package br.com.caixacozinha.dao;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.caixacozinha.entity.PedidoEntity;
 
public class PedidoDAO {
    protected EntityManager entityManager;
 
    public PedidoDAO() {
        entityManager = getEntityManager();
    }
 
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("CaixaCozinha");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
 
        return entityManager;
    }
 
    public PedidoEntity getById(final int id) {
        return entityManager.find(PedidoEntity.class, id);
    }
 
    @SuppressWarnings("unchecked")
    public List<PedidoEntity> findAll() {
        return entityManager.createQuery("FROM " + PedidoEntity.class.getName()).getResultList();
    }
 
    public void persist(PedidoEntity pedido) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pedido);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(PedidoEntity pedido) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pedido);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(PedidoEntity pedido) {
        try {
            entityManager.getTransaction().begin();
            pedido = entityManager.find(PedidoEntity.class, pedido.getId());
            entityManager.remove(pedido);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(final int id) {
        try {
            PedidoEntity pedido = getById(id);
            remove(pedido);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
