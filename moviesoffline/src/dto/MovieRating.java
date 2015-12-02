package dto;

public class MovieRating {
	
	
	private Long mv_rating_id;
	private String rating_simbol;
	private String description;
	public MovieRating() {
		mv_rating_id=(long) 0;
		rating_simbol="";
		description="";
	}
	public Long getMv_rating_id() {
		return mv_rating_id;
	}
	public void setMv_rating_id(Long mv_rating_id) {
		this.mv_rating_id = mv_rating_id;
	}
	public String getRating_simbol() {
		return rating_simbol;
	}
	public void setRating_simbol(String rating_simbol) {
		this.rating_simbol = rating_simbol;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
