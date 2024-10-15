package testdb.pack;

public class DbMain {

	public static void main(String[] args) {
		
		DbDao dd = new DbDao();
		dd.getOpenDb();
		dd.getCloseDb();
	}
}
