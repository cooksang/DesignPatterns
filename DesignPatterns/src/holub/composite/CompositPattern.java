package holub.composite;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class CompositPattern {
	abstract class Element{
		private Rectangle position;
		
		public Element(Rectangle position){
			this.position = position;
		}
		
		protected void prepare(Graphics surface){
			
		}
		
		public abstract void renderTo(Graphics surface);
	}
	
	class Form extends Element{

		private Collection subelements = new ArrayList();
		
		public Form(Rectangle position) {
			super(position);
		}
		
		public void add(Element subelement){
			subelements.add(subelement);
		}
		
		public void renderTo(Graphics surface){
			prepare(surface);
			Iterator i = subelements.iterator();
			
			while (i.hasNext()) {
				((Element)i.next()).renderTo(surface);
			}
		}
	}
	
	class StaticText extends Element{
		
		private String text;
		public StaticText(Rectangle position, String text){
			super(position);
			this.text = text;
		}
		@Override
		public void renderTo(Graphics surface) {
			prepare(surface);
			//surface.drawText(text);
			
		}
	}
}
