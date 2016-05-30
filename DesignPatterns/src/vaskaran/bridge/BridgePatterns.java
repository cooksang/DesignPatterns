package vaskaran.bridge;

public class BridgePatterns {
	public static void main(String[] args) {
		System.out.println("**BRIDGE PATTERN**");
		System.out.println("\nColoring triangle:");
		IColor green = new GreenColor();
		Shape triangleShape = new Triangle(green);
		triangleShape.drawShape(20);
		triangleShape.modifyBorder(20, 3);
		
		System.out.println("\n\nColoring rectangle :");
		IColor red = new RedColor();
		
		Shape rectangleSHape = new Rectangle(red);
		rectangleSHape.drawShape(50);
		rectangleSHape.modifyBorder(50, 2);
	}
}

interface IColor{
	 void fillWithColor(int border);
}
class RedColor implements IColor{

	@Override
	public void fillWithColor(int border) {
		System.out.println("red color with " + border + " inch border");
	}
	 
}

class GreenColor implements IColor{

	@Override
	public void fillWithColor(int border) {
		System.out.println("green color with " + border + " inch border");
	}
	 
}

abstract class Shape{
	 protected IColor color;
	 protected Shape(IColor c){
		 this.color = c;
	 }
	 abstract void drawShape(int border);
	 abstract void modifyBorder(int border, int increment);
}

class Triangle extends Shape{
	 protected Triangle(IColor c){
		 super(c);
	 }

	@Override
	void drawShape(int border) {
		System.out.println("this triangle is colored with: ");
		color.fillWithColor(border);
	}

	@Override
	void modifyBorder(int border, int increment) {
		System.out.println("\nNow we are changing the border length " + increment + "times");
		border = border * increment;
		drawShape(border);
	}
	 
}

class Rectangle extends Shape{
	 public Rectangle(IColor c){
		 super(c);
	 }

	@Override
	void drawShape(int border) {
		System.out.println("this rectangle is colored with: ");
		color.fillWithColor(border);
	}

	@Override
	void modifyBorder(int border, int increment) {
		System.out.println("\nNow we are changing the border length " + increment + "times");
		border = border * increment;
		drawShape(border);
	}
}
