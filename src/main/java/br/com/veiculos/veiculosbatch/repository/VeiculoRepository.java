package br.com.veiculos.veiculosbatch.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.veiculos.veiculosbatch.models.Veiculo;

@Repository
public class VeiculoRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	private RowMapper<Veiculo> map(){
		RowMapper<Veiculo> map = (rs, row) -> {
			Veiculo veiculo = new Veiculo();
			 
	        veiculo.setId(rs.getInt("id"));
	        veiculo.setCategoria(rs.getString("categoria"));
	        veiculo.setMarca(rs.getString("marca"));
	        veiculo.setModelo(rs.getString("modelo"));
	        veiculo.setAno_fabricacao(rs.getInt("ano_fabricacao"));
	        veiculo.setAno_modelo(rs.getInt("ano_modelo"));
	        veiculo.setChassi(rs.getString("chassi"));
	        veiculo.setValor(rs.getInt("valor"));
	        veiculo.setPlaca(rs.getString("placa"));
	        veiculo.setId_proprietario(rs.getInt("id_proprietario"));
	        veiculo.setId_cliente_vinculado(rs.getInt("id_cliente_vinculado"));
	        veiculo.setId_operacao(rs.getInt("id_operacao"));
	       
			return veiculo;
			
		};
		return map;
	}
	
	public static final String SELECT_VEICULO = "select * from veiculo";
	public List<Veiculo> todosVeiculos() {
		return (List<Veiculo>) jdbcTemplate.query(SELECT_VEICULO, map());
	}
	
 

}
