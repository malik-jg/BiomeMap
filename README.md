# BiomeMap

The BiomeMap program allows the user to utilize various noise functions to create visual maps of biomes. Currently, the only fully implemented visualizer is the *Noise* generator. While the other noise functions work mathematically, assets have not been created to make them look visually pleasing. Although, the user can still create biome maps using them. 

## GUI for BiomeMap
![Screenshot (295)](https://github.com/malik-jg/BiomeMap/assets/119100640/b7605eaa-2393-4044-861c-052aa08dee8b)

The GUI for the BiomeMap program allows the user to select from 4 different noise functions: Noise, Perlin, Voronoi, and White. The **What Do These Mean** button gives more information on each field. If an invalid answer is input into the text field, the user will be informed of what values are valid for the field. Hitting the **Generate** button opens a new window where the map will be generated. ***It is advised not to input values of over 2000 for height and width.***

### Controls

After hitting generate, the user can zoom in and zoom out the camera using **Q** and **E** on their keyboard. The user can also move the camera using **WASD**. After generating the map, the user can close the window where the map was generated and simply generate a new biome map with different inputs.


## Generation of Biome Maps

Each noise function returns a range of values that are stored in an array. In this implementation, values are stored in an array holding values for humidity and an array holding values for temperature. The following graphic from [World Engine](https://worldengine.readthedocs.io/en/latest/biomes.html) is how each value of humidity and temperature is mapped to a biome. 


![BIOMES](https://github.com/malik-jg/BiomeMap/assets/119100640/454eff07-69dd-4df9-88a0-36758c3da1ca)

Each map is generated from top-to-down, right-to-left from an isometric view. 

## Noise BiomeMap
![Screenshot (291)](https://github.com/malik-jg/BiomeMap/assets/119100640/01be9ad3-532c-4d0d-a9ef-3f0cc3b8e260)

The image above is a biome map generated using the *Noise* option. It is similar to the *Perlin* function, where the only difference is the *Noise* function returns values approximately in the range [-1.2,1.2], whereas *Perlin* is limited to [0,1]. A larger range allows for a much larger variety of biomes to be generated. 

## Perlin BiomeMap
![Screenshot (293)](https://github.com/malik-jg/BiomeMap/assets/119100640/4d5b132d-7da0-4402-9521-c915a36fd282)

The image above is a biome map generated using the *Perlin* option. As noted before, the Perlin function returns a smaller range of values which results in missing biomes or very small biomes. A future update looks to rework this and create new tile colors.

## Voronoi BiomeMap
![Screenshot (294)](https://github.com/malik-jg/BiomeMap/assets/119100640/3aa65482-9bcf-460b-b9b7-3da355c05bd6)

The image above is a biome map generated using the *Voronoi* option. This noise function is used to generate islands and landmasses in bodies of water. A future update will add a *Water* tile and improve the look of the generation.

## White Noise BiomeMap
![Screenshot (296)](https://github.com/malik-jg/BiomeMap/assets/119100640/9711c94f-9c46-4092-a612-85129d9a2316)

The image above is a biome map generated using the *White* option. It generates white noise, typically seen as a gradient of white to black colors. A future update will add a gradient of black-to-white tiles to improve the look of the generation.

## Final Notes

Currently, I am working to add an elevation factor that can be used to create a visual representation of mountains and valleys. For now, colder biomes tend to represent higher elevations and hotter biomes represent lower elevations. When an elevation factor is added, the camera will be updated to be able to rotate horizontally and vertically. 

Thanks to [Christopherwmm](https://github.com/ChristopherWMM) for providing the additional *Perlin*, *Voronoi*, and *White* noise functions. While those three functions are not fully visualized yet, they can still be generated using my generic *Noise* function.
