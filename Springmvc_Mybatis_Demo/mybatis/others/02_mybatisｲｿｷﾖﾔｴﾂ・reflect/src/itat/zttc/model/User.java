package itat.zttc.model;

public class User {
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String show(String str) {
		return str+" [id=" + id + ", name=" + name + "]";
	}
	
	public static void say(String hello,String world) {
		System.out.println(hello+",huhu,"+world);
	}
	
	
}
