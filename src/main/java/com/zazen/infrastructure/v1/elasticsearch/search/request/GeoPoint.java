package com.zazen.infrastructure.v1.elasticsearch.search.request;

public class GeoPoint {
	private String lat;
	private String lon;
	
	public GeoPoint(String lat, String lon){
		this.lat = lat;
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	
	
}
