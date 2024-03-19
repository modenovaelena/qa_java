package com.example;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized; 
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.MockitoAnnotations.initMocks;

import static org.hamcrest.CoreMatchers.*;

@RunWith(Parameterized.class)
public class LionTest {
    
    String gender;
    boolean hasMane;

    
    @Mock
    Feline feline;
    
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самка", false},
                {"Самец", true}

        };
    }
    
    public LionTest(String gender, boolean hasMane) {
            
        this.gender = gender;
        this.hasMane = hasMane;
    }
    
    @Before
	public void setUp() {
		initMocks(this);
	}
    
    @Test
    public void testGendersMane() throws Exception {

        Lion lion = new Lion (this.gender, feline);
        Assert.assertEquals(this.hasMane, lion.doesHaveMane());

    }
    
    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion (this.gender, feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();

    }
    
    @Test
    public void testLionEatsMeat() throws Exception {

        Lion lion = new Lion (this.gender, feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");

    }
    @Test(expected = Exception.class)
    public void testLionInvalidGenderThrowsException() throws Exception {
        Lion lion = new Lion ("", feline);
    }
}