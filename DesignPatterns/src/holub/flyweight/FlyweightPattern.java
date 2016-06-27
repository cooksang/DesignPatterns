package holub.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern {
	abstract class XMLElement{
		static Map cache = new HashMap();
		public static XMLElement create(String name){
			name = name.intern();
			XMLElement exists = (XMLElement)(cache.get(name));
			
			if(exists = null){
				exists = new ConcreteXMLElement(name);
				cache.put(name, exists);
			}
			return exists;
		}
		private XMLElement{}
		
		abstract void operation(XMLElement parent)
	}
}
