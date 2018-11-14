package com.qa.account;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//lol
public class Account 
{
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	
	private Long id;
	@Column (length = 100)
	private String first_name;
	@Column (length = 50)
	private String last_name;
	@Column
	private int account_number;
	
	public Account (Long id, String first_name, String last_name, int account_number) 
	{
		super();
		this.id =  id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.account_number = account_number;
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", account_number="
				+ account_number + "]";
	}
	
	
	
	
	
	

}
