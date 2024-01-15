package br.com.store.test;

import br.com.store.dao.ProductDAO;
import br.com.store.model.Category;
import br.com.store.model.Product;
import br.com.store.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProductRegister {
    public static void main (String[] args) {
        // creating a product in database
        Product cellphone = new Product("Samsung S23", "Celular Samsung 23 top de linha da marca", new BigDecimal("5000"), Category.CELLPHONE);

        // creating the factory to persist on entity
        EntityManager em = JPAUtil.getEntityManager();

        ProductDAO productDAO = new ProductDAO(em);

        // begin the transaction to database
        em.getTransaction().begin();

        // persisting on entity
        productDAO.create(cellphone);

        // on end the transaction we need to commit
        em.getTransaction().commit();

        // and than we need to close the entity manager
        em.close();
    }
}
