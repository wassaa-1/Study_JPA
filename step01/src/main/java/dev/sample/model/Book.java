package dev.sample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JPA에서는 Entity라는 개념 활용 -> 자바 객체 - DB 테이블의 하나의 행 Row가 하나의 Entity라고 보면 됨
 */
@Entity // 해당 클래스(Book)를 JPA가 관리하는 Entity로 인식하게 함
@Table(name = "BOOKS") // Table명이 BOOKS로 생성됨, 이 애노테이션을 사용하지 않으면 기본 테이블명은 class명과 동일(Book)

/*
 * 어떤 클래스를 Entity로 적용하였을 때 주의할 점
 * 1. 기본 생성자 작성 필수 (JPA가 엔티티 객체를 생성할 때 내부적으로 기본 생성자를 사용)
 * 2. 값을 저장할 필드에 final을 사용하면 안됨
 */
public class Book {
	
	/*
	 * JPA 기본 키 생성 전략
	 * 1. 직접 할당: 기본키 값을 애플리케이션 코드에서(Java 코드로) 직접 할당 ex) int id = 1, id++ 등
	 * 2. 자동 생성: DB가 직접 설정해주는 방식
	 * 	1) IDENTITY: 기본 키의 생성을 DB에게 위임(MySQL의 AUTO_INCREMENT)
	 *  2) SEQUENCE: DB의 시퀀스를 사용해서 기본키 할당(오라클에서 지원, MySQL은 지원x)
	 *  3) TABLE: 키 생성용 별도의 테이블을 사용, 시퀀스처럼 사용하는 방식, 테이블을 사용하기 때문에 모든 DB에서 사용 가능
	 *  4) AUTO: DB에 맞는 PK 값 생성 전략을 자동으로 지정(별도의 strategy를 추가하지 않으면 기본값은 AUTO)
	 *  
	 *  직접 할당 방식을 사용하려면 @Id만 사용하면 되고,
	 *  자동 생성 전략을 사용하려면 @Id + @GeneratedValue를 추가하고 원하는 키 생성 전략을 파라미터로 설정하면 됨
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "book_name", nullable = false) // Entity의 변수(필드)와 Table의 Column을 맵핑할 때 사용
	private String bookName;
	
	private String author;

	@Temporal(TemporalType.TIMESTAMP) // util.date, util.Calendar 맵핑 시 사용
	/*
	 * TemporalType.DATE: 날짜, DB의 date 타입과 맵핑(ex. 2022-03-03)
	 * TemporalType.TIME: 시간, DB의 타입과 맵핑(ex. 09:30:23)
	 * TemporalType.TIMESTAMP: 날짜와 시간, DB의 timestamp 타입과 맵핑(ex. 2022-12-27 09:53:54)
	 */
	@Column(name = "pub_date")
	private Date pubDate;
	
	
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + "]";
	}
	
	
}
