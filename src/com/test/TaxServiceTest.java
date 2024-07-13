package com.test;
import com.service.TaxService;
import org.junit.Before;
import org.junit.Test;


import org.junit.After;
import org.junit.Assert;

import com.dto.TaxDto;

public class TaxServiceTest {
	TaxService taxService;
    
    @Before
    public void beforeTest() {
        taxService = new TaxService();
    }
    
    // Test case 1:  Under normal condition
    @Test
    public void testCalculateTaxPercent() {
        TaxDto taxDto = new TaxDto(1, 50000.0, 5000, 2024);
        double expectedTaxPercent = 10.0;
        double actualTaxPercent = taxService.calculateTaxPercent(taxDto);
        Assert.assertEquals(expectedTaxPercent, actualTaxPercent, 0.0);
    }
    // Test case 2: tax percent for Zero tax amount
    @Test
    public void testZeroTaxAmount() {
        TaxDto taxDto = new TaxDto(2, 60000.0, 0, 2024);
        double expectedTaxPercent = 0.0;
        double actualTaxPercent = taxService.calculateTaxPercent(taxDto);
        Assert.assertEquals(expectedTaxPercent, actualTaxPercent, 0.0);
    }
    
    
    // Test case 3: tax percent for negative net salary
    @Test
    public void testNegativeNetSalary() {
        TaxDto taxDto = new TaxDto(3, -10000.0, 2000, 2023);
        double expectedTaxPercent = -20.0;
        double actualTaxPercent = taxService.calculateTaxPercent(taxDto);
        Assert.assertEquals(expectedTaxPercent, actualTaxPercent, 0.0);
    

    }
    
    
 // Test case 4: tax percent for large values of net salary and tax amount
    @Test
    public void testLargeValues() {
        TaxDto taxDto = new TaxDto(4, 1000000.0, 200000, 2023);
        double expectedTaxPercent = 20.0;
        double actualTaxPercent = taxService.calculateTaxPercent(taxDto);
       Assert.assertEquals(expectedTaxPercent, actualTaxPercent, 0.0);
    }


    //Test case 5:  tax percent for negative tax amount
    @Test
    public void testNegativeTaxAmount() {
    TaxDto taxDto = new TaxDto(5, 60000.0, -3000, 2023);
    double expectedTaxPercent = -5.0;
    double actualTaxPercent = taxService.calculateTaxPercent(taxDto);
    Assert.assertEquals(expectedTaxPercent, actualTaxPercent, 0.0);
    }
    
    @After
    public void afterTest() {
        taxService = null;  
    }

}
