package com.kardnji.jsonRepo;

public interface CrudInterface<E, SEARCH_FIELD> {

	void save(E e);
		
	void delete(E e);
	
	void update(E e);
	
	E read(SEARCH_FIELD sf);

	
}
