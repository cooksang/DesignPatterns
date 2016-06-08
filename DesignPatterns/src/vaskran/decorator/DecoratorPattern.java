package vaskran.decorator;

public class DecoratorPattern {

	abstract class Component{
		
		public abstract void doJob();
	}
	class ConcreteComponent extends Component{

		@Override
		public void doJob() {
			System.out.println("I am from Concrete omponent-I am closed for modification.");
		}
	}
}
