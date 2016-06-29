package vaskaran.proxy;

public class ProxyPattern {
	public static abstract class Subject{
		public abstract void doSomeWork();
	}
	
	public static class ConcreteSubject extends Subject{

		@Override
		public void doSomeWork() {
			System.out.println("I am from concrete subject");
		}
	}
	
	public static class Proxy extends Subject{
		
		ConcreteSubject cs;

		@Override
		public void doSomeWork() {
			System.out.println("Proxy call happening now");
			
			if(cs == null){
				cs = new ConcreteSubject();
			}
			cs.doSomeWork();
		}
	}
	
	public static void main(String[] args) {
		Proxy px = new Proxy();
		px.doSomeWork();
	}
}
