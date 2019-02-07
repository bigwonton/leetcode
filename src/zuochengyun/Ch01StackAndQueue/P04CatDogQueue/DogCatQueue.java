package zuochengyun.Ch01StackAndQueue.P04CatDogQueue;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private int count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else if (pet.getType().equals("cat")) {
            catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("Illegal pet type.");
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("Queue is empty.");
        }
    }

    public Dog pollDog() {
        if (!dogQ.isEmpty()) {
            return (Dog) dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty");
        }
    }

    public Cat pollCat() {
        if (!catQ.isEmpty()) {
            return (Cat) catQ.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty");
        }
    }

    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQ.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQ.isEmpty();
    }
}
