package com.example;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized; 
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    
    @Mock
    Feline feline;
    
    @Test
    public void testCatSaysMiau() {
        
        Cat cat = new Cat(feline);
        
        Assert.assertEquals("Мяу", cat.getSound());
    }
    
    @Test
    public void testCatEatsMeat() throws Exception {
        
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();

    }
 
}