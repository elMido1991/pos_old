package com.pos.dao.model;


public class Entrepot {
	private long id;
	private String libelle;
	private Localisation localisation;
	
	
	private class Localisation {
		private double attitude;
		private double longitude;
	}

}
