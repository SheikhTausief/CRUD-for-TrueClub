package com.TrueClub.crud.entity;

import java.sql.Timestamp;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Assignment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	private int pincode;
	private String state;
	@CreationTimestamp
//	@UpdateTimestamp
	private Timestamp row_creation_timestamp;
	

	//all getter setter methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Timestamp getRow_creation_timestamp() {
		return row_creation_timestamp;
	}
	public void setRow_creation_timestamp(Timestamp row_creation_timestamp) {
		this.row_creation_timestamp = row_creation_timestamp;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", pincode=" + pincode + ", state="
				+ state + ", row_creation_timestamp=" + row_creation_timestamp + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, address, pincode, state, row_creation_timestamp);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assignment other = (Assignment) obj;
		return  id == other.id && Objects.equals(name, other.name) && Objects.equals(address, other.address)
				&& pincode == other.pincode && Objects.equals(state, other.state)
				&& Objects.equals(row_creation_timestamp, other.row_creation_timestamp)
				;
	}
	
	public Assignment(int id, String name, String address, int pincode, String state, Timestamp row_creation_timestamp) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.pincode = pincode;
		this.state = state;
		this.row_creation_timestamp = row_creation_timestamp;
	}
	
	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}
}
