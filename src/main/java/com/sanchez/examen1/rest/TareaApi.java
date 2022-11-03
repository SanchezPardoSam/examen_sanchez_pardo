package com.sanchez.examen1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanchez.examen1.model.TareaModel;
import com.sanchez.examen1.services.TareaService;

@RestController
@RequestMapping("/api/tareas")
public class TareaApi {
	@Autowired
    private TareaService service;
	
    @GetMapping()
    public List<TareaModel> getAll(){
        return service.getAll();
    }
    
    @PostMapping("/get")
    public TareaModel getById(@RequestParam("id") Integer id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public int save(@RequestBody TareaModel obj){
        return service.create(obj);
    }

    @PostMapping("/update")
    public int update(@RequestBody TareaModel obj){
    	return service.update(obj);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam("id") Integer id) {
    	service.delete(id);
    }
}
