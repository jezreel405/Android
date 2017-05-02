package com.example.picgrid;

import android.net.Uri;

public class Person {
	private Uri imageeUri;
	private String name;
	public Person(Uri imageeUri, String name) {
		super();
		this.imageeUri = imageeUri;
		this.name = name;
	}
	public Uri getImageeUri() {
		return imageeUri;
	}
	public void setImageeUri(Uri imageeUri) {
		this.imageeUri = imageeUri;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
