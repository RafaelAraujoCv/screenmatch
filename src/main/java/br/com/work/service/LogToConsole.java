package br.com.work.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import ch.qos.logback.classic.Logger;

@Slf4j
public class LogToConsole implements JavaDelegate {

	@Autowired
    private Logger log;
	
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Logging to console in bpmn flow.");
    }
}