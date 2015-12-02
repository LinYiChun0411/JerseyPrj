package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import configuration.DbConfig;
import dto.Movie;

public class MovieDAO {
	public int createMovie(DbConfig dbLink,Movie movie){
		
		int flag=-1000;
		String sql="INSERT INTO movie(movie_id, title, genre_id, age_rating, releaseDate, storyline)"
				+" VALUES(?,?,?,?,?,?)";				
		try {
			dbLink.StartConnection();
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection()
					.prepareStatement(sql);
			ps.setString(1, movie.getMovie_id());
			ps.setString(2, movie.getTitle());
			ps.setLong(3, movie.getGenre_id());
			ps.setLong(4, movie.getAge_rating());
			ps.setString(5, movie.getReleaseDate());
			ps.setString(6, movie.getStoryline());			
			flag=ps.executeUpdate();//success return 1		
	       // ResultSet rs = ps.getGeneratedKeys();			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}
		return flag;
	}
		
	public ArrayList<Movie> getAllMovie(DbConfig dbLink) {
		ArrayList<Movie> movieData = new ArrayList<Movie>();			
		try {
			String sql = "";			
			// start the connection first
			dbLink.StartConnection();
			
			sql = "SELECT * FROM movie";
					
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Movie tmpMovie = new Movie();
				tmpMovie.setMovie_id(rs.getString("movie_id"));
				tmpMovie.setTitle(rs.getString("title"));
				tmpMovie.setGenre_id(rs.getLong("genre_id"));;
				tmpMovie.setAge_rating(rs.getLong("age_rating"));
				tmpMovie.setReleaseDate(rs.getString("releaseDate"));
				tmpMovie.setStoryline(rs.getString("storyline"));
				movieData.add(tmpMovie);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}
		
		return movieData;
	}
	
	
	public Movie getMovie(DbConfig dbLink,String id){
		Movie movie=null;
		try {
			String sql = "";			
			dbLink.StartConnection();
								
			sql = "SELECT *"
					+ " FROM movie"
					+" WHERE movie_id =?";
					
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection().prepareStatement(sql);
			ps.setString(1, id);			
			
			ResultSet rs = ps.executeQuery();			
				rs.next();
				movie = new Movie();
				movie.setMovie_id(rs.getString("movie_id"));
				movie.setGenre_id(rs.getLong("genre_id"));
				movie.setAge_rating(rs.getLong("age_rating"));
				movie.setReleaseDate(rs.getString("releaseDate"));
				movie.setStoryline(rs.getString("storyline"));
				movie.setTitle(rs.getString("title"));
				
				
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}		
		return movie;
	}
	
	public ArrayList<Movie> getMovies(DbConfig dbLink,String id,String title){					
		ArrayList<Movie> movieData = new ArrayList<Movie>();		
		try {
			String sql = "";
			dbLink.StartConnection();
			sql = "SELECT * FROM movie WHERE movie_id =? OR title LIKE ?";			
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection().prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, "%"+title+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Movie tmpMovie = new Movie();
				tmpMovie.setMovie_id(rs.getString("movie_id"));
				tmpMovie.setTitle(rs.getString("title"));
				tmpMovie.setGenre_id(rs.getLong("genre_id"));;
				tmpMovie.setAge_rating(rs.getLong("age_rating"));
				tmpMovie.setReleaseDate(rs.getString("releaseDate"));
				tmpMovie.setStoryline(rs.getString("storyline"));
				movieData.add(tmpMovie);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}		
		return movieData;
	}
	public ArrayList<Movie> getMovies(DbConfig dbLink,Long genre_id){					
		ArrayList<Movie> movieData = new ArrayList<Movie>();		
		try {
			String sql = "";
			dbLink.StartConnection();
			sql = "SELECT * FROM movie WHERE genre_id =?";			
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection().prepareStatement(sql);
			ps.setLong(1, genre_id);						
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				Movie tmpMovie = new Movie();
				tmpMovie.setMovie_id(rs.getString("movie_id"));
				tmpMovie.setTitle(rs.getString("title"));
				tmpMovie.setGenre_id(rs.getLong("genre_id"));;
				tmpMovie.setAge_rating(rs.getLong("age_rating"));
				tmpMovie.setReleaseDate(rs.getString("releaseDate"));
				tmpMovie.setStoryline(rs.getString("storyline"));
				movieData.add(tmpMovie);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}		
		return movieData;
	}
	
	
}
