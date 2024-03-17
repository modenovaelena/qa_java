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
    boolean isValidGender;
    
    @Mock
    Feline feline;
    
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самка", false, true},
                {"Самец", true, true},
                {"", false, false}
        };
    }
    
    public LionTest(String gender, boolean hasMane, 
        boolean isValidGender) {
            
        this.gender = gender;
        this.hasMane = hasMane;
        this.isValidGender = isValidGender;
    }
    
    @Before
	public void setUp() {
		initMocks(this);
	}
    
    @Test
    public void testGendersMane() {

        try { 
            Lion lion = new Lion (this.gender, feline);
            
            Assert.assertEquals(this.hasMane, lion.doesHaveMane());
            Assert.assertTrue(this.isValidGender);
        } catch (Exception e) 
        {
            Assert.assertFalse(this.isValidGender);
        }
    }
    
    @Test
    public void testGetKittens() {

        try { 
            Lion lion = new Lion (this.gender, feline);

            lion.getKittens();
            Mockito.verify(feline, Mockito.times(1)).getKittens();
            Assert.assertTrue(this.isValidGender);
        } catch (Exception e) 
        {
            Assert.assertFalse(this.isValidGender);
        }
    }
    
    @Test
    public void testLionEatsMeat() {

        try { 
            Lion lion = new Lion (this.gender, feline);
            
            lion.getFood();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
            Assert.assertTrue(this.isValidGender);
        } catch (Exception e) 
        {
            Assert.assertFalse(this.isValidGender);
        }
    }
}