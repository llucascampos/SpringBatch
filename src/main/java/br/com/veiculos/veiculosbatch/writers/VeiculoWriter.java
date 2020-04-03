package br.com.veiculos.veiculosbatch.writers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import br.com.veiculos.veiculosbatch.models.Veiculo;

public class VeiculoWriter implements ItemWriter<List<Veiculo>> {
	
	private static final Logger log = LoggerFactory.getLogger(VeiculoWriter.class);
	private FlatFileItemWriter<Veiculo> writer;
	private Resource outPut;
	private StepExecution stepExcecution;
	private String exportFilePath = "C:\\Users\\lucas\\Desktop\\veiculos.csv";
	
	public VeiculoWriter() {
		
	}
	
	@PostConstruct
	public void postConstruct() {
		this.writer = new FlatFileItemWriter<Veiculo>();
		outPut = new FileSystemResource("veiculos.csv");
		try {
			this.writer.setEncoding("ISO-8859-1");
			this.writer.setLineAggregator(lineAggregator());
			this.writer.setLineSeparator(System.lineSeparator());
			this.writer.setAppendAllowed(true);
			this.writer.setHeaderCallback(new FileHeaderWriter());
	        this.writer.setResource(new FileSystemResource(exportFilePath));
			this.writer.setShouldDeleteIfEmpty(true);
		}catch(Exception e) {
			log.info(e.getMessage());
		}
	}

	@Override
	public void write(List<? extends List<Veiculo>> items) throws Exception {
		writer.open(this.stepExcecution.getExecutionContext());
		if(items != null && items.size() > 0) {
		  for(List<Veiculo> item: items) {
			  if(item.size() > 0 ) {
				  writer.write(item);
			  }
		  }
	  }
	}
	
	@BeforeStep
	public void beforeStep(StepExecution step) {
		this.stepExcecution = step;
	}
	
	 private LineAggregator<Veiculo> lineAggregator() {
	        DelimitedLineAggregator<Veiculo> lineAggregator = new DelimitedLineAggregator<>();
	        lineAggregator.setDelimiter(";");
	 
	        FieldExtractor<Veiculo> fieldExtractor = createFieldExtractor();
	        lineAggregator.setFieldExtractor(fieldExtractor);
	 
	        return lineAggregator;
	    }
	 
	 private FieldExtractor<Veiculo> createFieldExtractor() {
	        BeanWrapperFieldExtractor<Veiculo> extractor = new BeanWrapperFieldExtractor<>();
	        extractor.setNames(new String[] {"id", 
	        								"categoria", 
	        								"marca", 
	        								"modelo", 
	        								"ano_fabricacao", 
	        								"ano_modelo", 
	        								"chassi", 
	        								"valor", 
	        								"placa", 
	        								"id_proprietario", 
	        								"id_cliente_vinculado", 
	        								"id_operacao", 
	        								"id_acao", 
	        								"data_acao"});
	        return extractor;
	
	    }

}
