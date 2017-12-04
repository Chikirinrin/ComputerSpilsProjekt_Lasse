public class CapitalCity extends BorderCity {
    /**
     * CapitalCity is a subclass of BorderCity, which is a subclass for city.
     * CapitalCity overrides the method arrive method both in city and bordercity.
     *
     * @param name    the city name
     * @param value   the value of the city
     * @param country witch country the city in is
     */
    public CapitalCity(String name, int value, Country country) {
        super(name, value, country);
    }

    /**
     * Calculates the bonus the player gets for arriving at a capital. Where he must spend some of his money on fun.
     * This amount is a random tell within 0-money, where money is the amount of money the player has.
     *
     * @param player p
     * @return the bonus for the player after he spends some of it on fun in a capital.
     */
    @Override
    public int arrive(Player p) {
        int b = super.arrive(p);
        int money = b+p.getMoney();
        int funMoney = getCountry().getGame().getRandom().nextInt(money+1);
        changeValue(funMoney);
        return b-funMoney;
    }
}

