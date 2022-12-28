package dev.sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.sample.model.Book;

public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
//			tx.begin();
//			
//			Book book = new Book();
//			book.setBookName("xxx홀릭");
//			book.setAuthor("클램프");
//			
//			// Book Entity 영속화: DB INSERT
//			em.persist(book);
//			
//			tx.commit();
			
			// Book data 조회: SELECT ~, 데이터 조회는 transaction 작업이 필요 없음
			Book book2 = em.find(Book.class, 1);  // id가 1인 데이터 조회
			
			// Book 데이터 수정
			tx.begin();
			book2.setBookName("카드캡터체리");
			em.persist(book2);
			tx.commit();
			
			System.out.println(book2);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
			emf.close();
		}
	}

}
