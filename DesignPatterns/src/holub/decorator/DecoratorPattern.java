package holub.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DecoratorPattern {
	public class BlockingList implements List{
		private final List component;
		
		public BlockingList(List component) {
			this.component = component;
		}
		
		private Boolean noLongerEmpty(){
			try {
				while (component.size() == 0)
					wait();
				return true;
			} catch (InterruptedException e) {
				return false;
			}
		}
		
		synchronized public boolean add(Object o){
			boolean toReturn = component.add(o);
			notifyAll();
			return toReturn;
		}
		
		synchronized public boolean remove(Object o){
			if(noLongerEmpty())
				return component.remove(o);
			return false;
		}
		
		synchronized public int size(){
			return component.size();
		}

		@Override
		public void add(int index, Object element) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean addAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int index, Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object get(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean removeAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object set(int index, Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray(Object[] a) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		JComponent widget = new JTextArea(80, 200);
		widget = new JScrollPane(widget);
		JFrame frame = new JFrame();
		frame.getContentPane().add(widget);
		
		InputStream in = new FileInputStream("C:/x.txt");
		in = new BufferedInputStream(in);
		in = new PushbackInputStream(in);
	}
}