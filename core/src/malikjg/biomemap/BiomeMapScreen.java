package malikjg.biomemap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class BiomeMapScreen extends ScreenAdapter{
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	
	private SpriteBatch batch;
	private OrthographicCamera orthoCamera;
	private BiomeMapRenderer biomeMapRenderer;
	private AssetManager assetsManager;
	private TextureAtlas textureAtlas;
	private TextureRegion textureRegion;
	
	
	private Handler handler;
	private KeyInput keyInput;
	private Camera camera;
	
	public BiomeMapScreen(SpriteBatch batch, BiomeMapRenderer biomeMapRenderer){
		this.batch = batch;
		
		orthoCamera = new OrthographicCamera(WIDTH, HEIGHT);
		this.biomeMapRenderer = biomeMapRenderer;
		
		assetsManager = new AssetManager();
		assetsManager.load("pack.atlas", TextureAtlas.class);
		
		
		assetsManager.finishLoading();
		
		textureAtlas = assetsManager.get("pack.atlas");
		
		handler = new Handler();
		keyInput = new KeyInput(handler);
		camera = new Camera(handler, orthoCamera, biomeMapRenderer);
	}
	@Override
	public void show(){
		orthoCamera.position.set(0 ,0,10);
	}
	@Override 
	public void render(float delta){
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(orthoCamera.combined);
		camera.update(delta);
		orthoCamera.update();
		batch.begin();
		biomeMapRenderer.createWorld(batch, textureAtlas, textureRegion);
		keyInput.update();
		batch.end();
	}
	@Override
	public void dispose(){
		super.dispose();
	}
}
