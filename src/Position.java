
/**
 * This class takes care of the players position. 
 *
 * @author Andreas Morgen & Tessa Broeders
 * @version 14/11/2017
 */
public class Position
{
    private City from; // The city the player is comming from
    private City to;   // The city the player is going to
    private int distance; // The current distance from the end city
    private int total;  // The total distance between the cities
    
    /**
     * Constructor for the Position class.
     * 
     * @param from  The city the player is comming from
     * @param to    The city the player is going to
     * @param distance  The total distance between the cities (at the beginning).
     */
    public Position(City from, City to, int distance){
        this.from = from;
        this.to = to;
        this.total = distance;
        this.distance = distance;
    }
    
    /**
     * Method for getting the city the player is comming from
     * 
     * @return from city
     */
    public City getFrom(){
        return from;
    }
    
    /**
     * Method for getting the city the player is going to
     * 
     * @return to city
     */
    public City getTo(){
        return to;
    }
    
    /**
     * Method for getting the distance left from the end city
     * 
     * @return distance from end city
     */
    public int getDistance(){
        return distance;
    }
    
    /**
     * Method for getting the total distance between the cities.
     * 
     * @return total distance between cities
     */
    public int getTotal(){
        return total;
    }
    
    /**
     * Method for checking whether the player has arrived at the end city.
     * 
     * @return true if distance == 0 or false otherwise.
     */
    public boolean hasArrived(){
        return (distance == 0);
    }
    
    /**
     * Method for moving the position of the player.
     * 
     * @return true if the player was moved. False otherwise.
     */
    public boolean move(){
        if(distance > 0){
            distance -= 1;
            return true;
        }
        return false;
    }
    
    /**
     * Method for turning the player around, changing the beginning and end city.
     */
    public void turnAround(){
        City placeholder = this.from;
        this.from = this.to;
        this.to = placeholder;
        this.distance = this.total - this.distance;
    }
}
