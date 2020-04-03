package br.com.veiculos.veiculosbatch.writers;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

public class FileHeaderWriter implements FlatFileHeaderCallback {

	@Override
	public void writeHeader(Writer writer) throws IOException {
		writer.write(composeHeader());
				
	}
	
	private String composeHeader() {
		return "id; " +
				"categoria; " +
				"marca; " +
				"modelo; " +
				"ano_fabricacao; " +
				"ano_modelo; " +
				"chassi; " +
				"valor; " +
				"placa; " +
				"id_proprietario;" +
				"id_cliente_vinculado; " +
				"id_operacao; " +
				"id_acao; " +
				"data_acao; ";
	}

}
