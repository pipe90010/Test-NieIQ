package com.arias.nielseniq.test.home_test.problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MissingLettersTest {

    private MissingLetters aMissingLetters;

    @BeforeEach
    void  init() {
		aMissingLetters = new MissingLetters();
	}

	@Test
	void MissingLetters_EmptyStr_getAll(){
		
		String anEmptyString = "";

		String mssngLettrsStr = aMissingLetters.getMissingLetters(anEmptyString);
		
		assertEquals("abcdefghijklmnopqrstuvwxyz", mssngLettrsStr);
    }

    @Test
	void MissingLetters_Pangram_getEmpty(){
		String aPangramStr = "A quick brown fox jumps over the lazy dog";
		
		
		String mssngLettrsStr = aMissingLetters.getMissingLetters(aPangramStr);
		
		assertEquals("", mssngLettrsStr);
	}

	@Test
	void MissingLetters_NullStr_getAll(){
		
		String aNullString = null;

		String mssngLettrsStr = aMissingLetters.getMissingLetters(aNullString);
		
		assertEquals("abcdefghijklmnopqrstuvwxyz", mssngLettrsStr);
	}

    @Test
	void MissingLetters_UpperCase_getLowercaseMissingLetters(){
		
		String inputString = "Lions, and tigers and bears oh my";

		String mssngLettrsStr = aMissingLetters.getMissingLetters(inputString);
		
		assertEquals("cfjkpquvwxz", mssngLettrsStr);
	}


	@Test
	void MissingLetters_NonAlphaChar_getAll(){
		
		String inputString = "Lions, and tigers, and bears, oh my!";

		String mssngLettrsStr = aMissingLetters.getMissingLetters(inputString);
		
	    assertEquals("cfjkpquvwxz", mssngLettrsStr);
	}

	
	@Test
	void MissingLetters_Partial_getMissingLtters(){
		
		String inputString = "lions and tigers and bears oh my";

		String mssngLettrsStr = aMissingLetters.getMissingLetters(inputString);
		
		assertEquals("cfjkpquvwxz", mssngLettrsStr);
	}

}
