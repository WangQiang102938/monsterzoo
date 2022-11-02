import java.util.List;
import java.util.Random;

public class Monster {
    static List<MonsterSpecies> refSpecies = MonsterSpecies.genSampleSpecies();

    static enum Status {
        EGG,
        MONSTER,
    }

    MonsterSpecies species = null;
    int distance = 0;
    Status status = Status.EGG;

    public void incDistance() {
        if (this.status == Status.EGG)
            if (this.distance < 3) {
                distance++;
            } else {
                Utils.Box.print("卵が孵った！");
                this.status = Status.MONSTER;
                this.species = refSpecies.get(new Random().nextInt(refSpecies.size()));
                Utils.Box.print(this.species.name + "が産まれた！");
            }
    }

    public Status getStatus() {
        return this.status;
    }

    static public Monster makeMonster(MonsterSpecies species) {
        Monster tMonster = new Monster();
        tMonster.species = species;
        tMonster.status = Status.MONSTER;
        return tMonster;
    }

    static public Monster makeRandomMonster(Random rand) {
        return makeMonster(refSpecies.get(rand.nextInt(refSpecies.size())));
    }
}
