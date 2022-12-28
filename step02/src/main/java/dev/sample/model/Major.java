package dev.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Major {
	
	@Id
	@Column(name = "MAJOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	private String majorName;
	
	public Major(int id, String majorName) {
		super();
		this.id = id;
		this.majorName = majorName;
	}

	public Major(String majorName) {
		super();
		this.majorName = majorName;
	}

	@Override
	public String toString() {
		return "Major [id=" + id + ", majorName=" + majorName + "]";
	}

	public Major() {
		super();
	}

	public String getMajorName() {
		return majorName;
	}
	
	
}
