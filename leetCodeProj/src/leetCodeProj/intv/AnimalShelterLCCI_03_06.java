package leetCodeProj.intv;

import java.util.Deque;
import java.util.LinkedList;

public class AnimalShelterLCCI_03_06 {
	class AnimalShelf {
		int count = 0;
		int[] nullVal = {-1,-1};
		Deque<Animal> animalQueCat = new LinkedList<>();
		Deque<Animal> animalQueDog = new LinkedList<>();
		
	    public AnimalShelf() {

	    }
	    
	    public void enqueue(int[] animal) {
	    	if(animal[1]==0) {
	    		animalQueCat.add(new Animal(count++,animal));
	    	}else {
	    		animalQueDog.add(new Animal(count++,animal));
	    	}
	    }
	    
	    public int[] dequeueAny() {
	    	if(animalQueDog.isEmpty()&&animalQueCat.isEmpty()) {
	    		return nullVal;
	    	}else if(!animalQueDog.isEmpty()&&!animalQueCat.isEmpty()){
		    	if(animalQueCat.getFirst().time<animalQueDog.getFirst().time) {
		    		return animalQueCat.pollFirst().animalArr;
		    	}else {
		    		return animalQueDog.pollFirst().animalArr;
		    	}
	    	}else if(!animalQueDog.isEmpty()){
	    		return dequeueDog();
	    	}else if(!animalQueCat.isEmpty()) {
	    		return dequeueCat();
	    	}else {
	    		return nullVal;
	    	}

	    }
	    
	    public int[] dequeueDog() {
	    	if(!animalQueDog.isEmpty()) {
	    		return animalQueDog.pollFirst().animalArr;
	    	}else {
	    		return nullVal;
	    	}
	    	
	    }
	    
	    public int[] dequeueCat() {
	    	if(!animalQueCat.isEmpty()) {
	    		return animalQueCat.pollFirst().animalArr;
	    	}else {
	    		return nullVal;
	    	}
	    }
	    
		class Animal{
			int time = 0;
			int[] animalArr = null;
			public Animal(int time,int[] animalArr) {
				this.time = time;
				this.animalArr = animalArr;
			}
		}
	}
	

}
