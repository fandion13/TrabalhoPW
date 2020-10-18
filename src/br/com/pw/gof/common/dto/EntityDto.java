package br.com.pw.gof.common.dto;

import java.sql.Date;

public class EntityDto {
	private Integer id;
	private String nome;
	private Date dt_nasc;
	private String n_prev;
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	public String getN_prev() {
		return n_prev;
	}
	public void setN_prev(String n_prev) {
		this.n_prev = n_prev;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
