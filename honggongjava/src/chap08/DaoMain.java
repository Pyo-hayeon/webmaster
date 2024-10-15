package chap08;

public class DaoMain {
	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		if(dao instanceof OracleDao) {
			OracleDao ocd = (OracleDao) dao;
			ocd.soLomethod();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
		
		
		
		DataAccessObject dao;
		dao = new OracleDao();
		dao.insert();
		
		if(dao instanceof OracleDao) {
			OracleDao ocd = (OracleDao) dao;
			ocd.soLomethod();
		}
		System.out.println();
		
		dao = new MySqlDao();
		dao.delete();

	}

}
