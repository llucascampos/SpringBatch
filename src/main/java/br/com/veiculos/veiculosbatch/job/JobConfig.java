package br.com.veiculos.veiculosbatch.job;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.veiculos.veiculosbatch.listener.JobListener;
import br.com.veiculos.veiculosbatch.models.Veiculo;
import br.com.veiculos.veiculosbatch.processors.VeiculoProcessor;
import br.com.veiculos.veiculosbatch.readers.VeiculoReader;
import br.com.veiculos.veiculosbatch.repository.VeiculoRepository;
import br.com.veiculos.veiculosbatch.writers.VeiculoWriter;

@Configuration
@EnableBatchProcessing
public class JobConfig {
	
	 @Autowired
	 private  JobBuilderFactory jobBuilderFactory;

	 @Autowired
	 private  StepBuilderFactory stepBuilderFactory;
	 
//	 public JobConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
//			this.jobBuilderFactory = jobBuilderFactory;
//			this.stepBuilderFactory = stepBuilderFactory;
//	 }
	 
	 @Autowired
	 VeiculoRepository veiculoRep;
	 
	 @Bean
	 ItemReader<Veiculo> read() {
		 return new VeiculoReader();
	 }
	 
	 @Bean
	 ItemProcessor processor(){
		 
		 return  new VeiculoProcessor();
	 }
	 
	 @Bean 
	 ItemWriter<List<Veiculo>> writer() {
		 return new VeiculoWriter();
	 }
	 
	 @Bean
	 public Step stepVeiculo() {
		 return stepBuilderFactory.get("stepVeiculo")
				 .<Veiculo, List<Veiculo>>chunk(1)
				 .reader(read())
				 .processor(processor())
				 .writer(writer())
				 .build();
	 }
	 
	 @Bean
	 public Job job(JobListener listener) {
		 return jobBuilderFactory.get("job")
				 .incrementer(new RunIdIncrementer())
				 .listener(listener)
				 .flow(stepVeiculo())
				 .end()
				 .build();
	 }


}
