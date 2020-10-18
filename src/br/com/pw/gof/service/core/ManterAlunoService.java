package br.com.pw.gof.service.core;

import java.util.List;

import br.com.pw.gof.common.dto.EntityDto;
import br.com.pw.gof.common.exception.BusinessException;
import br.com.pw.gof.common.exception.EnvironmentException;
import br.com.pw.gof.dao.IAlunoDAO;
import br.com.pw.gof.dao.jdbc.AlunoDAO;
import br.com.pw.gof.service.IManterAlunoService;

public class ManterAlunoService implements IManterAlunoService{

	@Override
	public EntityDto save(EntityDto entity) throws BusinessException {
		IAlunoDAO alunoDAO = new AlunoDAO();
		try {
			if (entity == null) {
				throw new BusinessException("Campo aluno não pode ser vazio");
			}
			entity = alunoDAO.save(entity);
			return entity;
		} catch (EnvironmentException e) {
			throw new BusinessException(getErroBD());
		}
	}

	@Override
	public EntityDto update(EntityDto entity) throws BusinessException {
		IAlunoDAO alunoDAO = new AlunoDAO();
		try {
			if (entity == null) {
				throw new BusinessException("Campo aluno não pode ser vazio");
			}
			entity = alunoDAO.update(entity);
			return entity;
		} catch (EnvironmentException e) {
			throw new BusinessException(getErroBD());
		}
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		IAlunoDAO alunoDAO = new AlunoDAO();
		try {
			if (id == null) {
				throw new BusinessException("Campo id não pode ser vazio");
			}
			alunoDAO.delete(id);
		} catch (EnvironmentException e) {
			throw new BusinessException(getErroBD());
		}
	}

	@Override
	public EntityDto findById(Integer id) throws BusinessException {
		IAlunoDAO alunoDAO = new AlunoDAO();
		try {
			if (id == null) {
				throw new BusinessException("Campo matricula não pode ser vazio");
			}
			return alunoDAO.findById(id);
		} catch (EnvironmentException e) {
			throw new BusinessException(getErroBD());
		}
	}

	@Override
	public List<EntityDto> findAll() throws BusinessException {
		IAlunoDAO alunoDAO = new AlunoDAO();
		try {
			if (alunoDAO.findAll() == null || alunoDAO.findAll().isEmpty()) {
				throw new BusinessException("Nenhum aluno encontrado.");
			}
			return alunoDAO.findAll();
		} catch (EnvironmentException e) {
			throw new BusinessException(getErroBD());
		}
	}
	
	private String getErroBD() {
		return "Erro ao acessar a base de dados. Contate o administrador do sistema.";
	}
}
