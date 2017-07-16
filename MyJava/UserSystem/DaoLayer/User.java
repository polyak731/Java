package DaoLayer;
import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String password;
	private int age;
	private String email;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[id="+id+" ,name="+name+", password="+password+", age="+age+", email="+email+"]";
	}

	public User(int id){
		this("");
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User(String name){
		this(name,"");
	}
	
	public User(String name,String password){
		this(name,password,0,"");
	}
	
	public User(String name, String password, int age, String email){
		this.name = name;
		this.password = password;
		this.age = age;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<0) throw new IllegalArgumentException("Incorrect age "+age);
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(!email.contains("@")) throw new IllegalArgumentException("Incorrect email: "+email);
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
