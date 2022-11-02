import java.util.*;

public class User {
    List<Monster> monsters = new ArrayList<>();
    List<Monster> eggs = new ArrayList<>();
    int fruits = 0;
    int balls = 10;
    int distance = 0;
    String name = "UnknownUser";
    boolean alive = true;

    enum ResourceTag {
        FRUIT("フルーツ"),
        BALL("ボール"),
        EGG("卵");

        public final String name;

        ResourceTag(String name) {
            this.name = name;
        }
    }

    public User(String name) {
        this.name = name == null ? this.name : name;
    }

    void recvResource(ResourceTag tag) {
        switch (tag) {
            case FRUIT:
                fruits++;
                break;
            case BALL:
                balls++;
                break;
            case EGG:
                eggs.add(new Monster());
                break;
            default:
                break;
        }
    }

    public void recvMonster(Monster monster) {
        this.monsters.add(monster);
    }

    public boolean takeResource(ResourceTag tag) {
        switch (tag) {
            case FRUIT:
                if (this.fruits > 0) {
                    fruits--;
                    return true;
                }
                break;
            case BALL:
                if (this.balls > 0) {
                    balls--;
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    public void move() {
        this.distance++;
        incEggDist();
        Utils.Box.print(
                String.format("%s@User: 手持ちのボールは%d個，フルーツは%d個，%dkm歩いた．",
                        this.name, this.balls, this.fruits, this.distance));
    }

    private void incEggDist() {
        Iterator<Monster> iterator = eggs.iterator();
        while (iterator.hasNext()) {
            Monster tMonster = iterator.next();
            tMonster.incDistance();
            if (tMonster.getStatus() == Monster.Status.MONSTER) {
                this.monsters.add(tMonster);
                iterator.remove();
            }
        }
    }

    public boolean checkValid() {
        if (this.balls <= 0) {
            if (this.alive) {
                Utils.Box.print(this.name + ":ボールがなくなった！");
                this.alive = false;
            }
            return false;
        }
        return true;
    }

    public void printCatchedMonster() {
        Utils.Box.push(this.name + " result", '>', '<', '|', '|');
        for (Monster monster : monsters) {
            Utils.Box.print(monster.species.name + "を捕まえた．");
        }
        Utils.Box.pop("", '>', '<');
    }
}
