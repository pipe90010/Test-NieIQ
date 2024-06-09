package com.arias.nielseniq.test.home_test.problem2;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnimationTest {
    @Test
    void AnimationTestRightDirectionAtSpeed2() {
		List<String> expected = new ArrayList<String>();
		expected.add("..X....");
		expected.add("....X..");
		expected.add("......X");
		expected.add(".......");
		
		List<String> animate = Animation.animate(2, "..R....");
		
        assertTrue(animate.containsAll(expected));

	}

    @Test
    void AnimationTestRightDirectionAtSpeed1() {
		List<String> expected = new ArrayList<String>();
		expected.add(".X.....");
        expected.add("..X....");
        expected.add("...X...");
        expected.add("....X..");
        expected.add(".....X.");
        expected.add("......X");
        expected.add(".......");
		
		List<String> animate = Animation.animate(1, ".R.....");
		
        assertTrue(animate.containsAll(expected));
	}

    @Test
    void AnimationTestLeftDirectionAtSpeed1() {
		List<String> expected = new ArrayList<String>();
		expected.add(".....X.");
        expected.add("....X..");
        expected.add("...X...");
        expected.add("..X....");
        expected.add(".X.....");
        expected.add("X......");
        expected.add(".......");
	
		List<String> animate = Animation.animate(1, ".....L.");
		
        assertTrue(animate.containsAll(expected));
	}

    @Test
    void AnimationTestWrongDirectionAtSpeed1() {
        assertThrows(ParticleException.class, ()->{
            Animation.animate(1, ".....W.");
        });
	}

    @Test
    void AnimationTestLeftRightLeftRightDotLeftRightLeftRightDirectionAtSpeed2() {
		List<String> expected = new ArrayList<String>();
		expected.add("XXXX.XXXX");
        expected.add("X..X.X..X");
        expected.add(".X.X.X.X.");
        expected.add(".X.....X.");
        expected.add(".........");

		List<String> animate = Animation.animate(2, "LRLR.LRLR");
		
        assertTrue(animate.containsAll(expected));
	}

    @Test
    void AnimationTestRightLeftRightLeftRightLeftRightLeftRightLeftDirectionAtSpeed10() {
		List<String> expected = new ArrayList<String>();
		expected.add("XXXXXXXXXX");
        expected.add("..........");

		List<String> animate = Animation.animate(10, "RLRLRLRLRL");
		
        assertTrue(animate.containsAll(expected));
	}

    @Test
    void AnimationTestWithoutDirectionAtSpeed1() {
		List<String> expected = new ArrayList<String>();
        expected.add("...");

		List<String> animate = Animation.animate(1, "...");
		
        assertTrue(animate.containsAll(expected));
	}

    @Test
    void AnimationTestLRRLdotLRdotLRRdotRdotLRRLdotDirectionAtSpeed1() {
        List<String> expected = new ArrayList<String>();
        expected.add("XXXX.XX.XXX.X.XXXX.");
        expected.add("..XXX..X..XX.X..XX.");
        expected.add(".X.XX.X.X..XX.XX.XX");
        expected.add("X.X.XX...X.XXXXX..X");
        expected.add(".X..XXX...X..XX.X..");
        expected.add("X..X..XX.X.XX.XX.X.");
        expected.add("..X....XX..XX..XX.X");
        expected.add(".X.....XXXX..X..XX.");
        expected.add("X.....X..XX...X..XX");
        expected.add(".....X..X.XX...X..X");
        expected.add("....X..X...XX...X..");
        expected.add("...X..X.....XX...X.");
        expected.add("..X..X.......XX...X");
        expected.add(".X..X.........XX...");
        expected.add("X..X...........XX..");
        expected.add("..X.............XX.");
        expected.add(".X...............XX");
        expected.add("X.................X");
        expected.add("...................");

        List<String> animate = Animation.animate(1, "LRRL.LR.LRR.R.LRRL.");
		
        assertTrue(animate.containsAll(expected));

    }

}
