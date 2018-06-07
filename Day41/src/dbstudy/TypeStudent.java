package dbstudy;
// list 형의 배열을 한꺼번에 정리하기 위한 껍데기 , 탄력성 
public class TypeStudent { //DTO DBTransforterObject
	private String id;
	private String name;
	private int score;
	private String rank;
	
	
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String toString() {
		return this.id + "\t" + this.name + "\t" + this.score;
	}
	
	public TypeStudent() {
		
	}
	
	public TypeStudent(String id, String name, int score ,String rank) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.rank = rank;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
