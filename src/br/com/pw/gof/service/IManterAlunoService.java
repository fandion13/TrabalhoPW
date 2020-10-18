package br.com.pw.gof.service;

import java.util.List;

import br.com.pw.gof.common.dto.EntityDto;
import br.com.pw.gof.common.exception.BusinessException;

public interface IManterAlunoService {
	public EntityDto save(EntityDto entity) throws BusinessException;
	public EntityDto update(EntityDto entity) throws BusinessException;
	public void delete(Integer id) throws BusinessException;
	public EntityDto findById(Integer id) throws BusinessException;
	public List<EntityDto> findAll() throws BusinessException;
}
