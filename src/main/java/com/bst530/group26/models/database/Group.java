package com.bst530.group26.models.database;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    
    @Column(name= "name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @Column(name="size")
    private int size;
    
    @Column(name="grouptype")
    private String type;
    

    public Group(){}
    
    public Group(String name, String descrip) {
    	this.name = name;
    	this.description = descrip;
    }
    
    public Group(String name, String descrip, int size, String type) {
    	this.name = name;
    	this.description = descrip;
    	this.size = size;
    	this.type = type;
    }

//name
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

//description
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

//size
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}

//type
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

    
}
