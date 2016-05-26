package vaskaran.adapter;

public interface IIntegerValue {
	public int getInteger();
}

class IntegerValue implements IIntegerValue{

	@Override
	public int getInteger() {
		return 5;
	}
	
}

class ClassAdapter extends IntegerValue{
	
	public int getInteger(){
		return 2 + super.getInteger();
	}
}

class ObjectAdapter{
	private IIntegerValue myInt;
	
	public ObjectAdapter(IIntegerValue myInt){
		this.myInt = myInt;
	}
	
	public int getInteger(){
		return 2 + this.myInt.getInteger();
	}
}

class ClassAndObjectAdapter{
	
	public static void main(String[] args) {
		
		ClassAdapter ca = new ClassAdapter();
		System.out.println("Class Adapter is returning : " + ca.getInteger());
		ObjectAdapter oa = new ObjectAdapter(new IntegerValue()); 
		System.out.println("Object Adapter is returning : " + oa.getInteger());
	}
}