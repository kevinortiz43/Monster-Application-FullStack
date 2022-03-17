package com.monster.records.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class monster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String creature;
	private double challenge;
	private String classification;
	private String size;
	private int armor;
	private long health;
	private String alignment;
	private boolean legendary;
	private String portrait;

	public monster() {
		super();
	}

	public monster(int id, String creature, double challenge, String classification, String size, int armor,
			long health, String alignment, boolean legendary, String portrait) {
		super();
		this.id = id;
		this.creature = creature;
		this.challenge = challenge;
		this.classification = classification;
		this.size = size;
		this.armor = armor;
		this.health = health;
		this.alignment = alignment;
		this.legendary = legendary;
		this.portrait = portrait;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreature() {
		return creature;
	}

	public void setCreature(String creature) {
		this.creature = creature;
	}

	public double getChallenge() {
		return challenge;
	}

	public void setChallenge(double challenge) {
		this.challenge = challenge;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public long getHealth() {
		return health;
	}

	public void setHealth(long health) {
		this.health = health;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public boolean isLegendary() {
		return legendary;
	}

	public void setLegendary(boolean legendary) {
		this.legendary = legendary;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

}
