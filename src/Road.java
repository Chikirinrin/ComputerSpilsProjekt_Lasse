
/**
 * This class is used to create roads between cities.
 * One dimensional in the sense that there can be a road from city A to B,
 * but not necessarily from city B to A.
 *
 * @author Andreas Morgen & Tessa Broeders
 * @version 14/11/2017
 */
public class Road implements Comparable<Road>
{
    private City from; // The city the roads starts in
    private City to;   // The city the road ends in
    private int length;// The length of the road
    
    /**
     * Constructor for the Road class
     * 
     * @param from  The city the road starts in
     * @param to    The city the road ends in
     * @param length    The length of the road
     */
    public Road(City from, City to,int length){
        this.from = from;
        this.to = to;
        this.length = length;
    }
    
    /**
     * Method for getting the city the road starts in
     * 
     * @return from city
     */
    public City getFrom(){
        return from;
    }
    
    /**
     * Method for getting the city the road ends in
     * 
     * @return to city
     */
    public City getTo(){
        return to;
    }
    
    /**
     * Method for getting the length of the road
     * 
     * @return road length
     */
    public int getLength(){
        return length;
    }
    
    /**
     * Method for comparing road objects alphabetically.
     * 
     * @return integer used by the comparable interface
     */
    public int compareTo(Road r){
        if(!from.equals(r.from)){
            return from.compareTo(r.from);
        }
        return to.compareTo(r.to);
    }
}
