package malikjg.biomemap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import com.badlogic.gdx.utils.viewport.FitViewport;

import malikjg.noise.DistanceFormula;

import com.badlogic.gdx.Game;

public class BiomeMap extends Game {
	private SpriteBatch batch;
	private BiomeMapScreen biomeMapScreen;
	private FitViewport fit_viewport;
	private BiomeMapRenderer biomeMapRenderer;
	public BiomeMap(String noise, int height, int width, long seed, double noiseMask, int frequency, int octaves, double persistence, double lacunarity, String distanceFormula) {
		biomeMapRenderer = new BiomeMapRenderer(noise, height, width, seed, noiseMask, frequency, octaves, persistence, lacunarity, distanceFormula);
	}
	@Override
	public void create (){
		batch = new SpriteBatch();
		biomeMapScreen = new BiomeMapScreen(batch, biomeMapRenderer);
		setScreen(biomeMapScreen);
		
		fit_viewport = new FitViewport(1280,720);
		fit_viewport.apply();
	}
	public void resize(int width, int height){
		fit_viewport.update(width, height);
	}
	
	@Override
	public void render (){
		super.render();
	}
	
	@Override
	public void dispose (){
		batch.dispose();
		super.dispose();
	}
}
