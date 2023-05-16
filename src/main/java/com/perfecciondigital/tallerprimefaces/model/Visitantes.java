package com.perfecciondigital.tallerprimefaces.model;

import java.util.Date;

public class Visitantes implements Comparable{

	 private String nombre;
	 private String apellido;
	 private String edad;
	 private String pais;
	 private Date fecha;
	 
	 public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNombre() {
	  return nombre;
	 }  
	 public void setNombre(String nombre) {
	  this.nombre = nombre;
	 }
	 public String getApellido() {
	  return apellido;
	 }
	 public void setApellido(String apellido) {
	  this.apellido = apellido;
	 }
	 public String getEdad() {
	  return edad;
	 }
	 public void setEdad(String edad) {
	  this.edad = edad;
	 }
	 public String getPais() {
	  return pais;
	 }
	 public void setPais(String pais) {
	  this.pais = pais;
	 }
	@Override
	public int compareTo(Object o) {
		return 0;
	} 
	
	
}
