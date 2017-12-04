public class BorderCity extends City {
    /**
     * BorderCity is a subclass of city. It also overrides the arrive method
     *
     * @param name the city name
     * @param value the value of the city
     * @param country witch country the city is in
     */

    public BorderCity(String name, int value, Country country) {
        super(name, value, country);
    }

    /**
     * Calculates the bonus the player gets for arriving at a bordercity.
     * Where the toll it 20% of the players money.
     *
     * @param player P
     * @return either returns the players bonus after paying the toll.
     * @return or returns the original bonus, if it isn't a borderCity.
     */
    @Override
    public int arrive(Player p){
        int b = super.arrive(p);
        if(!getCountry().equals(p.getCountryFrom())){
            int toll = ((getCountry().getGame().getSettings().getTollToBePaid()*p.getMoney())/100);
            changeValue(toll);
            return b-toll;
        }
        return b;
    }
}
