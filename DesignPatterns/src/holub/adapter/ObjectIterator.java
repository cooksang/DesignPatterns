package holub.adapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;

public class ObjectIterator extends ObjectInputStream implements Iterator{

	private boolean atEndOfFile = false;
	
	public ObjectIterator(InputStream src) throws IOException{
		super(src);
	}

	public boolean hasNext() {
		return atEndOfFile == false;
	}

	public Object next() {
		try {
			return readObject();
		} catch (Exception e) {
			atEndOfFile = true;
			return null;
		}
	}
	
	public void remove(){
		throw new UnsupportedOperationException();
	}
}

class WrappedObjectIterator implements Iterator{
	
	private boolean atEndOfFile = false;
	private final ObjectInputStream in;
	
	public WrappedObjectIterator(ObjectInputStream in){
		this.in = in;
	}

	@Override
	public boolean hasNext() {
		
		return atEndOfFile == false;
	}

	@Override
	public Object next() {
		try {
			return in.readObject();
		} catch (Exception e) {
			return null;
		}
	}
	public void remove(){
		throw new UnsupportedOperationException();
	}
}