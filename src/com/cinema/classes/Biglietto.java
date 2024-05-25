package com.cinema.classes;

public class Biglietto {

	private int id; 
	private String titolo; 
	private int sala;
	private int num_posto;
	private String fila;
	private float prezzo;
	private String nome;
	private int eta;
	
	public Biglietto() {
		
	}

	public Biglietto(String titolo, int sala, int num_posto, String fila, String nome, int eta, float prezzo) {
		super();
		this.titolo = titolo;
		this.sala = sala;
		this.num_posto = num_posto;
		this.fila = fila;
		this.prezzo = prezzo;
		this.nome = nome;
		this.eta = eta;
	}

	public Biglietto(int id, String titolo, int sala, int num_posto, String fila, float prezzo, String nome, int eta) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.sala = sala;
		this.num_posto = num_posto;
		this.fila = fila;
		this.prezzo = prezzo;
		this.nome = nome;
		this.eta = eta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public int getNum_posto() {
		return num_posto;
	}

	public void setNum_posto(int num_posto) {
		this.num_posto = num_posto;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}


	@Override
	public String toString() {
		return "Biglietto [id=" + id + ", titolo=" + titolo + ", sala=" + sala + ", num_posto=" + num_posto + ", fila="
				+ fila + ", prezzo=" + prezzo + ", nome=" + nome + ", eta=" + eta;
	}
	
	
}
