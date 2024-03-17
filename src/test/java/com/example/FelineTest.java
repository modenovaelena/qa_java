package com.example;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized; 

import static org.hamcrest.CoreMatchers.*;

public class FelineTest {
    
    @Test
    public void testFelineFamily() {
        
        Feline feline = new Feline();
        
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }
    
    @Test
    public void testFelineHasAsManyKittensAsWeWant() {
        
        Feline feline = new Feline();
        
        Assert.assertEquals(1, feline.getKittens(1));
        Assert.assertEquals(1, feline.getKittens());
        Assert.assertEquals(2, feline.getKittens(2));
        Assert.assertEquals(200, feline.getKittens(200));
    }
    
    @Test
    public void testFelineEatsMeat() {
        
        Feline feline = new Feline();
        
        try {
            Assert.assertThat(feline.eatMeat(), 
                hasItems("Животные", "Птицы", "Рыба"));
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}