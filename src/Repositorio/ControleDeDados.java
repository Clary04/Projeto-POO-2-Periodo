package Repositorio;

import java.util.ArrayList;

public interface ControleDeDados<T> {

	public void Insert(T classe);
	
	public void Update(String sql);
	
	public void Delete(String sql);
	
	public ArrayList List(String sql);
	
	
}