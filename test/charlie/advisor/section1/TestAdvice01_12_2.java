/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package charlie.advisor.section1;

import charlie.advisor.Advisor;
import charlie.card.Card;
import charlie.card.Hand;
import charlie.card.Hid;
import charlie.dealer.Seat;
import charlie.plugin.IAdvisor;
import charlie.util.Play;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jamesarama
 */
public class TestAdvice01_12_2 {
    private static IAdvisor advisor;
    
    public TestAdvice01_12_2() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        advisor = new Advisor();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAdvice() {
        Hid hid = new Hid(Seat.YOU, 1.0, 1.5);
        Hand hand = new Hand(hid);
        
        // Hand Value = 20
        hand.hit(new Card(10, Card.Suit.DIAMONDS));
        hand.hit(new Card(10, Card.Suit.CLUBS));
        
        // Up card = 3
        Play currentPlay = advisor.advise(hand, new Card(3, Card.Suit.HEARTS));
        Play expectedPlay = Play.STAY;
        
        assertEquals(expectedPlay, currentPlay);
    }
}
