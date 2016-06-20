package vaskran.facade;

public  class FacadePattern {
	public static class RobotBody{
		public void CreateBody(){
			System.out.println("body creation done");
		}
	}
	
	public static class RobotColor{
		private String color;
		public void setColor(String color){
			this.color = color;
			System.out.println("color is set to : " + this.color);
		}
	}
	
	public static class RobotMetal{
		private String metal;
		
		public void setMetal(String metal){
			this.metal = metal;
			System.out.println("metal is set to : " + this.metal);
		}
	}
	
	public static class RobotFacade{
		RobotColor rc;
		RobotMetal rm;
		RobotBody rb;
		public RobotFacade(){
			rc = new RobotColor();
			rm = new RobotMetal();
			rb = new RobotBody();
		}
		
		public void constructRobot(String color, String metal){
			System.out.println("\ncreation of the robot start");
			rc.setColor(color);
			rm.setMetal(metal);
			rb.CreateBody();
			System.out.println("\nRobot creation end");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("facade pattern deom");
		RobotFacade rf1 = new RobotFacade();
		rf1.constructRobot("GREEN", "Iron");
		RobotFacade rf2 = new RobotFacade();
		rf2.constructRobot("BLUE", "Steel");
	}
}
