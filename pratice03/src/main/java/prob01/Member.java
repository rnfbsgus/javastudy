package prob01;

public class Member {
	String id;
	String name;
	int point;
	
	private void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
	
	private void setPoint(int point) {
		this.point = point;
	}
	
	int getPoint() {
		return point;
	}
	
	private void setId(String id) {
		this.id = id;
	}
	
	String getId() {
		return id;
	}
	
}