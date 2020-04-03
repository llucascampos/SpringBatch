package br.com.veiculos.veiculosbatch.readers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.veiculos.veiculosbatch.models.Veiculo;
import br.com.veiculos.veiculosbatch.repository.VeiculoRepository;

public class VeiculoReader implements ItemReader<Veiculo>{
	
	private static final Logger log = LoggerFactory.getLogger(VeiculoReader.class);
	
		
	private int index;
	private List<Veiculo> veiculos;
	
	@Autowired
	VeiculoRepository veiculoRep;
	
	@PostConstruct
	public void postConstructor() {
		this.veiculos = veiculoRep.todosVeiculos();
		this.index = 0;
		log.info("contruindo lista de veiculos");
	}

	@Override
	public Veiculo read() throws Exception{
		Veiculo veiculo = null;
		
		if(index < veiculos.size()) {
			veiculo = veiculos.get(index);
			index ++;
			
		}
		return veiculo;
	}

}
