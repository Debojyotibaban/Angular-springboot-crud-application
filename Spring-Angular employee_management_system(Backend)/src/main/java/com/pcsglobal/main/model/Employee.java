package com.pcsglobal.main.model;


	
	
	import javax.persistence.Column;

	//import org.springframework.boot.autoconfigure.domain.Entity;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;


	@Entity
	@Table(name="employee_table")

	public class Employee { 
		
		
		
		@GeneratedValue(strategy =GenerationType.IDENTITY) 
		@Id // need for jpa framework embedded with orm
		
		@Column(name="userid")
		private int userid;
		
	    @Column(name="name")
		private String name;
		
		@Column(name="title")
		private String title;
		
		@Column(name="body")
		private String body;
		
		
		public Employee() { // default constructor
			
		}
		
		public Employee(int Userid, String any) { // parameterized constructor
			
		}
		
		

		
			

		public Employee(int userid, String name, String title, String body) {
			super();
			this.userid = userid;
			this.name = name;
			this.title = title;
			this.body = body;
		}

		
		public int getUserid() {
			return userid;
		}

		public void setUserid(int userid) {
			this.userid = userid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		@Override
		public String toString() {
			return "Employee [userid=" + userid + ", name=" + name + ", title=" + title + ", body=" + body + "]";
		}

		
		

		

}
