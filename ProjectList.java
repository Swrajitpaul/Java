
public class ProjectList {
	
	private ProjectNode first = new ProjectNode(null);
	private ProjectNode last = first;
	private int length = 0;
	 
	/**
	 *    
	 * @return int returns the length of the list
	 */
	public int getLength() {
		return length;
	}
	 
	/**
	 * 
	 * @param d takes in a String and adds it after the other string
	 */
	public void append(String d) {
		ProjectNode n = new ProjectNode (d);
        last.next = n;
        last = n;
        length++;
	 
	} 
	
	/**
	 * 
	 * @param d takes in a String and adds it before the other string
	 */
	public void prepend(String d) {
		ProjectNode n = new ProjectNode (d);
        n.next = first.next;
        first.next = n;
        length++;
        if (length == 1)
            last = n;
	 
	} 
	    
	/**
	 * changes the item to String
	 */
	public String toString() {
		ProjectNode p = first.next;
	        
		String returnString = "";
	        
		while (p != null) {
	            
			returnString += p.data + " ";
	            
			p = p.next;
	        
		}
	        
		return returnString;
	    
	}
	public String[] printNodes () {  
		String[] list = new String[100]; 
		ProjectNode p;  
		p=first.next;  
		int i = 0;
		while (p != null) {   
			list[i++]= p.data;   
			p=p.next;  
		} 
		return list;
	} 
	 
	/**
	 * checks whether if the string is equal to another and returns a boolean
	 */
	public boolean equals(Object other) {
	        if (other == null || getClass() != other.getClass()
	                || length != ((ProjectList) other).length)
	            return false;
	 
	        ProjectNode nodeThis = first;
	        ProjectNode nodeOther = ((ProjectList) other).first;
	        while (nodeThis != null) {
	            if (nodeThis.data != nodeOther.data)
	                return false;
	 
	            nodeThis = nodeThis.next;
	            nodeOther = nodeOther.next;
	        } 
	 
	        return true;
	    } 
	 
	} 