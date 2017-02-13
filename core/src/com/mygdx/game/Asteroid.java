package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by GeekBrains on 11.02.2017.
 */
public class Asteroid {
    private static Texture texture;
    private Vector2 position;
    private float speed;
    private Rectangle rect;
    private float angle;
    private int hp;

    public Rectangle getRect() {
        return rect;
    }

    public Asteroid() {
        if (texture == null) {
            texture = new Texture("asteroid64.png");
        }
        position = new Vector2(1280 + (float) Math.random() * 1280, (float) Math.random() * 720);
        speed = 2.0f + (float) Math.random() * 10.0f;
        rect = new Rectangle(position.x, position.y, 64, 64);
        angle = (float) Math.random() * 360;
        hp = 1 + (int) (Math.random() * 10);
    }

    public void render(SpriteBatch batch) {
        // batch.draw(texture, position.x, position.y);
        float m = 0.4f + hp / 10.0f;
        batch.draw(texture, position.x, position.y, 32, 32, 64, 64, m, m, angle, 0, 0, 64, 64, false, false);
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp <= 0) {
            recreate();
        }
    }

    public void recreate() {
        position.x = 1280 + (float) Math.random() * 1280;
        position.y = (float) Math.random() * 720;
        speed = 2.0f + (float) Math.random() * 10.0f;
        angle = (float) Math.random() * 360;
        hp = 1 + (int) (Math.random() * 10);
    }

    public void update() {
        position.x -= speed;
        angle += speed / 2;
        if (position.x < -64) {
            recreate();
        }
        rect.x = position.x;
        rect.y = position.y;
    }
}
