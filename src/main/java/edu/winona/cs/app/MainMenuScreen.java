package edu.winona.cs.app;

import edu.winona.cs.component.GameSession;
import edu.winona.cs.db.DatabaseManager;
import edu.winona.cs.db.HighScoreTable;
import edu.winona.cs.db.SaveStateTable;

import java.awt.Container;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.apache.commons.io.IOUtils;

/**
 * Main Menu Screen
 * JFrame used for Main Menu.
 * Includes pathway to:
 * 	New Game
 * 	Load Game
 * 	High Scores
 * 	Game Settings
 * 	Logout
 * 
 * @author Erika Tix and Kyle Aure
 * @version 1.0
 *
 */
public class MainMenuScreen extends JFrame {
	//Used for serializing MainMenuScreen
	private static final long serialVersionUID = 8807260843644535683L;
	
	//Database Manager
	private DatabaseManager dbm = DatabaseManager.getDatabaseManager();

	/**
	 * Constructor for MainMenuScreen class
	 * Sets up internal components.
	 * Sets up user's preferred background color.
	 */
    public MainMenuScreen() {
        //Step 1: Initialize Components
    	initComponents();
        
    	//Step 2: setBackground using users preferences
        Container a = MainMenuScreen.this.getContentPane();
        if(App.isSettingsSet()) {
        	a.setBackground(App.getSettings().getBackgroundColor());
        } else {
        	a.setBackground(App.DEFAULT_SETTINGS.getBackgroundColor());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        loadBtn = new javax.swing.JButton();
        highscoreBtn = new javax.swing.JButton();
        gameSettingsBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        playGameBtn = new javax.swing.JButton();
        lblSlidingIcon = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loadBtn.setText("LOAD GAME");
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    loadBtnActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(MainMenuScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        highscoreBtn.setText("CHECK HIGHSCORES");
        highscoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highscoreBtnActionPerformed(evt);
            }
        });

        gameSettingsBtn.setText("GAME SETTINGS");
        gameSettingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameSettingsBtnActionPerformed(evt);
            }
        });

        logoutBtn.setText("LOGOUT");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        playGameBtn.setText("PLAY NEW GAME");
        playGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playGameBtnActionPerformed(evt);
            }
        });

        lblSlidingIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSlidingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sliding.gif"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        if(App.isUser()) {
        	lblTitle.setText("WELCOME " + App.getUsername() + "!");
        } else {
        	lblTitle.setText("WELCOME GUEST!");
        }
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(playGameBtn, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
        							.addGap(40)
        							.addComponent(loadBtn, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(highscoreBtn, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
        							.addGap(40)
        							.addComponent(gameSettingsBtn, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
        					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblSlidingIcon, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        					.addGap(25))))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(145, Short.MAX_VALUE)
        			.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
        			.addGap(114))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(14)
        			.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        			.addGap(62)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(playGameBtn, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        				.addComponent(loadBtn, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
        			.addGap(22)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(highscoreBtn, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        				.addComponent(gameSettingsBtn, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(43)
        					.addComponent(lblSlidingIcon, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(24, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**    
     * Clicked Play New Game button
     * @param evt - Button Click
     */
    private void playGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playGameBtnActionPerformed
    	boolean startNewGame = false;
    	
    	//Step 1: Check if we are dealing with a user or guest
    	if(App.isUser()) {
        	//Step 1.1: Check if user has previous game saved
        	SaveStateTable sst = dbm.getSaveStateTable();
        	File saveState = sst.getSaveState(App.getUsername());
        	
        	//Step 1.2: If there is no saved game then start new game, else warn user.
        	if(saveState == null) {
        		startNewGame = true;
        	} else {
        		int result = JOptionPane.showConfirmDialog(null, 
        				"Starting a new game will overwrite your existing game. \nContinue?", 
        				"Overwriting Saved Game", 
        				JOptionPane.YES_NO_OPTION, 
        				JOptionPane.WARNING_MESSAGE);
        		if(result == JOptionPane.YES_OPTION) {
        			startNewGame = true;
        		} else {
        			startNewGame = false;
        		}
        	}
    	} else {
    		startNewGame = true;
    	}
    	
    	//Step 2: If user is starting a new game display Game Settings
    	if(startNewGame) {
    		NewGameSettings gameSettings = new NewGameSettings();
    	    gameSettings.setVisible(true);
    	    this.dispose();
    	}
    	
    	//Step 3: Dispose this
    	this.dispose();
    	
    }//GEN-LAST:event_playGameBtnActionPerformed

    
    /**
     * Clicked Load Button
     * @param evt - Button Click
     */
    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_loadBtnActionPerformed
    	//Step 1: Check if we are dealing with a user or guest
    	if(App.isUser()) {
    		//Step 1.1: Get saved state
    		SaveStateTable sst = dbm.getSaveStateTable();
        	File saveState = sst.getSaveState(App.getUsername());
        	
        	if(saveState == null) {
        		JOptionPane.showMessageDialog(null, "We were unable to locate a saved game.", "Saved Game Warning", JOptionPane.WARNING_MESSAGE);
        		return;
        	}
        	
        	//Step 1.2 get session
        	Jsonb jsonb = JsonbBuilder.create();
        	InputStream is = new FileInputStream(saveState.getAbsolutePath());
            String jsonTxt = IOUtils.toString(is, "UTF-8");
            GameSession session = jsonb.fromJson(jsonTxt, GameSession.class);
            App.setGameSession(session);
            
            //Step 1.3 notify app - not a new game
            App.setNewGame(false);
            
          
        	//Step 1.4: Open Game Screen
        	GameScreen game = new GameScreen();
        	game.setVisible(true);
        	
        	//Step 1.5: dispose this
        	this.dispose();
    		
    	} else {
    		JOptionPane.showMessageDialog(null, "You need to be logged in to load a saved game.", "Guest Warning", JOptionPane.WARNING_MESSAGE);
    	}
    }//GEN-LAST:event_loadBtnActionPerformed

    /**
     * Click High Scores Button
     * @param evt - Button Click
     */
    private void highscoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highscoreBtnActionPerformed
    	//Step 1: Check if we are dealing with a user or guest
    	if(App.isUser()) {
    		//Step 1.1: Get users previous high score
        	HighScoreTable hst = dbm.getScoreTable();
        	int highscore = hst.getHighScore(App.getUsername());
        	
        	//Step 1.2: Display high score if it was retrieved from database, otherwise encourage user to play. 
        	if(highscore != -1) {
                ImageIcon icon = new ImageIcon("src/main/resources/trophy.jpg");
                JOptionPane.showMessageDialog(null, "Your current high-score is: " + highscore, "HIGH-SCORE!", JOptionPane.INFORMATION_MESSAGE, icon);       		
        	} else {
        		JOptionPane.showMessageDialog(null, "You currently do not have any high scores. \nPlay a game and check back later!", "HIGH-SCORE!", JOptionPane.INFORMATION_MESSAGE);
        	}

    	} else {
    		JOptionPane.showMessageDialog(null, "You need to be logged in to view high score data.", "Guest Warning", JOptionPane.WARNING_MESSAGE);
    	}
    }//GEN-LAST:event_highscoreBtnActionPerformed

    
    /**
     * Click Game Settings Button
     * @param evt - Button Click
     */
    private void gameSettingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameSettingsBtnActionPerformed
        //Step 1: Show GameSettingsMenu
    	if(App.isUser()) {
    		Settings settingsMenu = new Settings();
        	settingsMenu.setVisible(true);
        	
        	//Step 2: Dispose this
        	this.dispose();
    	} else {
    		JOptionPane.showMessageDialog(null, "You need to be logged in to personalize game settings.", "Guest Warning", JOptionPane.WARNING_MESSAGE);
    	}

    	
    }//GEN-LAST:event_gameSettingsBtnActionPerformed

    /**
     * Click Logout button 
     * @param evt - Button Click
     */
    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
    	//Step 1: Close this window
        this.dispose();
        
        //Step 2: Reset APP settings
        App.setUsername(null);
        App.setSettings(null);
        
        //Step 3: Open login screen
        LoginScreen ls = new LoginScreen();
        ls.setVisible(true);
        
        //Step 4: dispose this
        this.dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gameSettingsBtn;
    private javax.swing.JButton highscoreBtn;
    private javax.swing.JLabel lblSlidingIcon;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton loadBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton playGameBtn;
    // End of variables declaration//GEN-END:variables
}
