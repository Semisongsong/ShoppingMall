package DB;

public interface DAOInterface {
	
	Boolean Insert(Object DTO);
	Boolean Select(Object DTO);
	Boolean Edit(Object DTO);
	Boolean Delete(Object DTO);
	

}

