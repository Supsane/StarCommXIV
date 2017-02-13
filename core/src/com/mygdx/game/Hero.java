package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by GeekBrains on 11.02.2017.
 */
public class Hero {
    private Texture texture;
    private float speed;
    private Vector2 position; // position.x, position.y
    private int fireRate;
    private int fireCounter;
    private Rectangle rect;

    public Rectangle getRect() {
        return rect;
    }

    public Hero() {
        texture = new Texture("ship80x60.tga");
        speed = 8.0f;
        position = new Vector2(100, 100);
        fireRate = 6;
        fireCounter = 0;
        rect = new Rectangle(position.x, position.y, 80, 60);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.y += speed;
            if (position.y > 720) {
                position.y = -60;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            position.y -= speed;
            if (position.y < -60) {
                position.y = 720;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= speed;
            if (position.x < 0) {
                position.x = 0;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            position.x += speed;
            if (position.x > 1200) {
                position.x = 1200;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
            fireCounter++;
            if (fireCounter > fireRate) {
                fireCounter = 0;
                fire();
            }
        }
        rect.x = position.x;
        rect.y = position.y;
    }

    public void fire() {
        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (!MyGdxGame.bullets[i].isActive()) {
                MyGdxGame.bullets[i].setup(position.x + 60, position.y + 24);
                break;
            }
        }
    }
}
