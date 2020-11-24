/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yelo.app.dto;

/**
 *
 * @author Ahmed Hafez
 */
public class CarDto {
	    private Long id;
	    private String owner;
	    private String name;
	    private String color;
	    private String model;
	    private byte hideMe;
	    public CarDto() {
	    }

	    public CarDto(String owner, String name, String color, String model, byte hideMe) {
	        this.owner = owner;
	        this.name = name;
	        this.color = color;
	        this.model = model;
	        this.hideMe = hideMe;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getOwner() {
			return owner;
		}

		public void setOwner(String owner) {
			this.owner = owner;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public byte getHideMe() {
			return hideMe;
		}

		public void setHideMe(byte hideMe) {
			this.hideMe = hideMe;
		}
	    

}
