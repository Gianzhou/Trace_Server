package com.bst530.group26.models.database;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="username")
    private String username;
    
    @Column(name="lname")
    private String lastName;
    
    @Column(name="fname")
    private String firstName;
    
    @Column(name="description")
    private String description;
  
    @OneToMany(mappedBy = "user")
    private List<Point> points;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    	name="group_member",
    	joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
    	inverseJoinColumns = @JoinColumn(name="group_id", referencedColumnName="id")
    )
    private List<Group> groups;

    public User(){}

    public User(String username, String lastN, String firstN){
        this.username = username;
        this.lastName = lastN;
        this.firstName = firstN;
    }

//description    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//username   
    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

//lastname    
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//firstname	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

//groups
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
    
    
}
