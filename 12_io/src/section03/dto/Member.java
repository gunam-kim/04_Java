package section03.dto;

import java.io.Serializable;

/*
	Marker Interface
	: 어떤 역할이나 기능의 대상임을 표시하는 인터페이스
	
	Serializable Interface
	: 직렬화의 대상임을 명시하는 인터페이스
*/

public class Member implements Serializable {
	// The serializable class Member does not declare a static final serialVersionUID field of type long
	// serialVersionUID : 직렬화된 객체가 Member인지 확인하는 용도의 ID (식별번호)
	public static final long serialVersionUID = 123456789L;
	
	private String id;
	private String pw;
	private String name;
	
	public Member() {}

	public Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
}
