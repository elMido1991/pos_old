package com.pos.dao.model.dto;


public class EntrepotDto {
	private long id;
	private String libelle;
	private Localisation localisation;
	
	
	private class Localisation {
		private double attitude;
		private double longitude;
	}

}
