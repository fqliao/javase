package treeSet;

import java.util.Objects;
/**
 * Item类，实现Comparable接口
 * 覆盖一下方法：
 * 1 toString
 * 2 equals
 * 3 hashCode
 * 4 compareTo
 * @author lfq
 *
 */
public class Item implements Comparable<Item> {
	
	private String description;
	private int partNumber;
	
	public Item(String description,int partNumber)
	{
		this.description = description;
		this.partNumber = partNumber;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public String toString()
	{
		return "d="+description+", p="+partNumber+"";
	}
	
	public boolean equals(Object otherObject)
	{
		if(this == otherObject)return true;
		if(otherObject == null)return false;
		if(getClass() != otherObject.getClass()) return false;
		Item other = (Item)otherObject;
		return Objects.equals(this.description, other.description) && partNumber == other.partNumber;
	}
	
	public int hashCode()
	{
		return Objects.hash(description,partNumber);
	}
	
	@Override
	public int compareTo(Item other) 
	{	//以partNumber作为比较规则
		return Integer.compare(this.partNumber, other.partNumber);
	}
	
}
