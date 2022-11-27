package pong;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class TITLESCREEN extends JFrame {

	public class TSMusic {

		//Music
		void playMusic(String musicLocation) {
			try {
				File musicPath = new File(musicLocation);
				
				if(musicPath.exists()) {
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
					Clip clip = AudioSystem.getClip();
					clip.open(audioInput);
					clip.start();
					clip.loop(clip.LOOP_CONTINUOUSLY);
					//JOptionPane.showMessageDialog(null, "Press OK To Stop Music");
				} else {
					System.out.println("Can't find File");
				}
				
			} catch (Exception e) {
				//Remember
				e.printStackTrace();
			}
		}

	}

	private JPanel contentPane;
	private JLabel GameName;
	private JLabel EnterLabel;
	private JLabel PauseLabel;
	private JLabel GameType;

	/**
	 * Create the frame.
	 */
	public TITLESCREEN() {
		
		setFont(new Font("Constantia", Font.ITALIC, 12));
		setTitle("PONG GAME");
		setBackground(new Color(0, 0, 0));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 383);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		GameName = new JLabel();
		GameName.setBorder(null);
		GameName.setBounds(10, 11, 551, 65);
		GameName.setForeground(new Color(255, 255, 255));
		GameName.setHorizontalAlignment(SwingConstants.CENTER);
		GameName.setBackground(new Color(0, 0, 64));
		GameName.setFont(new Font("Constantia", Font.BOLD, 40));
		GameName.setText("PONG");
		contentPane.add(GameName);
		
		EnterLabel = new JLabel();
		EnterLabel.setFont(new Font("Consolas", Font.PLAIN, 22));
		EnterLabel.setBorder(null);
		EnterLabel.setBackground(new Color(0, 0, 64));
		EnterLabel.setForeground(new Color(255, 255, 255));
		EnterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EnterLabel.setText("PRESS ENTER TO UNPAUSE OR RANDOMIZE BALL");
		EnterLabel.setBounds(10, 139, 551, 53);
		contentPane.add(EnterLabel);
		
		PauseLabel = new JLabel();
		PauseLabel.setFont(new Font("Consolas", Font.PLAIN, 25));
		PauseLabel.setBorder(null);
		PauseLabel.setText("PRESS SHIFT TO PAUSE");
		PauseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PauseLabel.setForeground(Color.WHITE);
		PauseLabel.setBackground(new Color(0, 0, 64));
		PauseLabel.setBounds(10, 103, 551, 41);
		contentPane.add(PauseLabel);
		
		JButton playbtn = new JButton("Play");
		playbtn.setBorderPainted(false);
		playbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		playbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PongGame obj=new PongGame();
				String[] args = {};
				obj.main(args);
				dispose();
				
			}
		});
		playbtn.setFont(new Font("Consolas", Font.BOLD, 17));
		playbtn.setForeground(new Color(255, 255, 255));
		playbtn.setOpaque(true);
		playbtn.setBackground(new Color(64, 0, 128));
		playbtn.setBounds(160, 245, 240, 70);
		contentPane.add(playbtn);
		
		GameType = new JLabel();
		GameType.setText("TWO PLAYER GAME");
		GameType.setHorizontalAlignment(SwingConstants.CENTER);
		GameType.setForeground(new Color(255, 0, 0));
		GameType.setFont(new Font("Consolas", Font.PLAIN, 25));
		GameType.setBorder(null);
		GameType.setBackground(new Color(0, 0, 64));
		GameType.setBounds(10, 203, 546, 41);
		contentPane.add(GameType);
		
		JLabel wsad = new JLabel("W,S,A,D");
		wsad.setHorizontalAlignment(SwingConstants.CENTER);
		wsad.setFont(new Font("Tahoma", Font.BOLD, 21));
		wsad.setForeground(new Color(255, 0, 0));
		wsad.setBounds(26, 272, 96, 43);
		contentPane.add(wsad);
		
		JLabel arrows = new JLabel("ARROWS");
		arrows.setHorizontalAlignment(SwingConstants.CENTER);
		arrows.setForeground(Color.RED);
		arrows.setFont(new Font("Tahoma", Font.BOLD, 21));
		arrows.setBounds(439, 272, 96, 43);
		contentPane.add(arrows);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String filepath = "password-infinity-123276.wav";
		TITLESCREEN frame = new TITLESCREEN();
		TITLESCREEN.TSMusic musicObject = frame.new TSMusic();
		musicObject.playMusic(filepath);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TITLESCREEN frame = new TITLESCREEN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
