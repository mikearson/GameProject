package com.mikael.game.Entity.MonsterEntity.Monsters;

import com.mikael.game.States.PlayState;
import com.mikael.game.Entity.HPManager;
import com.mikael.game.Entity.MonsterEntity.MonsterEntity;
import com.mikael.game.Entity.MonsterEntity.MonsterMoves.Lounge;
import com.mikael.game.Graphics.Sprite;
import com.mikael.game.util.CooldownCounter;
import com.mikael.game.util.Vector2f;
import java.awt.*;

public class SkeletonTest extends MonsterEntity implements Monster { // implements attack, update, render

    int animationWait = 0;

    private int startingHitPoints;
    private int loungeThresholdRange = 80;
    private int loungeCooldown = 300;
    public int loungeDamage = 30;
    private int loungeDuration = 50;
    private boolean loungeRange = false;

    private Lounge lounge;
    public HPManager hitPoints;
    public CooldownCounter loungeDamageCooldown;

    public SkeletonTest(Sprite sprite, Vector2f pos, int size) {
        super(sprite, pos, size);

        acc = 0.2f;
        deacc = 0.3f;
        maxSpeed = 0.6f;
        bounds.setWidth(40);
        bounds.setHeight(-40);
        bounds.setXOffset(20);
        bounds.setYOffset(60);

        hitPoints = new HPManager(startingHitPoints);
        lounge = new Lounge(this.pos, loungeThresholdRange, loungeCooldown, loungeDuration);
        loungeDamageCooldown = new CooldownCounter(loungeCooldown);

    }

    public void attack() {
        loungeRange = lounge.LoungeMove();

        if (loungeRange) {
            acc = 5f;
            deacc = 1.5f;
            maxSpeed = 8f;
        } else {
            acc = 0.2f;
            deacc = 0.3f;
            maxSpeed = 0.6f;
        }
        if (loungeDamageCooldown.getReset() == 0) {
            if (lounge.didItHit(this)) {
                PlayState.player.hitPoints.setHitPoints(-loungeDamage);
                loungeDamageCooldown.update();
            }
        } else {
            loungeDamageCooldown.update();
        }
    }

    public void update() {
        super.update();
        attack();
    }

    public void render(Graphics2D g) {
        g.drawImage(animation.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
    }
}
