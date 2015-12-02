package moviesoffline;






import model.MovieManager;
import dto.WatchList;



public class Test {

	public static void main(String[] args) {
		
		
				
		MovieManager mm=new MovieManager ();
		
		
		WatchList watchList=new WatchList();
		watchList.setMovie_id("tt1006");
		watchList.setUser_Id((long) 3);
		watchList.setStatus("watched");
		watchList.setModifiedDate("2015/12/1");;
		System.out.print(mm.addWatchList(watchList));

	}

}
