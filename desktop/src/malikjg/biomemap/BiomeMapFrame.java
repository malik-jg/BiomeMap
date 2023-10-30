
package malikjg.biomemap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
/**
 *
 * @author milky
 */
public class BiomeMapFrame extends JFrame {
	private JLabel distanceFormulaLabel;
	private JComboBox<String> distanceFormulaTypes;
	private JTextField frequencyInput;
	private JLabel frequencyLabel;
	private JButton generateButton;
	private JTextField heightInput;
	private JLabel heightLabel;
	private JPanel homeScreen;
	private JTextField lacunarityInput;
	private JLabel lacunarityLabel;
	private JTextField noiseMaskInput;
	private JLabel noiseMaskLabel;
	private JLabel noiseTypeLabel;
	private JComboBox<String> noiseTypes;
	private JTextField octavesInput;
	private JLabel octavesLabel;
	private JTextField persistenceInput;
	private JLabel persistenceLabel;
	private JButton questionButton;
	private JRadioButton randomizeSeed;
	private JTextField seedInput;
	private JLabel seedLabel;
	private JTextField widthInput;
	private JLabel widthLabel;
    public BiomeMapFrame() {
        initComponents();
    }                      
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        homeScreen = new JPanel();
        noiseTypeLabel = new JLabel();
        noiseTypes = new JComboBox<>();
        heightLabel = new JLabel();
        heightInput = new JTextField();
        widthLabel = new JLabel();
        widthInput = new JTextField();
        seedLabel = new JLabel();
        seedInput = new JTextField();
        randomizeSeed = new JRadioButton();
        noiseMaskLabel = new JLabel();
        noiseMaskInput = new JTextField();
        frequencyLabel = new JLabel();
        frequencyInput = new JTextField();
        octavesLabel = new JLabel();
        octavesInput = new JTextField();
        persistenceLabel = new JLabel();
        persistenceInput = new JTextField();
        lacunarityLabel = new JLabel();
        lacunarityInput = new JTextField();
        distanceFormulaLabel = new JLabel();
        distanceFormulaTypes = new JComboBox<>();
        generateButton = new JButton();
        questionButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1280, 720));
        setMinimumSize(new Dimension(1280, 720));

        homeScreen.setBackground(new Color(165, 165, 255));
        homeScreen.setForeground(new Color(0, 0, 0));
        homeScreen.setMaximumSize(new Dimension(1280, 720));
        homeScreen.setMinimumSize(new Dimension(1280, 720));
        homeScreen.setLayout(new GridBagLayout());

        noiseTypeLabel.setBackground(new Color(255, 255, 255));
        noiseTypeLabel.setFont(new Font("Georgia", 0, 18)); 
        noiseTypeLabel.setForeground(new Color(0, 0, 0));
        noiseTypeLabel.setText("Noise Type");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        homeScreen.add(noiseTypeLabel, gridBagConstraints);

        noiseTypes.setBackground(new Color(204, 204, 255));
        noiseTypes.setFont(new Font("Georgia", 0, 18)); 
        noiseTypes.setForeground(new Color(0, 0, 0));
        noiseTypes.setModel(new DefaultComboBoxModel<>(new String[] { "Noise", "Perlin", "Voronoi", "White" }));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        homeScreen.add(noiseTypes, gridBagConstraints);

        heightLabel.setBackground(new Color(255, 255, 255));
        heightLabel.setFont(new Font("Georgia", 0, 18)); 
        heightLabel.setForeground(new Color(0, 0, 0));
        heightLabel.setText("Height");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        homeScreen.add(heightLabel, gridBagConstraints);

        heightInput.setBackground(new Color(204, 204, 255));
        heightInput.setFont(new Font("Georgia", 0, 18)); 
        heightInput.setForeground(new Color(0, 0, 0));
        heightInput.setText("0");
        heightInput.setMaximumSize(new Dimension(64, 32));
        heightInput.setMinimumSize(new Dimension(64, 32));
        heightInput.setPreferredSize(new Dimension(64, 32));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        homeScreen.add(heightInput, gridBagConstraints);

        widthLabel.setBackground(new Color(255, 255, 255));
        widthLabel.setFont(new Font("Georgia", 0, 18)); 
        widthLabel.setForeground(new Color(0, 0, 0));
        widthLabel.setText("Width");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        homeScreen.add(widthLabel, gridBagConstraints);

        widthInput.setBackground(new Color(204, 204, 255));
        widthInput.setFont(new Font("Georgia", 0, 18)); 
        widthInput.setForeground(new Color(0, 0, 0));
        widthInput.setText("0");
        widthInput.setMaximumSize(new Dimension(64, 32));
        widthInput.setMinimumSize(new Dimension(64, 32));
        widthInput.setPreferredSize(new Dimension(64, 32));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        homeScreen.add(widthInput, gridBagConstraints);

        seedLabel.setBackground(new Color(255, 255, 255));
        seedLabel.setFont(new Font("Georgia", 0, 18)); 
        seedLabel.setForeground(new Color(0, 0, 0));
        seedLabel.setText("Seed");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        homeScreen.add(seedLabel, gridBagConstraints);

        seedInput.setBackground(new Color(204, 204, 255));
        seedInput.setFont(new Font("Georgia", 0, 18)); 
        seedInput.setForeground(new Color(0, 0, 0));
        seedInput.setText("0");
        seedInput.setMaximumSize(new Dimension(64, 32));
        seedInput.setMinimumSize(new Dimension(64, 32));
        seedInput.setPreferredSize(new Dimension(64, 32));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        homeScreen.add(seedInput, gridBagConstraints);

        randomizeSeed.setBackground(new Color(165, 165, 255));
        randomizeSeed.setFont(new Font("Georgia", 0, 18)); 
        randomizeSeed.setForeground(new Color(0, 0, 0));
        randomizeSeed.setText("Randomize Seed");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        homeScreen.add(randomizeSeed, gridBagConstraints);

        noiseMaskLabel.setBackground(new Color(204, 204, 255));
        noiseMaskLabel.setFont(new Font("Georgia", 0, 18)); 
        noiseMaskLabel.setForeground(new Color(0, 0, 0));
        noiseMaskLabel.setText("Noise Mask");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        homeScreen.add(noiseMaskLabel, gridBagConstraints);

        noiseMaskInput.setBackground(new Color(204, 204, 255));
        noiseMaskInput.setFont(new Font("Georgia", 0, 18));
        noiseMaskInput.setForeground(new Color(0, 0, 0));
        noiseMaskInput.setText("0");
        noiseMaskInput.setMaximumSize(new Dimension(64, 32));
        noiseMaskInput.setMinimumSize(new Dimension(64, 32));
        noiseMaskInput.setPreferredSize(new Dimension(64, 32));
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        homeScreen.add(noiseMaskInput, gridBagConstraints);

        frequencyLabel.setBackground(new Color(255, 255, 255));
        frequencyLabel.setFont(new Font("Georgia", 0, 18));
        frequencyLabel.setForeground(new Color(0, 0, 0));
        frequencyLabel.setText("Frequency");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        homeScreen.add(frequencyLabel, gridBagConstraints);

        frequencyInput.setBackground(new Color(204, 204, 255));
        frequencyInput.setFont(new Font("Georgia", 0, 18));
        frequencyInput.setForeground(new Color(0, 0, 0));
        frequencyInput.setText("0");
        frequencyInput.setMaximumSize(new Dimension(64, 32));
        frequencyInput.setMinimumSize(new Dimension(64, 32));
        frequencyInput.setPreferredSize(new Dimension(64, 32));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        homeScreen.add(frequencyInput, gridBagConstraints);

        octavesLabel.setBackground(new Color(255, 255, 255));
        octavesLabel.setFont(new Font("Georgia", 0, 18)); 
        octavesLabel.setForeground(new Color(0, 0, 0));
        octavesLabel.setText("Octaves");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        homeScreen.add(octavesLabel, gridBagConstraints);

        octavesInput.setBackground(new Color(204, 204, 255));
        octavesInput.setFont(new Font("Georgia", 0, 18)); 
        octavesInput.setForeground(new Color(0, 0, 0));
        octavesInput.setText("0");
        octavesInput.setMaximumSize(new Dimension(64, 32));
        octavesInput.setMinimumSize(new Dimension(64, 32));
        octavesInput.setPreferredSize(new Dimension(64, 32));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        homeScreen.add(octavesInput, gridBagConstraints);

        persistenceLabel.setBackground(new Color(204, 204, 255));
        persistenceLabel.setFont(new Font("Georgia", 0, 18)); 
        persistenceLabel.setForeground(new Color(0, 0, 0));
        persistenceLabel.setText("Persistence");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        homeScreen.add(persistenceLabel, gridBagConstraints);

        persistenceInput.setBackground(new Color(204, 204, 255));
        persistenceInput.setFont(new Font("Georgia", 0, 18)); 
        persistenceInput.setForeground(new Color(0, 0, 0));
        persistenceInput.setText("0");
        persistenceInput.setMaximumSize(new Dimension(64, 32));
        persistenceInput.setMinimumSize(new Dimension(64, 32));
        persistenceInput.setPreferredSize(new Dimension(64, 32));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        homeScreen.add(persistenceInput, gridBagConstraints);

        lacunarityLabel.setBackground(new Color(255, 255, 255));
        lacunarityLabel.setFont(new Font("Segoe UI", 0, 18)); 
        lacunarityLabel.setForeground(new Color(0, 0, 0));
        lacunarityLabel.setText("Lacunarity");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        homeScreen.add(lacunarityLabel, gridBagConstraints);

        lacunarityInput.setBackground(new Color(204, 204, 255));
        lacunarityInput.setFont(new Font("Georgia", 0, 18)); 
        lacunarityInput.setForeground(new Color(0, 0, 0));
        lacunarityInput.setText("0");
        lacunarityInput.setMaximumSize(new Dimension(64, 32));
        lacunarityInput.setMinimumSize(new Dimension(64, 32));
        lacunarityInput.setPreferredSize(new Dimension(64, 32));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        homeScreen.add(lacunarityInput, gridBagConstraints);

        distanceFormulaLabel.setBackground(new Color(255, 255, 255));
        distanceFormulaLabel.setFont(new Font("Georgia", 0, 18)); 
        distanceFormulaLabel.setForeground(new Color(0, 0, 0));
        distanceFormulaLabel.setText("Distance Formula");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        homeScreen.add(distanceFormulaLabel, gridBagConstraints);

        distanceFormulaTypes.setBackground(new Color(204, 204, 255));
        distanceFormulaTypes.setFont(new Font("Georgia", 0, 18)); 
        distanceFormulaTypes.setForeground(new Color(0, 0, 0));
        distanceFormulaTypes.setModel(new DefaultComboBoxModel<>(new String[] { "Euclidean", "Manhattan", "Minkowski", "Chebyshev" }));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        homeScreen.add(distanceFormulaTypes, gridBagConstraints);

        generateButton.setBackground(new Color(204, 204, 255));
        generateButton.setFont(new Font("Georgia", 1, 24)); 
        generateButton.setForeground(new Color(0, 0, 0));
        generateButton.setText("Generate");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.weighty = 0.1;
        homeScreen.add(generateButton, gridBagConstraints);

        questionButton.setBackground(new Color(204, 204, 255));
        questionButton.setFont(new Font("Georgia", 1, 24)); 
        questionButton.setForeground(new Color(0, 0, 0));
        questionButton.setText("What Do These Mean?");
        questionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                questionButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.weighty = 0.1;
        homeScreen.add(questionButton, gridBagConstraints);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(homeScreen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(homeScreen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                                                                
    private void generateButtonActionPerformed(ActionEvent evt) {                                               
        String noise = (String) noiseTypes.getSelectedItem();
        String distanceFormula = (String) distanceFormulaTypes.getSelectedItem();
        try{
            int height = Integer.parseInt(heightInput.getText());
            int width = Integer.parseInt(widthInput.getText());
            if(height <= 0 || width <= 0){
                throw new DimensionsException();
            }
            long seed = Long.parseLong(seedInput.getText());
            if(seed < 0){
                throw new SeedException();
            }
            if(randomizeSeed.isSelected()){
                seed = -1;
            }
            double noiseMask = Double.parseDouble(noiseMaskInput.getText());
            if(noiseMask < 0 || noiseMask > 1){
                throw new NoiseMaskException();
            }
            int frequency = Integer.parseInt(frequencyInput.getText());
            int octaves = Integer.parseInt(octavesInput.getText());
            double persistence = Double.parseDouble(persistenceInput.getText());
            double lacunarity = Double.parseDouble(lacunarityInput.getText());
            if(frequency <= 0 || octaves <= 0 || persistence <= 0 || persistence > 1 || lacunarity <= 0){
                throw new NoiseFactorsException();
            }
            
            
            Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
    		config.setForegroundFPS(60);
    		config.setWindowedMode(BiomeMapScreen.WIDTH,BiomeMapScreen.HEIGHT);
    		config.setTitle("BiomeMap");
    		new Lwjgl3Application(new BiomeMap(noise, height, width, seed, noiseMask, frequency, octaves, persistence, lacunarity, distanceFormula), config);
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Height, Width, Frequency and Octaves Must Be Integers. Seed must be Long. Noise Mask, Persistence and Lacunarity must be Doubles.");
        }
        catch(DimensionsException ex){
            JOptionPane.showMessageDialog(this, "Height and Width must be a non-zero, positive integer.");
        }
        catch(SeedException ex){
            JOptionPane.showMessageDialog(this, "Seed must be a positive integer.");
        }
        catch(NoiseMaskException ex){
            JOptionPane.showMessageDialog(this, "Noise Mask must be between 0 and 1.");
        }
        catch(NoiseFactorsException ex){
            JOptionPane.showMessageDialog(this, "Frequency, Octaves, and Lacunarity must be non-zero, positive integer. Persistence must be non-zero between 0 and 1");
        }
    }                                              
    private void questionButtonActionPerformed(ActionEvent evt) {                                               
        JOptionPane.showMessageDialog(this, "Noise: The type of Noise to be used. Noise is a generic noise function\n"
                                                      + "Height: The Height of BiomeMap\n"
                                                      + "Width: The Width of BiomeMap\n"
                                                      + "Seed: Number used to pseudorandomize generation of BiomeMap\n"
                                                      + "Noise Mask: Conceals noise by a factor\n"
                                                      + "Frequency: Number of peaks and troughs in a noise map (only Perlin and Voronoi)\n"
                                                      + "Octave: Compounds noise layers (only Perlin and Generic)\n"
                                                      + "Persistence: Amplitude multiplier between subsequent octaves (only Perlin)\n"
                                                      + "Lacunarity: Frequency multiplier between subsequent octaves (only Perlin)\n"
                                                      + "Distance Formula: Method for calculating distance (only Voronoi)");
    }                                              
    public static void start() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BiomeMapFrame().setVisible(true);
            }
        });
    }           
}
