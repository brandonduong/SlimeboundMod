package slimebound.actions;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import slimebound.cards.DecasProtection;
import slimebound.cards.DonusPower;
import slimebound.cards.PolyBeam;

import java.util.Random;


public class RandomShapesCardAction extends AbstractGameAction {
    public boolean upgradeCard;

    public RandomShapesCardAction(boolean upgraded) {
        this.upgradeCard = upgraded;


    }


    public void update() {

        AbstractCard c = null;
        Random random = new Random();
        Integer chosenRand = random.nextInt(3) + 1;

        switch (chosenRand) {
            case 1:
                c = CardLibrary.getCard(DonusPower.ID).makeCopy();
                break;
            case 2:
                c = CardLibrary.getCard(DecasProtection.ID).makeCopy();
                break;
            case 3:
                c = CardLibrary.getCard(PolyBeam.ID).makeCopy();
                break;
        }


        if (upgradeCard) {
            c.upgrade();
        }
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(c));

        this.isDone = true;
    }

}



