package dev.sample;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.sample.model.Book;

public class App2 {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			Book book = new Book();
			book.setPubDate(new Date());
			book.setBookName("xx홀릭");
			
			em.persist(book);
			
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
