package com.arias.nielseniq.test.home_test.problem2;

import java.util.List;

public class Chamber {
    
    private int size ;
    private String chamberStr;

    public Chamber(String chamber){
        this.chamberStr = chamber;
        this.size = chamber.length();
    }

    public int chamberSize(){
        return size;
    }

    public String getChamberStr(){
        return this.chamberStr;
    }

    public void drawChamber(List<Integer> positions){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < chamberSize(); i ++){
			if(positions.contains(i)){
				builder.append("X");
			}
			else{
				builder.append(".");
			}
		}		
		this.chamberStr = builder.toString();
	}

    public boolean checkParticles(List<Integer> positions){
		for(Integer particlePosition : positions){
			if(0 <= particlePosition && particlePosition <= size){
				return true;
			}
		}
		return false;
	}
}
