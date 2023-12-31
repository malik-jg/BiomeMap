package malikjg.biomemap;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject{
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected int speedMultiplier;
	protected Texture image;
	protected Vector2 pos;

	protected Handler handler;
	protected OrthographicCamera camera;
	protected BiomeMapRenderer renderer;
	public GameObject() {

	}
	public GameObject(Handler handler) {
		this.handler = handler;
	}

	public GameObject(Handler handler, OrthographicCamera camera, BiomeMapRenderer renderer) {
		this.handler = handler;
		this.camera = camera;
		this.renderer = renderer;

	}

	public abstract void render(SpriteBatch batch);
	public abstract void update(float delta);
	public abstract Rectangle getBoundsHorizontal();
    public abstract Rectangle getBoundsVertical();

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getSpeedMultiplier() {
		return speedMultiplier;
	}
	public void setSpeedMultiplier(int speedMultiplier) {
		this.speedMultiplier = speedMultiplier;
	}

}
