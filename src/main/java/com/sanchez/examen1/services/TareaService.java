package com.sanchez.examen1.services;

import java.util.List;

import com.sanchez.examen1.model.TareaModel;

public interface TareaService {
	public List<TareaModel> getAll();
	
    public TareaModel getById(Integer id);
    
    public int create(TareaModel obj);
    
    public int update(TareaModel obj);
    
    public void delete(int id);   
}
