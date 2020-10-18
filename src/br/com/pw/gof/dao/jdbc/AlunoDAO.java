package br.com.pw.gof.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pw.gof.common.dto.Aluno;
import br.com.pw.gof.common.dto.EntityDto;
import br.com.pw.gof.common.exception.EnvironmentException;
import br.com.pw.gof.common.exception.SystemException;
import br.com.pw.gof.dao.IAlunoDAO;

public class AlunoDAO extends JdbcConnection implements IAlunoDAO{
	
	@Override
	public EntityDto save(EntityDto entity) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO ALUNO (ALUN_ID, ALUN_NM, ALUN_DT_NASC, ALUN_N_PREV, ALUN_ST, ALUN_DT_GRAD)" + 
                   " VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)");
		
		try {
			Connection con = getConnection();
			Aluno aluno = (Aluno)entity;
			
			PreparedStatement statement = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, entity.getNome());
			statement.setDate(2, entity.getDt_nasc());
			statement.setString(3, entity.getN_prev());
			statement.setString(4, entity.getStatus());
			statement.setDate(5, aluno.getDt_grad());
			statement.executeUpdate();
			
			ResultSet rs = statement.getGeneratedKeys();
			Integer lastId = 0;
			if (rs.next()) {
			    lastId = rs.getInt(1);
			}
			entity.setId(lastId);
			
			statement.close();
	       
		} catch (SQLException e) {
            throw SystemException.dataBase(e);
        } 
		return entity;
	}

	@Override
	public EntityDto update(EntityDto entity) throws EnvironmentException {
		String sql = "UPDATE ALUNO SET ALUN_NM=?, ALUN_DT_NASC=?, ALUN_N_PREV=?, ALUN_ST=?, ALUN_DT_GRAD=?" + 
                " WHERE ALUN_ID=?";
   
		try {
			Connection con = getConnection();
			Aluno aluno = (Aluno)entity;
			
			PreparedStatement statement = con.prepareStatement(sql.toString());
	   	
			statement.setString(1, entity.getNome());
			statement.setDate(2, entity.getDt_nasc());
			statement.setString(3, entity.getN_prev());
			statement.setString(4, entity.getStatus());
			statement.setDate(5, aluno.getDt_grad());
			statement.setInt(6, entity.getId());
			statement.executeUpdate();
			statement.close();
	       
	   	} catch (SQLException e) {
	   		throw new EnvironmentException(e.getMessage());
	   	} 
	   	return entity;
	}

	@Override
	public void delete(Integer id) throws EnvironmentException {
		String sql = "DELETE FROM ALUNO WHERE ALUN_ID=?";
        
        try {
    		Connection con = getConnection();
        	PreparedStatement statement = con.prepareStatement(sql.toString());
        	statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            
        } catch (SQLException e) {
            throw new EnvironmentException(e.getMessage());
        }
	}

	@Override
	public EntityDto findById(Integer id) throws EnvironmentException {
		Aluno aluno = new Aluno();
		
	    String sql = "SELECT ALUN_ID, ALUN_NM, ALUN_DT_NASC, ALUN_N_PREV, ALUN_ST, ALUN_DT_GRAD FROM ALUNO";
	    sql += " WHERE ALUN_ID=?";
	    
	    try {
			Connection con = getConnection();
	    	PreparedStatement statement = con.prepareStatement(sql.toString());
	    	statement.setInt(1, id);
	    	ResultSet result = statement.executeQuery();
	        
	    	while(result.next()){
	        		aluno = new Aluno();
	        		aluno.setId(new Integer(result.getInt(1)));
	        		aluno.setNome(result.getString(2));
	        		aluno.setDt_nasc(result.getDate(3));
	        		aluno.setN_prev(result.getString(4));
	        		aluno.setStatus(result.getString(5));
	        		aluno.setDt_nasc(result.getDate(6));
	            }
	        result.close();
	        statement.close();
	    } catch (SQLException e) {
            throw new EnvironmentException(e.getMessage());
        } 
	              
	    return aluno;
	}

	@Override
	public List<EntityDto> findAll() throws EnvironmentException {
		List<EntityDto> lista = new ArrayList<EntityDto>();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT ALUN_ID, ALUN_NM, ALUN_DT_NASC, ALUN_N_PREV, ALUN_ST, ALUN_DT_GRAD FROM ALUNO");
		
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql.toString());
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(new Integer(result.getInt(1)));
        		aluno.setNome(result.getString(2));
        		aluno.setDt_nasc(result.getDate(3));
        		aluno.setN_prev(result.getString(4));
        		aluno.setStatus(result.getString(5));
        		aluno.setDt_nasc(result.getDate(6));
				lista.add(aluno);
			}
			
		} catch (SQLException e) {
            throw new EnvironmentException(e.getMessage());
        } 
		
		return lista;
	}

}
