package models;

public class Movie {
	
	private String movie_id;
	private String title;
	private long genre_id;
	private long age_rating;
	private String releaseDate;
	private String storyline;
	
	public Movie() {
		movie_id="N";
		title="";
		genre_id=0;
		age_rating=0;
		releaseDate="N";
		storyline="N";		
		
	}
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(long genre_id) {
		this.genre_id = genre_id;
	}
	public long getAge_rating() {
		return age_rating;
	}
	public void setAge_rating(long age_rating) {
		this.age_rating = age_rating;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getStoryline() {
		return storyline;
	}
	public void setStoryline(String storyline) {
		this.storyline = storyline;
	}
	
	

}
