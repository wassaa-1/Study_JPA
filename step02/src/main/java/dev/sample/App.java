package dev.sample;

import dev.sample.model.Major;
import dev.sample.model.Student;

public class App {

	public static void main(String[] args) {
		Student jeong = new Student(1, "사도");
		Student king = new Student(2, "재준");
		
		Major major1 = new Major(1, "CS");
		
		jeong.setMajor(major1);
		king.setMajor(major1);
		
		Major majorOfJeong = jeong.getMajor();
		System.out.println(majorOfJeong);
	}

}
