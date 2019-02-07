package zuochengyun.Ch01StackAndQueue.P04CatDogQueue;

public class PetEnterQueue {
    private Pet pet;
    private int count;

    public PetEnterQueue(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCount() {
        return count;
    }

    public String getEnterPetType() {
        return this.pet.getType();
    }
}
