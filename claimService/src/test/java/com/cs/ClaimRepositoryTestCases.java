package com.cs;



import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import com.cs.model.Claim;
import com.cs.repository.IClaimRepository;
import com.cs.service.ClaimServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class ClaimRepositoryTestCases {

	
	@Autowired
	private ClaimServiceImpl claimServiceImpl;
	
	
	@MockBean
	private IClaimRepository claimRepository;
	
	
	

    // JUnit test for saveEmployee
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveClaimTest(){        
        Claim claim = new Claim();
        claim.setClaimType("Sick");
        claim.setClaimAmount("12500");
        claim.setClaimDate("12-03-2022");
        claim.setRemark("clear");
        claim.setStatus("clear");
       
        claimRepository.save(claim);

        Assertions.assertTrue(claim.getId()>0);
    }
    
    @Test
    @Order(2)
    public void getClaimTest(){

        Claim claim = claimRepository.findById(1).get();

        Assertions.assertTrue(claim.getId()== 1);

    }

    @Test
    @Order(3)
    public void getListOfClaimsTest(){

        List<Claim> claim = claimRepository.findAll();

        Assertions.assertTrue(claim.size()>0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateClaimTest(){

    	Claim claim = claimRepository.findById(1).get();

        claim.setClaimDate("12-03-2021");

        Claim claimUpdated =  claimRepository.save(claim);

        Assertions.assertTrue(claimUpdated.getClaimDate()=="12-03-2021");

    }

}
