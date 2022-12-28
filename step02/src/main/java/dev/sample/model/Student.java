package dev.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	// 학생의 전공(Major)
	// 연관관계 매핑용 어노테이션 @ManyToOne, @JoinColumn
	@ManyToOne // 학과와 학생은 다대일 관계
	@JoinColumn(name = "MAJOR_ID")
	private Major major;

	public Student(int id, String studentName) {
		super();
		this.id = id;
		this.studentName = studentName;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}

	public Student() {
		super();
	}


	
	
}
