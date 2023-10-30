package malikjg.biomemap;

import java.util.Random;

import malikjg.noise.DistanceFormula;
import malikjg.noise.Noise;
import malikjg.noise.perlin.PerlinNoise;
import malikjg.noise.perlin.PerlinNoiseGenerator;
import malikjg.noise.voronoi.VoronoiNoise;
import malikjg.noise.voronoi.VoronoiNoiseGenerator;
import malikjg.noise.white.WhiteNoiseGenerator;

public class BiomeMapGenerator{
	//private VoronoiNoise voronoiNoise;
	//private long seedVoronoi;
	
	private String noise;
	private int height;
	private int width;
	private long seed;
	private double noiseMask;
	private int frequency;
	private int octaves;
	private double persistence;
	private double lacunarity;
	private DistanceFormula distanceFormula;
	
	private Noise humidity;
	private long seedPerlinHumidity;
	private Noise temperature;
	private long seedPerlinTemperature;
	
	private double seedHumidity;
	private double seedTemperature;
	
	private NoiseGenerator noiseHumidity;
	private NoiseGenerator noiseTemperature;
	private double[][] humidityNoise;
	private double[][] temperatureNoise;
	
	public BiomeMapGenerator(String noise, int height, int width, long seed, double noiseMask, int frequency, int octaves, double persistence, double lacunarity, DistanceFormula distanceFormula){
		this.noise = noise;
		this.height = height;
		this.width = width;
		this.seed = seed;
		this.frequency = frequency;
		this.octaves = octaves;
		this.persistence = persistence;
		this.lacunarity = lacunarity;
		this.distanceFormula = distanceFormula;
		
		if(this.seed == -1) {
			seed = (long) (new Random().nextGaussian() * 255);
		}
		
		if(noise.equals("Noise")){
			seedHumidity = new Random().nextGaussian() * 255;
			seedTemperature = new Random().nextGaussian() + 255;
			noiseHumidity = new NoiseGenerator(seedHumidity);
			noiseTemperature = new NoiseGenerator(seedTemperature);
			humidityNoise = new double[width][height];
			temperatureNoise = new double[width][height];
			generateNoise();
		}
		else if(noise.equals("Perlin")){
			generatePerlin();	
		}
		else if(noise.equals("Voronoi")) {
			generateVoronoi();
		}
		else if(noise.equals("White")) {
			generateWhiteNoise();
		}
		
	}	
	public void generatePerlin(){
		seedPerlinHumidity = (long)(new Random().nextGaussian() * 255);
		humidity = new PerlinNoiseGenerator()
				.height(height)
				.width(width)
				.seed(seed)
				.noiseMask(noiseMask)
				.frequency(frequency)
				.octaves(octaves)
				.persistence(persistence)
				.lacunarity(lacunarity)
				.generate();
		seedPerlinTemperature = (long)(new Random().nextGaussian() * 255);
		temperature = new PerlinNoiseGenerator()
				.height(height)
				.width(width)
				.seed(seed)
				.noiseMask(noiseMask)
				.frequency(frequency)
				.octaves(octaves)
				.persistence(persistence)
				.lacunarity(lacunarity)
				.generate();
	}
	public void generateVoronoi() {
		humidity = new VoronoiNoiseGenerator()
				.height(height)
				.width(width)
				.seed(seed)
				.noiseMask(noiseMask)
				.distanceFormula(distanceFormula)
				.frequency(frequency)
				.generate();
		temperature = new VoronoiNoiseGenerator()
				.height(height)
				.width(width)
				.seed(seed)
				.noiseMask(noiseMask)
				.distanceFormula(distanceFormula)
				.frequency(frequency)
				.generate();
	}
	public void generateWhiteNoise() {
		humidity = new WhiteNoiseGenerator()
				.height(height)
				.width(width)
				.seed(seed)
				.noiseMask(noiseMask)
				.generate();
		temperature = new WhiteNoiseGenerator()
				.height(height)
				.width(width)
				.seed(seed)
				.noiseMask(noiseMask)
				.generate();
	}
	
	public double[][] getHumidity(){
		return humidity.getNoise();
	}
	public double[][] getTemperature(){
		return temperature.getNoise();
	}
	public int getWidth(){
		return this.width;
	}
	public int getHeight(){
		return this.height;
	}
	public String getNoise() {
		return this.noise;
	}
	
	
	
	public void generateNoise() {
		for(int i = width / 2 - 1; i  >= -width / 2 ; i--) {
			for(int j = height / 2 - 1; j >= -height / 2 ; j--) {
				double nx = i;
				double ny = j;
				double humidity = (1.0 * noiseHumidity.noise(1 * nx, 1 * ny));
				double temperature = (1.0 * noiseTemperature.noise(1 * nx, 1 * ny));
				if(octaves == 1) {
					humidity = humidity / (1.0);
					temperature = temperature / (1.0);
				}
				if(octaves == 2) {
					humidity = humidity + (0.5 * noiseHumidity.noise(2 * nx, 2 * ny));
					temperature = temperature + (0.5 * noiseTemperature.noise(2 * nx, 2 * ny));
					humidity = humidity / (1.0 + 0.5);
					temperature = temperature / (1.0 + 0.5);
				}
				if(octaves == 3) {
					humidity = humidity + (0.25 * noiseHumidity.noise(4 * nx, 4 * ny));
					temperature = temperature + (0.25 * noiseTemperature.noise(4 * nx, 4 * ny));
					humidity = humidity / (1.0 + 0.5 + 0.25);
					temperature = temperature / (1.0 + 0.5 + 0.25);
				}
				if(octaves == 4) {
					humidity = humidity + (0.13 * noiseHumidity.noise(8 * nx, 8 * ny));
					temperature = temperature + (0.13 * noiseTemperature.noise(8 * nx, 8 * ny));
					humidity = humidity / (1.0 + 0.5 + 0.25 + 0.13);
					temperature = temperature / (1.0 + 0.5 + 0.25 + 0.13);
				}
				if(octaves == 5) {
					humidity = humidity + (0.06 * noiseHumidity.noise(16 * nx, 16 * ny));
					temperature = temperature + (0.06 * noiseTemperature.noise(16 * nx, 16 * ny));	
					humidity = humidity / (1.0 + 0.5 + 0.25 + 0.13 + 0.06);
					temperature = temperature / (1.0 + 0.5 + 0.25 + 0.13 + 0.06);
				}
				if(octaves == 6) {
					humidity = humidity + (0.03 * noiseHumidity.noise(32 * nx, 32 * ny));
					temperature = temperature + (0.03 * noiseTemperature.noise(32 * nx, 32 * ny));
					humidity = humidity / (1.0 + 0.5 + 0.25 + 0.13 + 0.06 + 0.03);
					temperature = temperature / (1.0 + 0.5 + 0.25 + 0.13 + 0.06 + 0.03);
				}
				humidityNoise[i + width / 2][j + height / 2] = humidity;
				temperatureNoise[i + width / 2][j + height / 2] = temperature;
			}
		}
	}
	public double[][] getHumidityNoise(){
		return humidityNoise;
	}
	public double[][] getTemperatureNoise(){
		return temperatureNoise;
	}
}
