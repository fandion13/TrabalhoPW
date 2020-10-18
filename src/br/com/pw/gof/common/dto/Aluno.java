package br.com.pw.gof.common.dto;

import java.sql.Date;

public class Aluno extends EntityDto{
	private Date dt_grad;
	
	public Date getDt_grad() {
		return dt_grad;
	}
	public void setDt_grad(Date dt_grad) {
		this.dt_grad = dt_grad;
	}
}
