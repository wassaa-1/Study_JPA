package step02;

import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dev.sample.model.Major;
import dev.sample.model.Student;

class AppTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		// 학과 데이터 저장
		Major major1 = new Major("컴퓨터 공학");
		// 영속화(persist())
		em.persist(major1);
		
		// 학생1 생성, 저장
		Student student1 = new Student("Yoo");
		student1.setMajor(major1);
		em.persist(student1);
		
		// 학생2 생성, 저장
		Student student2 = new Student("Kang");
		student2.setMajor(major1);
		em.persist(student2);
		
		tx.commit();
		
		
	}
	
	@Test
	void testRead() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		
		// id가 1인 학생 엔티티 조회
		Student student = em.find(Student.class, 1);
		System.out.println(student);
		
		Major major = student.getMajor();
		System.out.println("전공 이름: " + major.getMajorName());
	}

	@Test
	void updateRelation() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Major major = new Major("국문학과");
		em.persist(major);
		
		// 학번(id) 1인 학생에게 새로운 학과(국문학과)
		Student student = em.find(Student.class, 1);
		student.setMajor(major);
		// tx.commit();가 호출되면 flush()가 발생하면서 변경 감지 기능이 작동, 
		
		tx.commit();
	}

	@Test
	void deleteEntity() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Student student = em.find(Student.class, 1);
		student.setMajor(null);
		
		Major major = em.find(Major.class, 2);
		em.remove(major);
		tx.commit();
	}
}
