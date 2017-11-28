import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CityTest {
    private Game game;
    private Country country1, country2,country3;
    private City cityA, cityB, cityC, cityD, cityF, cityG,cityE;

    @Before
    public void setUp() throws Exception {
        game = new Game(0);
        game.getRandom().setSeed(0);
        Map<City, List<Road>> network1 = new HashMap<>();
        Map<City, List<Road>> network2 = new HashMap<>();
        Map<City,List<Road>> network3 = new HashMap<>();

        // Create countries
        country1 = new Country("Country 1", network1);
        country2 = new Country("Country 2", network2);
        country3 = new MafiaCountry("Country 3", network3);
        country1.setGame(game);
        country2.setGame(game);
        country3.setGame(game);

        // Create Cities
        cityA = new City("City A", 80, country1);
        cityB = new City("City B", 60, country1);
        cityC = new City("City C", 40, country1);
        cityD = new City("City D", 100, country1);
        cityE = new City("City E",90, country1);
        cityF = new City("City F",70, country1);
        cityG = new City("City G", 80, country3);

    }

    @Test
    public void City(){
        assertEquals(cityD.getValue(),100);
        assertEquals(cityD.getCountry(), country1);
        assertEquals(cityD.getName(), "City D");
    }

    @Test
    public void changeValue(){
        assertEquals(cityA.getValue(), 80);
        cityA.changeValue(50);
        assertEquals(cityA.getValue(), 130);

        assertEquals(cityC.getValue(), 40);
        cityC.changeValue(cityC.getValue()-0);
        assertEquals(cityC.getValue(),cityC.getValue());

        assertEquals(cityB.getValue(),60);
        cityB.changeValue(-80);
        assertEquals(cityB.getValue(),-20);
    }

    @Test
    public void reset() throws Exception {
        cityA.changeValue(80);
        assertEquals(cityA.getValue(), 160);
        cityA.reset();
        assertEquals(cityA.getValue(),80);

        cityA.changeValue(-90);
        assertEquals(cityA.getValue(), -10);
        cityA.reset();
        assertEquals(cityA.getValue(),80);
    }

    @Test
    public void compareTo() throws Exception {
        assertTrue(cityA.compareTo(cityB) < 0);
        assertTrue(cityA.compareTo(cityC) < 0);
        assertTrue(cityB.compareTo(cityC) < 0);
        assertTrue(cityC.compareTo(cityA) > 0);
        assertTrue(cityB.compareTo(cityA) > 0);
        assertTrue(cityC.compareTo(cityB) > 0);
        assertEquals(cityA.compareTo(cityA), 0);

    }

    @Test
    public void arrive() throws Exception {
        for(int i = 0; i<1000 ; i++) {       // Try different seeds
            game.getRandom().setSeed(i);    // Set seed
            int bonus = country1.bonus(80); // Remember bonus
            game.getRandom().setSeed(i);    // Reset seed
            int arrive = cityA.arrive();    // Same bonus
            assertEquals(arrive, bonus);
            assertEquals(cityA.getValue(), 80 - bonus);
            cityA.reset();


            game.getRandom().setSeed(i);    // Try different seeds.
            int mafiaBonus = country3.bonus(80); //Set seed.
            game.getRandom().setSeed(i);    // Remember bonus.
            int mafiaArrive = cityG.arrive();   //Reset seed.
            assertEquals(mafiaArrive, mafiaBonus); //Same bonus.

            if (mafiaBonus < 0) {
                assertEquals(cityG.getValue(), 80);

            } else {
                assertEquals(cityG.getValue(), 80 - mafiaBonus);
            }
            cityG.reset();
        }
    }

    @Test
    public void hashCodeTestCity() throws Exception{

        assertNotEquals(cityA.hashCode(),cityB.hashCode());
        assertNotEquals(cityB.hashCode(),cityC.hashCode());
        assertNotEquals(cityC.hashCode(),cityD.hashCode());
        assertNotEquals(cityD.hashCode(),cityE.hashCode());
        assertNotEquals(cityE.hashCode(),cityF.hashCode());
        assertNotEquals(cityF.hashCode(),cityG.hashCode());

        assertEquals(cityA.hashCode(),cityA.getName().hashCode()*19+cityA.getCountry().hashCode()*13);
        assertEquals(cityB.hashCode(),cityB.getName().hashCode()*19+cityB.getCountry().hashCode()*13);
    }

    @Test
    public void equals() throws Exception{
        City cityH = new City("City A", 80, country2);

        assertTrue(cityA.equals(cityA));
        assertFalse(cityA.equals(country1));

        assertFalse(cityA.getClass().equals(country1.getClass()));
        assertFalse(cityA.equals(cityB));

        assertEquals(cityA.getCountry(),cityB.getCountry());
        assertNotEquals(cityA.getName(), cityB.getName());

        assertFalse(cityA.equals(cityH));
        assertEquals(cityA.getName(), cityH.getName());
        assertNotEquals(cityA.getCountry(),cityH.getCountry());
    }
}