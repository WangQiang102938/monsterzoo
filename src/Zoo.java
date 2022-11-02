import java.util.*;
import java.util.Map.Entry;

public class Zoo {
    double zooStationRate = 0.2;
    double ballRange = 3;
    double fruitRange = 2;
    double eggRange = 2;

    List<User> users = new ArrayList<>();
    Map<User.ResourceTag, Double> zooStationRefMap = new HashMap<>();

    public Zoo() {
        zooStationRefMap.put(User.ResourceTag.BALL, this.ballRange);
        zooStationRefMap.put(User.ResourceTag.FRUIT, this.fruitRange);
        zooStationRefMap.put(User.ResourceTag.EGG, this.eggRange);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    boolean updateUser(User user) {
        if (user.checkValid() == false) {
            return false;
        }
        Utils.Box.push(user.name + " tern");
        Random rand = new Random();
        if (rand.nextDouble() < zooStationRate) {
            Utils.Box.print("ズーstationを見つけた！");
            for (Entry<User.ResourceTag, Double> entrySet : zooStationRefMap.entrySet()) {
                double upper = entrySet.getValue() * rand.nextDouble();
                Utils.Box.print(entrySet.getKey().name + "を" + (int) upper + "個Getした！");
                for (double i = 0; i < upper; i++) {
                    user.recvResource(entrySet.getKey());
                }
            }
        } else {
            Monster spawnMonster = Monster.makeRandomMonster(rand);
            Utils.Box.print(spawnMonster.species.name + "が現れた！");
            boolean currFruit = user.takeResource(User.ResourceTag.FRUIT);
            if (currFruit)
                Utils.Box.print("フルーツを投げた！捕まえやすさが倍になる！");
            for (int i = 0; i < 3 && user.takeResource(User.ResourceTag.BALL); i++) {
                Utils.Box.print(spawnMonster.species.name + "にボールを投げた");
                double r = (6 * rand.nextDouble() * (currFruit ? 1 : 2));
                if (spawnMonster.species.rare <= r) {
                    Utils.Box.print(spawnMonster.species.name + "を捕まえた！");
                    user.recvMonster(spawnMonster);
                    spawnMonster = null;
                    break;
                }
            }
            if (spawnMonster != null)
                Utils.Box.print(spawnMonster.species.name + "に逃げられた！");
        }
        user.move();
        user.checkValid();
        Utils.Box.pop("");
        return true;
    }

    public boolean checkValid() {
        boolean flag = false;
        for (User user : users) {
            flag = flag || user.checkValid();
        }
        return flag;
    }

    public void run() {
        Utils.Box.push("run");
        for (User user : users) {
            if (user.checkValid()) {
                updateUser(user);
            }
        }
        Utils.Box.pop("");
    }

    public void printResult() {
        for (User user : users) {
            user.printCatchedMonster();
        }
    }
}
