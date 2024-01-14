package br.com.store.test;

import br.com.store.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProductRegister {
    public static void main (String[] args) {
        // creating a product in database
        Product cellphone = new Product();
        cellphone.setName("Samsung s23");
        cellphone.setDescription("Celular Samsung s23");
        cellphone.setPrice(new BigDecimal("5000"));

        // creating the factory to persist on entity
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");
        EntityManager em = factory.createEntityManager();

        // begin the transaction to database
        em.getTransaction().begin();

        // persisting on entity
        em.persist(cellphone);

        // on end the transaction we need to commit
        em.getTransaction().commit();

        // and than we need to close the entity manager
        em.close();
    }
}
