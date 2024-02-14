package br.com.work;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.work.service.MyCamundaService;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableProcessApplication
public class Screenmatch {
	
	@Autowired
	private MyCamundaService myCamundaService;

	public static void main(String[] args) {
		SpringApplication.run(Screenmatch.class, args);
	}
	
	@PostConstruct
	  private void processPostDeploy() {
	    myCamundaService.getRunningProcessInstanceList();
	  }

}
