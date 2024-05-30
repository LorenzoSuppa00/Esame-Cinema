package com.cinema;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cinema.classes.Biglietto;
import com.cinema.classes.BigliettoDAL;

public class Main {

	public static void main(String[] args) {
		
		Scanner interceptor = new Scanner(System.in);
		
		boolean insAbilitato = true;
		
		while(insAbilitato) {
			System.out.println("\nScegli l'operazione: \n"
					+ "I - Inserimento\n"
					+ "S - Stampa\n"
					+ "Q - Uscire dal programma\n"
					+ "V - Totale vendite film");
			
			String input = interceptor.nextLine();
			
			switch (input) {
			case "I":

				System.out.println("Che film vai a vedere?");
				String titolo = interceptor.nextLine();
				System.out.println("In che sala?");
				int sala = interceptor.nextInt();
				interceptor.nextLine();
				System.out.println("In quale posto di poltrona ti siederai?");
				int posto = interceptor.nextInt();
				interceptor.nextLine();
				System.out.println("In che fila si trova il posto?");
				String fila = interceptor.nextLine();
				System.out.println("Come ti chiami?");
				String nome = interceptor.nextLine();
				System.out.println("Quanti anni hai?");
				int eta = interceptor.nextInt();
				interceptor.nextLine();
				System.out.println("Qual è il prezzo base del biglietto?");
				float costo = interceptor.nextFloat();
				if (eta < 18) {
					costo = costo - (costo * 20) / 100;
				} else {
					costo = costo + 0;
				}
				
				
				Biglietto ticket = new Biglietto(titolo, sala, posto, fila, nome, eta, costo);
				try {
					BigliettoDAL conDalIns = new BigliettoDAL();
					if(conDalIns.insert(ticket))
						System.out.println("Inserimento completato");
					else
						System.out.println("Errore di inserimento");
				} catch (SQLException e) {
					System.out.println("ERRORE: " + e.getMessage());
				}
				break;
			case "S":
				try {
					BigliettoDAL ticketDal = new BigliettoDAL();
					ArrayList<Biglietto> elenco = ticketDal.findAll();
					
					for(int i=0; i<elenco.size(); i++) {
						System.out.println(elenco.get(i));
					}
					
				} catch (SQLException e) {
					System.out.println("ERRORE: " + e.getMessage());
				}
				
				break;
			case "V":
				try {
					
					BigliettoDAL venditeDal = new BigliettoDAL();
					
					System.out.println("Qual è il film del quale vuoi sapere il numero di biglietti venduti?");
					String nome_film = interceptor.nextLine();
					int vendite = venditeDal.findTicketSales(nome_film);
					System.out.println(nome_film + " ha venduto "  + vendite + " biglietto/i");
				} catch (SQLException e) {
					System.out.println("ERRORE: " + e.getMessage());
				}
				break;
			case "Q":
				insAbilitato = false;
				break;
			default:
				System.out.println("Comando non riconosciuto");
				break;
			}
		}
		
		System.out.println("Programma terminato");
		
	}

}
