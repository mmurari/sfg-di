package com.springframework.pets;

public class PetServiceFactory {
    public PetService getPetService(String petType) {
        return "cat".equals(petType) ? new CatPetService() : new DogPetService();
    }
}
