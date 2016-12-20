package monsterzoo.field;

import static monsterzoo.user.Goods.BALL;

import monsterzoo.Name;
import monsterzoo.user.GoodsEmptyListener;

public class GameContinueFlag implements GoodsEmptyListener {
    private boolean flag = true;

    public boolean isContinue(){
        return flag;
    }

    @Override
    public void empty(Name name) {
        if(name.equals(BALL))
            flag = false;
    }
}
