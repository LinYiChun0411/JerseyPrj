package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import configuration.DbConfig;
import dto.Genre;

public class GenreDAO {
	public ArrayList<Genre> getAllGenre(DbConfig dbLink) {
		ArrayList<Genre> genreData = new ArrayList<Genre>();
		
		try {
			String sql = "";					
			dbLink.StartConnection();
			
			sql = "SELECT * "
					+ " FROM genre ";
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Genre genre = new Genre();
				genre.setGenre_id(rs.getLong("genre_id"));
				genre.setGenre_name(rs.getString("genre_name"));
				genreData.add(genre);
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}
		
		return genreData;
	}
}
