import java.util.ArrayList;
import java.util.List;

public class MonsterSpecies {
    String name;
    double rare;

    public MonsterSpecies(String name, double rare) {
        this.name = name;
        this.rare = rare;
    }

    public static List<MonsterSpecies> genSampleSpecies() {
        List<MonsterSpecies> tmpList = new ArrayList<>();

        tmpList.add(new MonsterSpecies("イガキン", 9));
        tmpList.add(new MonsterSpecies("ナマチュウ", 3));
        tmpList.add(new MonsterSpecies("イノウエン", 1));
        tmpList.add(new MonsterSpecies("リョージィ", 2));
        tmpList.add(new MonsterSpecies("アキモトン", 5));
        tmpList.add(new MonsterSpecies("ゴージマ", 4));
        tmpList.add(new MonsterSpecies("チュウデン", 6));
        tmpList.add(new MonsterSpecies("ヅカホン", 8));
        tmpList.add(new MonsterSpecies("ニシムラー", 7));
        tmpList.add(new MonsterSpecies("サコーデン", 2));
        tmpList.add(new MonsterSpecies("ウッチー", 5));
        tmpList.add(new MonsterSpecies("ハヤッシー", 4));
        tmpList.add(new MonsterSpecies("キーチー", 3));
        tmpList.add(new MonsterSpecies("リョクン", 1));
        tmpList.add(new MonsterSpecies("デコポン", 6));
        tmpList.add(new MonsterSpecies("カミサン", 5));
        tmpList.add(new MonsterSpecies("シスイ", 1));
        tmpList.add(new MonsterSpecies("ジョナ", 7));
        tmpList.add(new MonsterSpecies("ギダギダ", 2));
        tmpList.add(new MonsterSpecies("ミッツー", 8));
        tmpList.add(new MonsterSpecies("ゾエサン", 5));
        tmpList.add(new MonsterSpecies("キタバー", 3));

        return tmpList;
    }
}
