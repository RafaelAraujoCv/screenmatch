package br.com.work.service;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import camundajar.impl.scala.collection.immutable.List;
import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyCamundaService {
    
    @Autowired
    private FormService formService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;
    
    @Autowired
    private Logger log;
    
    public List<ProcessInstance> getRunningProcessInstanceList(){
        try {
            List<ProcessInstance> runningProcessList = (List<ProcessInstance>) runtimeService.createProcessInstanceQuery().active().list();
            log.info("Running process list count is {}", runningProcessList.size());
            return runningProcessList;
        }catch (Exception e){
            log.error("Failed to get running process instance list.", e);
            return null;
        }
    }
    public ProcessInstance startProcessInstanceByKey(String key){
        try {
            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
            log.info("New process instance initiated. Process instance id is {}", processInstance.getId());
            return processInstance;
        }catch (Exception e){
            log.error("Failed to start process instance.", e);
            return null;
        }
    }
}
