package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import configuration.DbConfig;
import dto.WatchList;
public class WatchlistDAO {
public int addWatchList(DbConfig dbLink,WatchList watchList){
		
		int flag=-1000;
		String sql="INSERT INTO watchlist(user_id, movie_id,status, modifiedDate)"
				+" VALUES(?,?,?,?)";				
		try {
			dbLink.StartConnection();
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection()
					.prepareStatement(sql);
			ps.setLong(1, watchList.getUser_Id());
			ps.setString(2, watchList.getMovie_id());
			ps.setString(3, watchList.getStatus());
			ps.setString(4, watchList.getModifiedDate());
			
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
	
	
	public ArrayList<WatchList> getAllWatchList(DbConfig dbLink) {
		ArrayList<WatchList> watchlistData = new ArrayList<WatchList>();			
		try {
			String sql = "";			
			dbLink.StartConnection();			
			sql = "SELECT watchlist.user_Id,username,watchlist.movie_id,watchlist.status,watchlist.modifiedDate,movie.title FROM watchlist"
				+ " INNER JOIN movie "
				+ "ON watchlist.movie_id=movie.movie_id"
				+ " INNER JOIN member "
				+ "ON watchlist.user_id=member.user_id";					
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				WatchList tmpWatchList = new WatchList();
				tmpWatchList.setUser_Id(rs.getLong("user_Id"));
				tmpWatchList.setUsername(rs.getString("username"));
				tmpWatchList.setMovie_id(rs.getString("movie_id"));
				tmpWatchList.setStatus(rs.getString("status"));
				tmpWatchList.setModifiedDate(rs.getString("modifiedDate"));
				tmpWatchList.setTitle(rs.getString("title"));
				watchlistData.add(tmpWatchList);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}
		
		return watchlistData;
	}
	public ArrayList<WatchList> getWatchList(DbConfig dbLink ,Long user_id) {
		ArrayList<WatchList> watchlistData = new ArrayList<WatchList>();			
		try {
			String sql = "";			
			dbLink.StartConnection();			
			sql = "SELECT watchlist.user_Id,username,watchlist.movie_id,watchlist.status,watchlist.modifiedDate,movie.title FROM watchlist"
				+ " INNER JOIN movie "
				+ "ON watchlist.movie_id=movie.movie_id"
				+ " INNER JOIN member "
				+ "ON watchlist.user_id=member.user_id"
				+" WHERE watchlist.user_id=?";					
			PreparedStatement ps = (PreparedStatement) dbLink.getDbConnection().prepareStatement(sql);
			ps.setLong(1, user_id);
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				WatchList tmpWatchList = new WatchList();
				tmpWatchList.setUser_Id(rs.getLong("user_Id"));
				tmpWatchList.setUsername(rs.getString("username"));
				tmpWatchList.setMovie_id(rs.getString("movie_id"));
				tmpWatchList.setStatus(rs.getString("status"));
				tmpWatchList.setModifiedDate(rs.getString("modifiedDate"));
				tmpWatchList.setTitle(rs.getString("title"));
				watchlistData.add(tmpWatchList);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbLink.StopConnection();
		}
		
		return watchlistData;
	}
	
	
}
