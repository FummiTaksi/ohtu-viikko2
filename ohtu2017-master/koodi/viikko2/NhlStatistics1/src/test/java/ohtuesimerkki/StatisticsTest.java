/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omistaja
 */
public class StatisticsTest {

    public StatisticsTest() {

    }

    @Test
    public void searchReturnsRightPlayer() {
        Player gretzky = stats.search("Gretzky");
        assertEquals("Gretzky",gretzky.getName());
    }
    
    @Test
    public void searchReturnNull() {
        Player laine = stats.search("Laine");
        assertEquals(null,laine);
    }
    
    @Test
    public void teamReturnsAllPlayers() {
        List<Player> edmonton = stats.team("EDM");
        assertEquals(3,edmonton.size());
    }
    
    @Test
    public void topScorersReturnsRightAmountOfPlayers() {
        List<Player> topThree = stats.topScorers(3);
        assertEquals(3,topThree.size());
    }
    
    @Test
    public void FirstPlayerIsCorrect() {
        List<Player> topThree = stats.topScorers(3);
        assertEquals(topThree.get(0).getName(),"Gretzky");
    }
    
    @Test
    public void ThirdPlayerIsCorrect() {
        List<Player> topThree = stats.topScorers(3);
        assertEquals(topThree.get(2).getName(),"Yzerman");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics( readerStub);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
