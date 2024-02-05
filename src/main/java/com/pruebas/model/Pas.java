package com.pruebas.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PASES database table.
 * 
 */
@Entity
@Table(name="PASES")
@NamedQuery(name="Consulta3", query="SELECT COUNT(DISTINCT p.sala.codsala) FROM Pas p where p.pelicula.genero=:genero")
@NamedQuery(name="Consulta4", query = "SELECT DISTINCT p.sala.codsala, (p.sala.numfilas * p.sala.numasiporfilas) as asientos, p.sala.tipoSonido FROM Pas p where (p.pelicula.genero='TERROR' or p.pelicula.genero='COMEDIA') and YEAR(p.pelicula.fechaProd)>2008 order by asientos desc")
@NamedQuery(name="Consulta6", query="SELECT DISTINCT p.pelicula FROM Pas p GROUP BY p.pelicula HAVING COUNT(p.codpase) > 5")
@NamedQuery(name="Consulta7", query="SELECT p.tipoPase, sum(e.pvp) as suma from Entrada e, Pas p where e.pas.codpase=p.codpase and e.vendido='S' and e.pas.fechaPase between :startDate and :endDate group by p.tipoPase")
/*Devolver el objeto o tuplas, los :genero, tostring*/
public class Pas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codpase;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pase")
	private Date fechaPase;

	@Column(name="tipo_pase")
	private String tipoPase;

	//bi-directional many-to-one association to Entrada
	@OneToMany(mappedBy="pas")
	private List<Entrada> entradas;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	@JoinColumn(name="codpelicula")
	private Pelicula pelicula;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="codsala")
	private Sala sala;

	public Pas() {
	}

	public int getCodpase() {
		return this.codpase;
	}

	public void setCodpase(int codpase) {
		this.codpase = codpase;
	}

	public Date getFechaPase() {
		return this.fechaPase;
	}

	public void setFechaPase(Date fechaPase) {
		this.fechaPase = fechaPase;
	}

	public String getTipoPase() {
		return this.tipoPase;
	}

	public void setTipoPase(String tipoPase) {
		this.tipoPase = tipoPase;
	}

	public List<Entrada> getEntradas() {
		return this.entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Entrada addEntrada(Entrada entrada) {
		getEntradas().add(entrada);
		entrada.setPas(this);

		return entrada;
	}

	public Entrada removeEntrada(Entrada entrada) {
		getEntradas().remove(entrada);
		entrada.setPas(null);

		return entrada;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}