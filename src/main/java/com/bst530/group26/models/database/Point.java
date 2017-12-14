package com.bst530.group26.models.database;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.*;

@Entity
@Table(name = "points")
public class Point {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;
    
    @Column(name="latitude")
    private double latitude;
    
    @Column(name="longitude")
    private double longitude;

    @Column(name="dateTime")
    private Timestamp dateTime;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    public Point(){}

    public Point(User user, double latitude, double longitude){ 
    	this.user = user;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateTime = Timestamp.from(Instant.now());
    }
//id
    public long getID(){
        return this.id;
    }

    public void setID(long id){
        this.id = id;
    }
//latitude
    public double getLatitude(){
        return this.latitude;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
//Longitude
    public double getLongitude(){
        return this.longitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
//dataTime
	public Timestamp getDateTime() {
		return dateTime;
	}

	
//user	
public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//calculate the distance between two point 
	public double distanceFrom(Point point) {
        double lat1 = (float)this.getLatitude();
        double lng1 = (float)this.getLongitude();

        double lat2 = (float)point.getLatitude();
        double lng2 = (float)point.getLongitude();

        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist;
    }

}
