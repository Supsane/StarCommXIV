package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by GeekBrains on 11.02.2017.
 */
public class Background {
    private Texture texture;
    private float positionX;

    public Background() {
        texture = new Texture("staticback.jpg");
        positionX = 0.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, positionX, 0);
        batch.draw(texture, 1280 + positionX, 0);
    }

    public void update() {
        positionX -= 2f;
        if(positionX < -1280) {
            positionX = 0;
        }
    }
}
