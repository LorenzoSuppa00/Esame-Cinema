package com.cinema.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.MysqlDataSource;

public class BigliettoDAL {
	
	private MysqlDataSource ds;
	
	public BigliettoDAL() throws SQLException {
		
		this.ds = new MysqlDataSource();
		this.ds.setUser("root");
		this.ds.setPassword("toor");
		this.ds.setServerName("localhost");
		this.ds.setPort(3306);
		this.ds.setDatabaseName("gestione_biglietti");
		this.ds.setUseSSL(false);
		this.ds.setAllowPublicKeyRetrieval(true);
		
	}
	
	public boolean insert(Biglietto con) throws SQLException{
		Connection conn = this.ds.getConnection();
		boolean risultato = false;
		
		String query = "INSERT INTO Biglietto (titolo_film, sala, numero_posto, fila, prezzo, nome_persona, eta_persona) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, con.getTitolo());
		ps.setInt(2, con.getSala());
		ps.setInt(3, con.getNum_posto());
		ps.setString(4, con.getFila());
		ps.setFloat(5, con.getPrezzo());
		ps.setString(6, con.getNome());
		ps.setInt(7, con.getEta());
		
		int righeCoinvolte = ps.executeUpdate();
		if(righeCoinvolte > 0)
			risultato = true;
		
		conn.close();
		return risultato;
	}
	
	public ArrayList<Biglietto> findAll() throws SQLException{
		ArrayList<Biglietto> risultato = new ArrayList<Biglietto>();
		Connection conn = this.ds.getConnection();
		
		String query = "SELECT bigliettoID, titolo_film, sala, numero_posto, fila, prezzo, nome_persona, eta_persona FROM Biglietto";
		PreparedStatement ps = conn.prepareStatement(query);
				
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Biglietto ticket = new Biglietto();
			ticket.setId( rs.getInt("bigliettoID") );
			ticket.setTitolo(rs.getString("titolo_film"));
			ticket.setSala(rs.getInt("sala"));
			ticket.setNum_posto(rs.getInt("numero_posto"));
			ticket.setFila(rs.getString("fila"));
			ticket.setPrezzo(rs.getFloat("prezzo"));
			ticket.setNome(rs.getString("nome_persona"));
			ticket.setEta(rs.getInt("eta_persona"));
			
			
			risultato.add(ticket);
		}
		
		conn.close();
		return risultato;
	}

	public int findTicketSales(String titolo) throws SQLException{
		Connection conn = this.ds.getConnection();
		int risultato = 0;
		
		String query = "SELECT COUNT(*) AS Tot_Vendite FROM Biglietto WHERE titolo_film = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, titolo);
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
	        risultato = rs.getInt("Tot_Vendite");
	    }
		
		conn.close();
		return risultato;
		
	}
	
	public float findMovieCash(String titolo) throws SQLException{
		Connection conn = this.ds.getConnection();
		float risultato = 0;
		
		String query = "SELECT SUM(prezzo) AS Tot_incassi FROM Biglietto WHERE titolo_film = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, titolo);
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
	        risultato = rs.getFloat("Tot_incassi");
	    }
		
		conn.close();
		return risultato;
	}
	

}

