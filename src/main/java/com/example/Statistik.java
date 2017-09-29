package com.example;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statistik")
public class Statistik implements Serializable{
	private static final long serialVersionUID = 1L;
	//@GeneratedValue
	@Id
	@Column(name="Id")
	private int id;
	@Column(name="Series")
	private String Series;
	@Column(name="Liked")
	private int Liked;
	@Column(name="Disliked")
	private int Disliked;
	@Column(name="nationalsalestype")
	private int nationalsalestype;

	
	public int getNationalsalestype() {
		return nationalsalestype;
	}

	public void setNationalsalestype(int nationalsalestype) {
		this.nationalsalestype = nationalsalestype;
	}

	public int getLiked(){
		return Liked;
	}

	public void setLiked(int Liked){
		this.Liked=Liked;
	}

	public int getDisliked(){
		return Disliked;
	}

	public void setDisliked(int Disliked){
		this.Disliked=Disliked;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeries() {
		return Series;
	}

	public void setSeries(String series) {
		Series = series;
	}
	
	
	public Statistik(){
		
	}
	public Statistik(int id,String Series){
		this.id=id;
		this.Series=Series;
		this.Liked=0;
		this.Liked=0;
	}
	
	
	
}