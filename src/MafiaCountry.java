import java.util.List;
import java.util.Map;
import java.util.Random;

public class MafiaCountry extends Country {
    /**
     * Creates a new Country object.
     * MafiaCountry is a subclass of country, where we override the bonus method.
     *
     * @param name    The name of the Country.
     * @param network The network of Roads for each city.
     */
    public MafiaCountry(String name, Map<City, List<Road>> network) {
        super(name, network);
    }

    /**
     * Calculates the amount on money the player is getting robbed for in the mafiacountry Sweden.
     * Where the risk of getting robbed is 20%, where the players losses 10-50% of their money.
     * @param value the value of the City.
     * @return country's bonus method. If the player doesn't get robbed.
     * @return Otherwise it returns the amount of money the player gets robbed for.
     */
    @Override
    public int bonus(int value){
        int n = getGame().getRandom().nextInt(100);
        if(getGame().getSettings().getRisk() > n){
            return -getGame().getLoss();
        }else{
            return super.bonus(value);
        }
    }
}
