package br.com.veiculos.veiculosbatch.processors;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import br.com.veiculos.veiculosbatch.models.Veiculo;

public class VeiculoProcessor implements ItemProcessor<Veiculo, List<Veiculo>>{
	
	private static final Logger log = LoggerFactory.getLogger(VeiculoProcessor.class);

	@Override
	public List<Veiculo> process(Veiculo veiculo) throws Exception {
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		Veiculo veiculo2 = new Veiculo();
		veiculo2 = veiculo;
		double valor = veiculo.getValor() * 2;
		if(veiculo.getValor() < 10000) {
			veiculo2.setValor(valor);
		}

		System.out.println("Processando veiuculo" + veiculo.getId());
		veiculos.add(veiculo2);
		return veiculos;
	}

}
