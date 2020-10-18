package br.com.pw.gof.dao;

import java.util.List;

import br.com.pw.gof.common.dto.EntityDto;
import br.com.pw.gof.common.exception.EnvironmentException;

public interface IGenericDAO {
	public EntityDto save(EntityDto entity) throws EnvironmentException;
	public EntityDto update(EntityDto entity) throws EnvironmentException;
	public void delete(Integer id) throws EnvironmentException;
	public EntityDto findById(Integer id) throws EnvironmentException;
	public List<EntityDto> findAll() throws EnvironmentException;
}
