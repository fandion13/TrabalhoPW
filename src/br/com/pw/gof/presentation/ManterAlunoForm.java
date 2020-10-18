package br.com.pw.gof.presentation;

import java.sql.Date;
import java.util.List;

import br.com.pw.gof.common.dto.EntityDto;
import br.com.pw.gof.common.dto.Aluno;
import br.com.pw.gof.common.exception.BusinessException;
import br.com.pw.gof.service.IManterAlunoService;
import br.com.pw.gof.service.core.ManterAlunoService;

public class ManterAlunoForm {

	public static void main(String[] args) throws BusinessException {
		IManterAlunoService service =  new ManterAlunoService();
		
		Aluno alunoIncluir = new Aluno();
		alunoIncluir.setNome("Antonio");
		alunoIncluir.setDt_nasc(new Date(2020-10-10));
		alunoIncluir.setN_prev("222222");
		alunoIncluir.setStatus("I");
		alunoIncluir.setDt_grad(new Date(2020-10-10));
		
		Aluno alunoAlterar = new Aluno();
		alunoAlterar.setNome("Duda");
		alunoAlterar.setDt_nasc(new Date(2020-10-10));
		alunoAlterar.setN_prev("222222");
		alunoAlterar.setStatus("I");
		alunoAlterar.setDt_grad(new Date(2020-10-10));
		alunoAlterar.setId(1);
		
		service.save(alunoIncluir);
		service.delete(4);
		service.update(alunoAlterar);
		
		EntityDto entityId = service.findById(1);
		Aluno alunoId = (Aluno)entityId;
		
		List<EntityDto> lista =  service.findAll();
		
		System.out.println("ALUNOS:\n");
		
		if(lista!=null) {
			for (EntityDto entity : lista) {
				Aluno aluno = (Aluno)entity;
				System.out.println(entity.getId() + " - " + aluno.getNome());
			}
		}else {
			System.out.println("Nenhum registro foi encontrado!");
		}
		
		System.out.println(entityId.getId() + " - " + alunoId.getNome());
	}

}
