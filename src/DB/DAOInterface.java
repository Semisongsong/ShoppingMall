package DB;

public interface DAOInterface {
	
	Boolean Insert(Object DTO, String notice);
	Boolean Select(Object DTO);
	Boolean Edit(Object DTO);
	Boolean Delete(Object DTO);
	Boolean Insert();
	

}

