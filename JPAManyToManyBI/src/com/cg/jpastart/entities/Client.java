package com.cg.jpastart.entities;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		// first define few products before we place order

		Product elecProduct = new Product();
		elecProduct.setProductId(1);
		elecProduct.setName("LED TV");
		elecProduct.setPrice(45000);

		Product beautyProduct = new Product();
		beautyProduct.setProductId(2);;
		beautyProduct.setName("Face Wash");
		beautyProduct.setPrice(80);

		Product babyProduct = new Product();
		babyProduct.setProductId(3);
		babyProduct.setName("Pampers");
		babyProduct.setPrice(15);

		Product eleProduct = new Product();
		eleProduct.setProductId(4);;
		eleProduct.setName("CFL Bulb");
		eleProduct.setPrice(250);

		// now define first order and add few products in it
		Order firstOrder = new Order();
		firstOrder.setOrderId(1000);
		firstOrder.setOrderDate(new Date());

		firstOrder.addProduct(babyProduct);
		firstOrder.addProduct(elecProduct);
		firstOrder.addProduct(beautyProduct);

		// now define second order and add few products in it
		Order secondOrder = new Order();
		secondOrder.setOrderId(1001);
		secondOrder.setOrderDate(new Date());

		secondOrder.addProduct(babyProduct);		
		secondOrder.addProduct(elecProduct);
		secondOrder.addProduct(eleProduct);

		// save orders using entity manager

		em.persist(firstOrder);
		em.persist(secondOrder);
		
		System.out.println("Added orders along with order details to database.");

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
