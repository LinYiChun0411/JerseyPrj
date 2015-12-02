package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import configuration.DbConfig;
import dto.MovieRating;

public class MovieRatingDAO {
	public ArrayList<MovieRating> getAllMovieRating(DbConfig dbLink) {
		ArrayList<MovieRating> movieRatingData = new ArrayList<MovieRating>();			
		try {
			String sql = "";			
			dbLink.StartConnection();			
			sql = "SELECT * FROM movie_rating";					
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				MovieRating tmpMovieRating = new MovieRating();
				tmpMovieRating.setMv_rating_id(rs.getLong("mv_rating_id"));
				tmpMovieRating.setRating_simbol(rs.getString("rating_simbol"));
				tmpMovieRating.setDescription(rs.getString("description"));
				movieRatingData.add(tmpMovieRating);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}
		
		return movieRatingData;
	}
}
