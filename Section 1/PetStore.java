package com.markodevcic.javakotlincomparison;

import android.view.View;

import java.util.List;

public class PetStore {
	
	private List<Pet> pets;
	
	public List<Pet> getPets() {
		return pets;
	}
	
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	public PetStore(List<Pet> pets) {
		this.pets = pets;
	}
	
	public Pet findPet(String name) {
		for (Pet pet : pets) {
			if (pet.name.equals(name)) {
				return pet;
			}
		}
		
		new View(context).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//view clicked
			}
		});
		return null;
	}
}