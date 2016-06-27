package vaskaran.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern {

	static interface IRobot{
		void Print();
	}
	
	static class SmallRobot implements IRobot{
		public void Print(){
			System.out.println("This is a Small Robot");
		}
	}
	
	static class LargeRobot implements IRobot{

		@Override
		public void Print() {
			System.out.println("I am a Large Robot");
		}
		
	}
	
	static class RobotFactory{
		Map<String, IRobot> shapes = new HashMap<String, IRobot>();
		
		public int TotalObjectsCreated(){
			return shapes.size();
		}
		
		public IRobot GetRobotFromFactory(String RobotCategory) throws Exception{
			IRobot robotCategory = null;
			if(shapes.containsKey(RobotCategory)){
				robotCategory = shapes.get(RobotCategory);
			} else{
				switch (RobotCategory) {
				case "small":
					System.out.println("We do not have Small Robot. So we are creating a Small Robot now.");
					robotCategory = new SmallRobot();
					shapes.put("small", robotCategory);
					break;
				case "large":
					System.out.println("We do not have Large Robot. So we are creating a Large Robot now.");
					robotCategory = new LargeRobot();
					shapes.put("large", robotCategory);
					break;
				default:
					throw new Exception(" Robot factory can create only small and large shapes.");
				}
			}
			return robotCategory;
		}
	}
	
	public static void main(String[] args) throws Exception{
		RobotFactory myfactory = new RobotFactory();
		System.out.println("\n***Flyweight Pattern Example***\n");
		
		IRobot shape = myfactory.GetRobotFromFactory("small");
		shape.Print();
		
		for (int i = 0; i < 2; i++){
			shape = myfactory.GetRobotFromFactory("small");
			shape.Print();
		}
		
		int NumOfDistinctRobots = myfactory.TotalObjectsCreated();
		System.out.println("\nDistinct Robot objects created till now=" + NumOfDistinctRobots);
		
		for (int i = 0; i < 5; i++){
			shape = myfactory.GetRobotFromFactory("large");
			shape.Print();
		}
		
		NumOfDistinctRobots = myfactory.TotalObjectsCreated();
		System.out.println("\n Finally no of Distinc Robot objects created:" + NumOfDistinctRobots);
		
	}
}
