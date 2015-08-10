package br.com.caixacozinha.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mesas")
public class MesaEntity {
	
	@Id
	@GeneratedValue
	private int id;
	private String número;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNúmero() {
		return número;
	}
	public void setNúmero(String número) {
		this.número = número;
	}	
}
