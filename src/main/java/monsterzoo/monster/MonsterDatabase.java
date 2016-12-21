package monsterzoo.monster;

import monsterzoo.Name;
import monsterzoo.field.MonsterZooField;
import monsterzoo.field.RandomValue;

public class MonsterDatabase extends Monsters{
    public MonsterDatabase(){
        initialize();
    }

    public Monster encounter(MonsterZooField field){
        RandomValue index = field.next(
                monsters.size());
        return encounter(index.toInteger());
    }

    private Monster encounter(int index){
        return monsters.get(index);        
    }

    private void register(String name, int rarity){
        register(new Name(name), new Rarity(rarity));
    }

    /**
     * ここを3行以内にしようと思うと，設定ファイルの読み込み等が必要になる．今回は面倒なので，そのまま書く．
     */
    private void initialize(){
        register("イガキン", 9);
        register("ナマチュウ", 3);
        register("イノウエン", 1);
        register("リョージィ", 2);
        register("アキモトン", 5);
        register("ゴージマ", 4);
        register("チュウデン", 6);
        register("ヅカホン", 8);
        register("ニシムラー", 7);
        register("サコーデン", 2);
        register("ウッチー", 5);
        register("ハヤッシー", 4);
        register("キーチー", 3);
        register("リョクン", 1);
        register("デコポン", 6);
        register("カミサン", 5);
        register("シスイ", 1);
        register("ジョナ", 7);
        register("ギダギダ", 2);
        register("ミッツー", 8);
        register("ゾエサン", 5);
        register("キタバー", 3);
    }
}
