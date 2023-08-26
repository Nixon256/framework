package org.base;

public class A {
	
	public String getProjectPath() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		return path;}
	public static void main(String[] args) {
		A a = new A();
		a.getProjectPath();
	}

}
