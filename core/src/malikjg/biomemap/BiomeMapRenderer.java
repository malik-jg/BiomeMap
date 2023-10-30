package malikjg.biomemap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import malikjg.noise.DistanceFormula;

public class BiomeMapRenderer{
	private double[][] humidity;
	private double[][] temperature;
	private BiomeMapGenerator biomeMapGenerator;
	private DistanceFormula formula;
	public BiomeMapRenderer(String noise, int height, int width, long seed, double noiseMask, int frequency, int octaves, double persistence, double lacunarity, String distanceFormula){
		if(distanceFormula.equals("Euclidean")) {
			formula = DistanceFormula.Euclidean;
		}
		else if(distanceFormula.equals("Manhattan")) {
			formula = DistanceFormula.Manhattan;
		}
		else if(distanceFormula.equals("Minkowski")) {
			formula = DistanceFormula.Minkowski;
		}
		else if(distanceFormula.equals("Chebyshev")) {
			formula = DistanceFormula.Chebyshev;
		}
		biomeMapGenerator = new BiomeMapGenerator(noise, height, width, seed, noiseMask, frequency, octaves, persistence, lacunarity, formula);
		
		if(biomeMapGenerator.getNoise().equals("Noise")) {
			humidity = biomeMapGenerator.getHumidityNoise();
			temperature = biomeMapGenerator.getTemperatureNoise();
		}
		else{
			humidity = biomeMapGenerator.getHumidity();
			temperature = biomeMapGenerator.getTemperature();
		}

	}
	public void createWorld(SpriteBatch batch, TextureAtlas textureAtlas, TextureRegion textureRegion) {
		for(int i = biomeMapGenerator.getWidth() / 2 - 1; i  >= -biomeMapGenerator.getWidth() / 2 ; i--){
			for(int j = biomeMapGenerator.getHeight() / 2 - 1; j >= -biomeMapGenerator.getHeight() / 2 ; j--) {
				float x = i * 0.5f * Tile.TILE_WIDTH + j * -0.5f  * Tile.TILE_WIDTH - 0.5f*Tile.TILE_WIDTH;
				float y = i * 0.25f * Tile.TILE_HEIGHT + j * 0.25f * Tile.TILE_HEIGHT - 0.5f*Tile.TILE_WIDTH;;
				if(biomeMapGenerator.getNoise().equals("Noise"))drawNoiseBiome(batch, textureAtlas, textureRegion, humidity[i + humidity.length / 2][j + humidity.length / 2], temperature[i + temperature.length / 2][j + temperature.length / 2], x, y);
				else if(biomeMapGenerator.getNoise().equals("Perlin"))drawPerlinBiome(batch, textureAtlas, textureRegion, humidity[i + humidity.length / 2][j + humidity.length / 2], temperature[i + temperature.length / 2][j + temperature.length / 2], x, y);
				else if(biomeMapGenerator.getNoise().equals("Voronoi"))drawNoiseBiome(batch, textureAtlas, textureRegion, humidity[i + humidity.length / 2][j + humidity.length / 2], temperature[i + temperature.length / 2][j + temperature.length / 2], x, y);
				else if(biomeMapGenerator.getNoise().equals("White"))drawNoiseBiome(batch, textureAtlas, textureRegion, humidity[i + humidity.length / 2][j + humidity.length / 2], temperature[i + temperature.length / 2][j + temperature.length / 2], x, y);
			}
		}
	}
	public void drawNoiseBiome(SpriteBatch batch, TextureAtlas textureAtlas, TextureRegion textureRegion, double humidity, double temperature, float biomeX, float biomeY) {
		textureRegion = textureAtlas.findRegion("Ice");		
		batch.draw(textureRegion, biomeX, biomeY);
		if(humidity > 0.875) {
			if(temperature > 0.666) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);		
			}
		else if(humidity > 0.750) {
			if(temperature > 0.666) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.500) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
		}
		else if(humidity > 0.625) {
			if(temperature > 0.666) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.500) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.000) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}

		}
		else if(humidity > 0.500) {
			if(temperature > 0.666) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.500) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);

			}
			else if(temperature > 0.000) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.333) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}


		}
		else if(humidity > 0.375) {
			if(temperature > 0.666) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.500) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.000) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.333) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.666) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}


		}
		else if(humidity > 0.250) {
			if(temperature > 0.666) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.500) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.000) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.333) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.666) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -1.000) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}


		}
		else if(humidity > 0.125) {
			if(temperature > 0.666) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalSeasonalForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.500) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalSeasonalForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.000) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.333) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.666) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -1.000) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > 0.000) {
			if(temperature > 0.666) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalSeasonalForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.500) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalSeasonalForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new Chaparral(x,y);
				textureRegion = textureAtlas.findRegion("Chaparral");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.000) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.333) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.666) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -1.000) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}


		}
		else if(humidity > -0.125) {
			if(temperature > 0.666) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.500) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalSeasonalForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new Chaparral(x,y);
				textureRegion = textureAtlas.findRegion("Chaparral");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.000) {
				//return new Steppes(x,y);
				textureRegion = textureAtlas.findRegion("Steppes");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.333) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.666) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -1.000) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > -0.250) {
			if(temperature > 0.666) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.500) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				///return new Chaparral(x,y);
				textureRegion = textureAtlas.findRegion("Chaparral");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.000) {
				//return new Steppes(x,y);
				textureRegion = textureAtlas.findRegion("Steppes");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.333) {
				//return new ColdParklands(x,y);
				textureRegion = textureAtlas.findRegion("ColdParklands");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.666) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -1.000) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > -0.375) {
			if(temperature > 0.666) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.500) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new Chaparral(x,y);
				textureRegion = textureAtlas.findRegion("Chaparral");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.000) {
				//return new CoolDeserts(x,y);
				textureRegion = textureAtlas.findRegion("CoolDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.333) {
				//return new ColdParklands(x,y);
				textureRegion = textureAtlas.findRegion("ColdParklands");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.666) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -1.000) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > -0.500) {
			if(temperature > 0.666) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.000) {
				//return new CoolDeserts(x,y);
				textureRegion = textureAtlas.findRegion("CoolDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.333) {
				//return new ColdParklands(x,y);
				textureRegion = textureAtlas.findRegion("ColdParklands");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.666) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > -0.625) {
			if(temperature > 0.666) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}	
			else if(temperature > 0.333) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.000) {
				//return new CoolDeserts(x,y);
				textureRegion = textureAtlas.findRegion("CoolDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > -0.333) {
				//return new ColdParklands(x,y);
				textureRegion = textureAtlas.findRegion("ColdParklands");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
		}
		else if(humidity > -0.75) {
			if(temperature > 0.666) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.000) {
				//return new CoolDeserts(x,y);
				textureRegion = textureAtlas.findRegion("CoolDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > -0.875) {
			if(temperature > 0.666) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.333) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else{
			if(temperature > 0.666) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}	
	}
	
	public void drawPerlinBiome(SpriteBatch batch, TextureAtlas textureAtlas, TextureRegion textureRegion, double humidity, double temperature, float biomeX, float biomeY) {
		textureRegion = textureAtlas.findRegion("Ice");		
		batch.draw(textureRegion, biomeX, biomeY);
		if(humidity > 0.9375) {
			if(temperature > 0.85) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);		
			}
		else if(humidity > 0.875) {
			if(temperature > 0.85) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
		}
		else if(humidity > 0.8125) {
			if(temperature > 0.85) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.42) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}

		}
		else if(humidity > 0.75) {
			if(temperature > 0.85) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);

			}
			else if(temperature > 0.42) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.28) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}


		}
		else if(humidity > 0.6875) {
			if(temperature > 0.85) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.42) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.28) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.14) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}


		}
		else if(humidity > 0.6250) {
			if(temperature > 0.85) {
				//return new TropicalRainForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalRainForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.42) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.28) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.14) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}


		}
		else if(humidity > 0.5625) {
			if(temperature > 0.85) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalSeasonalForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalSeasonalForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new DeciduousForests(x,y);
				textureRegion = textureAtlas.findRegion("DeciduousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.42) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.28) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.14) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > 0.5) {
			if(temperature > 0.85) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalSeasonalForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalSeasonalForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new Chaparral(x,y);
				textureRegion = textureAtlas.findRegion("Chaparral");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.42) {
				//return new MixedForests(x,y);
				textureRegion = textureAtlas.findRegion("MixedForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.28) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.14) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}


		}
		else if(humidity > 0.4375) {
			if(temperature > 0.85) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new TropicalSeasonalForests(x,y);
				textureRegion = textureAtlas.findRegion("TropicalSeasonalForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new Chaparral(x,y);
				textureRegion = textureAtlas.findRegion("Chaparral");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.42) {
				//return new Steppes(x,y);
				textureRegion = textureAtlas.findRegion("Steppes");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.28) {
				//return new ConiferousForests(x,y);
				textureRegion = textureAtlas.findRegion("ConiferousForests");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.14) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > 0.375) {
			if(temperature > 0.85) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				///return new Chaparral(x,y);
				textureRegion = textureAtlas.findRegion("Chaparral");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.42) {
				//return new Steppes(x,y);
				textureRegion = textureAtlas.findRegion("Steppes");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.28) {
				//return new ColdParklands(x,y);
				textureRegion = textureAtlas.findRegion("ColdParklands");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.14) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > 0.3125) {
			if(temperature > 0.85) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new Chaparral(x,y);
				textureRegion = textureAtlas.findRegion("Chaparral");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.42) {
				//return new CoolDeserts(x,y);
				textureRegion = textureAtlas.findRegion("CoolDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.28) {
				//return new ColdParklands(x,y);
				textureRegion = textureAtlas.findRegion("ColdParklands");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.14) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0) {
				//return new Ice(x,y);
				textureRegion = textureAtlas.findRegion("Ice");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > 0.25) {
			if(temperature > 0.85) {
				//return new Savanna(x,y);
				textureRegion = textureAtlas.findRegion("Savanna");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new CoolDeserts(x,y);
				textureRegion = textureAtlas.findRegion("CoolDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.42) {
				//return new ColdParklands(x,y);
				textureRegion = textureAtlas.findRegion("ColdParklands");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.28) {
				//return new Tundra(x,y);
				textureRegion = textureAtlas.findRegion("Tundra");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > 0.1875) {
			if(temperature > 0.85) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}	
			else if(temperature > 0.71) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new CoolDeserts(x,y);
				textureRegion = textureAtlas.findRegion("CoolDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.42) {
				//return new ColdParklands(x,y);
				textureRegion = textureAtlas.findRegion("ColdParklands");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
		}
		else if(humidity > 0.125) {
			if(temperature > 0.85) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.71) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.57) {
				//return new CoolDeserts(x,y);
				textureRegion = textureAtlas.findRegion("CoolDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else if(humidity > 0.0625) {
			if(temperature > 0.81) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}
			else if(temperature > 0.75) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}
		else{
			if(temperature > 0.81) {
				//return new HotDeserts(x,y);
				textureRegion = textureAtlas.findRegion("HotDeserts");		
				batch.draw(textureRegion, biomeX, biomeY);
			}

		}	
	}
}
