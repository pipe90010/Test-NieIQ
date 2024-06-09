package com.arias.nielseniq.test.home_test.problem2;

import java.util.ArrayList;
import java.util.List;

import com.arias.nielseniq.test.home_test.problem2.Particle.Direction;

public class Animation {

    private static Chamber chamber;

    public static List<String> animate(int speed, String init){
		
        chamber =  new Chamber(init);
        
        int time = 0;

        List<Particle> particles =  new ArrayList<>();
        
        try {
            particles = initParticles(speed);         
        } catch (ParticleException e) {
            System.err.println(e.getMessage());
            throw new ParticleException("The following chamber is not valid: "+init);
        }

        List<String> chamberOverTime = new ArrayList<>();
		
		while(true){
			List<Integer> particalPositions = calculateParticalPositions(particles, time);
            chamber.drawChamber(particalPositions);
			chamberOverTime.add(chamber.getChamberStr());
			if(!chamber.checkParticles(particalPositions)){
				break;
			}			
			time++;			
		}
		return chamberOverTime;
	}

    private static void particleLocation(int time, Particle particle){
		if(particle.getDirection() == Direction.Right){
			particle.setCurrentPosition( (time * particle.getSpeed()) + particle.getStartPosition());
		}
        else{
            particle.setCurrentPosition(particle.getStartPosition() - (time * particle.getSpeed()));
		}
		    
	}
	
	private  static List<Integer> calculateParticalPositions(List<Particle> listOfParticles, int time){
		List<Integer> positions = new ArrayList<>();
		for(Particle particle : listOfParticles){
            particleLocation(time, particle);
			positions.add(particle.getCurrentPosition());
		}		
		return positions;
	}   

    private static List<Particle> initParticles(int speed) throws ParticleException{
		List<Particle> particles = new ArrayList<>();
		int chamberSize = chamber.chamberSize();
		for(int i = 0; i< chamberSize; i++){
			char current = chamber.getChamberStr().charAt(i);
			if(current != '.'){
				particles.add(new Particle(current, i, speed));
			}
		}
		return particles;		
	}
}
