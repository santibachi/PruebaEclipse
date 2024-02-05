package com.pruebas.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PELICULAS database table.
 * 
 */
@Entity
@Table(name="PELICULAS")
@NamedQuery(name="Consulta1", query="SELECT DISTINCT p.genero FROM Pelicula p WHERE p.genero NOT IN (SELECT p.genero FROM Pelicula p JOIN p.pases pa)")
@NamedQuery(name="Consulta2", query="SELECT p.titulo, p.codpelicula, COUNT(pa.codpase), COALESCE(SUM(e.pvp), 0)  FROM Pelicula p LEFT JOIN p.pases pa LEFT JOIN pa.entradas e GROUP BY p.titulo, p.codpelicula")
@NamedQuery(name="Consulta5", query="SELECT DISTINCT p FROM Pelicula p,Pas pa where p.codpelicula=pa.pelicula.codpelicula and pa.sala.tipoSonido='DOLBY'")

public class Pelicula implements Serializable {
	@Override
	public String toString() {
		return "Pelicula [codpelicula=" + codpelicula + ", fechaProd=" + fechaProd + ", genero=" + genero + ", titulo="
				+ titulo;
	}

	private static final long serialVersionUID = 1L;

	@Id
	private int codpelicula;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_prod")
	private Date fechaProd;

	private String genero;

	private String titulo;

	//bi-directional many-to-one association to Pas
	@OneToMany(mappedBy="pelicula")
	private List<Pas> pases;

	public Pelicula() {
	}

	public int getCodpelicula() {
		return this.codpelicula;
	}

	public void setCodpelicula(int codpelicula) {
		this.codpelicula = codpelicula;
	}

	public Date getFechaProd() {
		return this.fechaProd;
	}

	public void setFechaProd(Date fechaProd) {
		this.fechaProd = fechaProd;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Pas> getPases() {
		return this.pases;
	}

	public void setPases(List<Pas> pases) {
		this.pases = pases;
	}

	public Pas addPas(Pas pas) {
		getPases().add(pas);
		pas.setPelicula(this);

		return pas;
	}

	public Pas removePas(Pas pas) {
		getPases().remove(pas);
		pas.setPelicula(null);

		return pas;
	}

}