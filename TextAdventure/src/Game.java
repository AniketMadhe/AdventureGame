import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	JFrame window;
	JPanel imagePanel,startButtonPanel;
	JPanel characterPanel,picturePanel,textAreaPanel,buttonPanel;
	JLabel hpLabel,hpLabelNumber,imageLabel,weaponLabel,weaponLabelName,monsterLabel,monsterLabelHP,inventoryLabel,inventoryLabelName;
	JLabel pictureLabel;
	Container con;
	JButton startButton;
	JButton choice1Button,choice2Button,choice3Button,choice4Button;
	JTextArea textArea;
	Font startButtonFont=new Font( "Times New Roman",Font.BOLD,28);
	Font textAreaFont=new Font("serif",Font.PLAIN,24);
	Font characterFont=new Font("Times New Roman",Font.PLAIN,25);
	Font choiceButtonFont=new Font("Times New Roman",Font.PLAIN,27);
	String position,yourChoice,weapon;
	int playerDamage,monsterHP,monsterDamage,inventory,weaponNumber;
	int playerHP=15;
	
	startButtonHandler sbHandler=new startButtonHandler();
	choiceButtonHandler cbHandler=new choiceButtonHandler();
	
	ImageIcon logoImage,pictureImage;

	public static void main(String[] args) {
		
		new Game();
	}
	
	public Game() {
		
		weapon="Knife";

		window=new JFrame();
		window.getContentPane().setBackground(Color.BLACK);
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		con=window.getContentPane();
	
		imagePanel=new JPanel();
		imagePanel.setBounds(20,18,743, 450);
		imagePanel.setBackground(Color.BLACK);
		
	
		imageLabel=new JLabel();
		//logoImage=new ImageIcon(".//Res//FinalLogo.png");
		logoImage=new ImageIcon(getClass().getClassLoader().getResource("FinalLogo.png"));
		imageLabel.setIcon(logoImage);
		imagePanel.add(imageLabel);
		con.add(imagePanel);
		
		
	
		
		
		startButtonPanel=new JPanel();
		startButtonPanel.setBounds(300,480,180,55);
		startButtonPanel.setBackground(Color.blue);
		startButtonPanel.setLayout(new GridLayout(1,1));
		con.add(startButtonPanel);
		
		startButton=new JButton("START");
		startButton.setBackground(Color.BLACK);
		startButton.setForeground(Color.WHITE);
		startButton.setFont(startButtonFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(sbHandler);
		startButtonPanel.add(startButton);	
		
		
		window.setVisible(true);
		


	}
	public class startButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			gameScreen();
			
		}
	}
	
	public void gameScreen() {
		
		position="townGate";
		
		
		
		 
		imagePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		
		picturePanel=new JPanel();
		picturePanel.setBounds(20,18,471,269);
		picturePanel.setBackground(Color.BLACK);
		
		pictureLabel=new JLabel();
		//pictureImage=new ImageIcon(".//Res//TownGateNew.png");
		pictureImage=new ImageIcon(getClass().getClassLoader().getResource("TownGateNew.png"));
		pictureLabel.setIcon(pictureImage);
		picturePanel.add(pictureLabel);
		
		
		
		
		textAreaPanel=new JPanel();
		textAreaPanel.setBounds(20,300,470,250);
		textAreaPanel.setBackground(Color.BLACK);
		
		textArea=new JTextArea(""+ " So you are At Gate of The Town,"+"\n A Guard is standing in Front of you.\n"
				+ " What will You Do?\n\n"
				+ " 1.Talk to Guard                        3.Leave      " +"\n 2.Attack the Guard \n");
		textArea.setLineWrap(true);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(20,300,470,250);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(textAreaFont);
		textAreaPanel.add(textArea);
		
		characterPanel=new JPanel();
		characterPanel.setBounds(503,18,250,270);
		characterPanel.setBackground(Color.BLACK);
		characterPanel.setLayout(new GridLayout(4,2));
		
		character();
		
		buttonPanel=new JPanel();
		buttonPanel.setBounds(510,320,230,210);
		buttonPanel.setBackground(Color.BLACK);
		buttonPanel.setLayout(new GridLayout(4,1));
		
		
		choice1Button=new JButton(" 1. ");
		choice1Button.setForeground(Color.WHITE);
		choice1Button.setBackground(Color.black);
		choice1Button.setFont(choiceButtonFont);
		choice1Button.setFocusPainted(false);
		choice1Button.addActionListener(cbHandler);
		choice1Button.setActionCommand("C1");
		buttonPanel.add(choice1Button);
		
		choice2Button=new JButton("2.");
		choice2Button.setForeground(Color.WHITE);
		choice2Button.setBackground(Color.black);
		choice2Button.setFont(choiceButtonFont);
		choice2Button.setFocusPainted(false);
		choice2Button.addActionListener(cbHandler);
		choice2Button.setActionCommand("C2");
		buttonPanel.add(choice2Button);
		
		choice3Button=new JButton(" 3. ");
		choice3Button.setForeground(Color.WHITE);
		choice3Button.setBackground(Color.black);
		choice3Button.setFont(choiceButtonFont);
		choice3Button.setFocusPainted(false);
		choice3Button.addActionListener(cbHandler);
		choice3Button.setActionCommand("C3");
		buttonPanel.add(choice3Button);
		
		choice4Button=new JButton(" 4. ");
		choice4Button.setForeground(Color.WHITE);
		choice4Button.setBackground(Color.black);
		choice4Button.setFont(choiceButtonFont);
		choice4Button.setFocusPainted(false);
		choice4Button.addActionListener(cbHandler);
		choice4Button.setActionCommand("C4");
		buttonPanel.add(choice4Button);
		
		
	
		
		con.add(picturePanel);
		con.add(textAreaPanel);
		con.add(characterPanel);
		con.add(buttonPanel);
	}
	public void character() {
		
		
		hpLabel=new JLabel("HP:");
		hpLabel.setBackground(Color.BLACK);
		hpLabel.setForeground(Color.WHITE);
		hpLabel.setFont(characterFont);
		characterPanel.add(hpLabel);
		hpLabelNumber=new JLabel(" ");
		hpLabelNumber.setBackground(Color.BLACK);
		hpLabelNumber.setForeground(Color.WHITE);
		hpLabelNumber.setFont(characterFont);
		characterPanel.add(hpLabelNumber);
		weaponLabel=new JLabel("Weapon:");
		weaponLabel.setBackground(Color.BLACK);
		weaponLabel.setForeground(Color.WHITE);
		weaponLabel.setFont(characterFont);
		characterPanel.add(weaponLabel);
		weaponLabelName=new JLabel(" ");
		weaponLabelName.setBackground(Color.BLACK);
		weaponLabelName.setForeground(Color.WHITE);
		weaponLabelName.setFont(characterFont);
		characterPanel.add(weaponLabelName);
		
		monsterLabel=new JLabel("MonsterHP:");
		monsterLabel.setBackground(Color.BLACK);
		monsterLabel.setForeground(Color.WHITE);
		monsterLabel.setFont(characterFont);
		characterPanel.add(monsterLabel);
		monsterLabelHP=new JLabel(" ");
		monsterLabelHP.setBackground(Color.BLACK);
		monsterLabelHP.setForeground(Color.WHITE);
		monsterLabelHP.setFont(characterFont);
		characterPanel.add(monsterLabelHP);
		inventoryLabel=new JLabel("Inventory:");
		inventoryLabel.setBackground(Color.BLACK);
		inventoryLabel.setForeground(Color.WHITE);
		inventoryLabel.setFont(characterFont);
		characterPanel.add(inventoryLabel);
		inventoryLabelName=new JLabel();
		inventoryLabelName.setBackground(Color.BLACK);
		inventoryLabelName.setForeground(Color.WHITE);
		inventoryLabelName.setFont(characterFont);
		characterPanel.add(inventoryLabelName);
		
		if(inventory==2) {
			playerHP=15;
			monsterHP=20;
		}else if(inventory==1) {
			  if(monsterHP<0) {
					
				 monsterLabelHP.setText(" Killed ");
				 inventoryLabelName.setText(" Ring");
				 
			}  
			  
		}else if(weaponNumber==1) {
			 weaponLabelName.setText("Sword");
		} else if(weaponNumber!=1) {
			weaponLabelName.setText("Knife");
			
		}
		
		hpLabelNumber.setText(" "+ playerHP);
		
		weaponLabelName.setText(weapon);
		
		
	}
	public void talkGuard() {
		position="talkGuard";
		//pictureImage=new ImageIcon(".//Res//TalkGuardNew.png");
		pictureImage=new ImageIcon(getClass().getClassLoader().getResource("TalkGuardNew.png"));
		pictureLabel.setIcon(pictureImage);
		picturePanel.add(pictureLabel);
		
		if(inventory==1) {
			
			
			 monsterLabelHP.setText(" Killed ");
			
		}
		
		textArea.setText("Hello there, You want to go town?\nSorry but.....\nWe don't  let the Stranger enter our town!"
				+"\n\n 1.Back");
		
		choice1Button.setText(" 1. ");
		choice2Button.setText(" 2. ");
		choice3Button.setText(" 3. ");
		choice4Button.setText(" 4. ");
		
	}
	public void attackGuard() {
        position="attackGuard";
        playerHP=playerHP-3;
        hpLabelNumber.setText(" "+ playerHP);
        
       

	
        
        //pictureImage=new ImageIcon(".//Res//AttackGuardNew.png");
        pictureImage=new ImageIcon(getClass().getClassLoader().getResource("AttackGuardNew.png"));
		pictureLabel.setIcon(pictureImage);
		picturePanel.add(pictureLabel);
		
		 if(playerHP<0) {
	        	
	        	Lost();
	        }
        
		 else if(inventory==1) {
			
			 monsterLabelHP.setText(" Killed ");
		}
		
		textArea.setText("Hey Don't be stupid ,\n Guard hits you !!\n \n You Recieved (3 damage!)\n\n 1.Back");
		
		choice1Button.setText(" 1. ");
		choice2Button.setText(" 2. ");
		choice3Button.setText(" 3. ");
		choice4Button.setText(" 4. ");
		
		
	}
	public void crossRoad() {
		    position="crossRoad";
		    //pictureImage=new ImageIcon(".//Res//CrossRoadNew.png");
		    pictureImage=new ImageIcon(getClass().getClassLoader().getResource("CrossRoadNew.png"));
			pictureLabel.setIcon(pictureImage);
			picturePanel.add(pictureLabel);
			
			textArea.setText("You are at the CrossRoad now.\n where you want to go?\n\n 1.TownGate \n 2. Riverside \n 3.Forest \n 4.Demon Cave ");
			
			choice1Button.setText(" 1. ");
			choice2Button.setText(" 2. ");
			choice3Button.setText(" 3. ");
			choice4Button.setText(" 4. ");
		
			
		
	}
	public void RiverSide() {
		    position="RiverSide";
		    //pictureImage=new ImageIcon(".//Res//RiverSideNew.png");
		    pictureImage=new ImageIcon(getClass().getClassLoader().getResource("RiverSideNew.png"));
			pictureLabel.setIcon(pictureImage);
			picturePanel.add(pictureLabel);
			
			textArea.setText("There is River there .\n You can Drink water and Rest here! "
					+" \n( Your HP will get Covered !) \n\n 1.Drink \n 2.Back ");
			
			choice1Button.setText(" 1. ");
			choice2Button.setText(" 2. ");
			choice3Button.setText(" 3. ");
			choice4Button.setText(" 4. ");
		
		
	}
	public void Drink() {
		    position="Drink";
		    //pictureImage=new ImageIcon(".//Res//RiverSideNew2.png");
		    pictureImage=new ImageIcon(getClass().getClassLoader().getResource("RiverSideNew2.png"));
			pictureLabel.setIcon(pictureImage);
			picturePanel.add(pictureLabel);
			playerHP=playerHP+2;
		    
			textArea.setText(" (Your HP is Recovered by 2.)\n\n1.back ");
			
			choice1Button.setText(" 1. ");
			choice2Button.setText(" 2. ");
			choice3Button.setText(" 3. ");
			choice4Button.setText(" 4. ");
			
			hpLabelNumber.setText(" "+ playerHP);
	}
	public void Forest() {
		    position="Forest";
		    //pictureImage=new ImageIcon(".//Res//ForestNew.png");
		    pictureImage=new ImageIcon(getClass().getClassLoader().getResource("ForestNew.png"));
			pictureLabel.setIcon(pictureImage);
			picturePanel.add(pictureLabel);
			
			textArea.setText(" There is is Mystery box there,\n\n What will you do?\n\n 1.Open \n2.Go back to CrossRoad ");
			
			choice1Button.setText(" 1. ");
			choice2Button.setText(" 2. ");
			choice3Button.setText(" 3. ");
			choice4Button.setText(" 4. ");
		
	}
	public void MysteryBox(){
		    position="MysteryBox";
		    weapon="Sword";
		    weaponNumber=1;
		    
		    
		    //pictureImage=new ImageIcon(".//Res//ForestNew2.png");
		    pictureImage=new ImageIcon(getClass().getClassLoader().getResource("ForestNew2.png"));
			pictureLabel.setIcon(pictureImage);
			picturePanel.add(pictureLabel);
		
		    textArea.setText(" You found a Long Sword! \n\n 1.crossRoad");
		    
		    choice1Button.setText(" 1. ");
			choice2Button.setText(" 2. ");
			choice3Button.setText(" 3. ");
			choice4Button.setText(" 4. ");
		
		   
		    weaponLabelName.setText(weapon);
		
		
	}
	public void DemonCave() {
		    position="DemonCave";
		    monsterHP=20;
		    //pictureImage=new ImageIcon(".//Res//CaveNew2.png");
		    pictureImage=new ImageIcon(getClass().getClassLoader().getResource("CaveNew2.png"));
			pictureLabel.setIcon(pictureImage);
			picturePanel.add(pictureLabel);
			
		    textArea.setText(" There is Strong Monster in the Cave.\n\n What will you do? \n\n 1.Fight \n 2.Run ");
		
		    choice1Button.setText(" 1. ");
			choice2Button.setText(" 2. ");
			choice3Button.setText(" 3. ");
			choice4Button.setText(" 4. ");
			
			monsterLabelHP.setText(" "+monsterHP);
			  
		
		}
	public void Fight() {
		    position="Fight";
		    //pictureImage=new ImageIcon(".//Res//Cave2.png");
		    pictureImage=new ImageIcon(getClass().getClassLoader().getResource("Cave2.png"));
			pictureLabel.setIcon(pictureImage);
			picturePanel.add(pictureLabel);
			
			
		    textArea.setText(" Ohh! You Encountered a Monster \n\n what will you do? \n\n 1.Attack \n 2.Run ");
		    
		    choice1Button.setText(" 1. ");
			choice2Button.setText(" 2. ");
			choice3Button.setText(" 3. ");
			choice4Button.setText(" 4. ");
		
	}
	public void playerAttack() {
		    position="playerAttack";
		    if(weapon.equals("Sword")) {
		    	//pictureImage=new ImageIcon(".//Res//playerAttackSword.png");
			    pictureImage=new ImageIcon(getClass().getClassLoader().getResource("playerAttackSword.png"));
			    pictureLabel.setIcon(pictureImage);
			    picturePanel.add(pictureLabel);
		    }else if(weapon.equals("Knife")) {
		    	//pictureImage=new ImageIcon(".//Res//playerAttackknife.png");
		    	pictureImage=new ImageIcon(getClass().getClassLoader().getResource("playerAttackknife.png"));
			    pictureLabel.setIcon(pictureImage);
			    picturePanel.add(pictureLabel);
		    	
		    }
			
			
		  playerDamage=0;
		  
	 if(weapon.equals("Knife")) {
		 
		 playerDamage=new java.util.Random().nextInt(3);
	  textArea.setText("You Attacked monster and give "+ playerDamage+"damage \n\n 1.>||<");
	 }
	 else if(weapon.equals("Sword")) {
		 
		 playerDamage=new java.util.Random().nextInt(7);
		  textArea.setText("You Attacked monster and give "+ playerDamage+"damage \n\n 1.>||<");
		 
	 }
	  
	  monsterHP=monsterHP-playerDamage;
	  
	  monsterLabelHP.setText(" "+monsterHP);
	  
	    choice1Button.setText(" 1. ");
		choice2Button.setText(" 2. ");
		choice3Button.setText(" 3. ");
		choice4Button.setText(" 4. ");
		
	    
	    if(monsterHP<0) {
	    	
	    	 monsterLabelHP.setText(" Killed ");
	    	
	    	win();
	    }
	   
	
	
		
	}
	public void monsterAttack() {
		position="monsterAttack";
		 if(weapon.equals("Sword")) {
		    	//pictureImage=new ImageIcon(".//Res//MonsterAttackSword.png");
				pictureImage=new ImageIcon(getClass().getClassLoader().getResource("MonsterAttackSword.png"));
			    pictureLabel.setIcon(pictureImage);
			    picturePanel.add(pictureLabel);
			    
			 
		    }else if(weapon.equals("Knife")) {
		    	//pictureImage=new ImageIcon(".//Res//MonsterAttackKnife.png");
		    	pictureImage=new ImageIcon(getClass().getClassLoader().getResource("MonsterAttackKnife.png"));
			    pictureLabel.setIcon(pictureImage);
			    picturePanel.add(pictureLabel);
		    }
		    	
		
		
		monsterDamage=0;
		
		monsterDamage=new java.util.Random().nextInt(5);
		
		playerHP=playerHP-monsterDamage;
		
		textArea.setText("Monster Attacked you and Gave "+monsterDamage+ "damage! \n\n 1.>>");
		
		hpLabelNumber.setText(" "+ playerHP);
		
		choice1Button.setText(" 1. ");
		choice2Button.setText(" 2. ");
		choice3Button.setText(" 3. ");
		choice4Button.setText(" 4. ");
		
		
			if(playerHP<0) {
				
				hpLabelNumber.setText(" Died ");
				
				Lost();
			}
		    }
		
	
	public void Lost() {
		position="Lost";
		inventory=2;
		//pictureImage=new ImageIcon(".//Res//Dead.png");
		pictureImage=new ImageIcon(getClass().getClassLoader().getResource("Dead.png"));
	    pictureLabel.setIcon(pictureImage);
	    picturePanel.add(pictureLabel);
		
		textArea.setText("    \n         Bad Luck!  Try again next time."+ "\n\n 1.Try Again");
		
		choice1Button.setText(" 1. ");
		choice2Button.setText(" 2. ");
		choice3Button.setText(" 3. ");
		choice4Button.setText(" 4. ");
		
	}
	public void win() {
		position="win";
		//pictureImage=new ImageIcon(".//Res//pickUpNew.png");
		pictureImage=new ImageIcon(getClass().getClassLoader().getResource("pickUpNew.png"));
	    pictureLabel.setIcon(pictureImage);
	    picturePanel.add(pictureLabel);
		
		
		
		textArea.setText("...Congratulations! \n You defeated the monster.\n Monster Dropped the Ring!\n\n 1.Pickup");
		
		choice1Button.setText(" 1. ");
		choice2Button.setText(" 2. ");
		choice3Button.setText(" 3. ");
		choice4Button.setText(" 4. ");
		
		
	}
	public void pickUp() {
		position="pickUp";
		//pictureImage=new ImageIcon(".//Res//Win.png");
		pictureImage=new ImageIcon(getClass().getClassLoader().getResource("Win.png"));
	    pictureLabel.setIcon(pictureImage);
	    picturePanel.add(pictureLabel);
		
		inventory=1;
		
		textArea.setText("Now you can give this Ring to Guard,to let you enter the Town. \n\n 1.CrossRoad");
		
		choice1Button.setText(" 1. ");
		choice2Button.setText(" 2. ");
		choice3Button.setText(" 3. ");
		choice4Button.setText(" 4. ");
		    
		    inventoryLabelName.setText(" Ring");
	}
	 public void talkGuardEnd() {
		 if(inventory==1) {
			    //pictureImage=new ImageIcon(".//Res//theEnd.png");
			 pictureImage=new ImageIcon(getClass().getClassLoader().getResource("theEnd.png"));
			    pictureLabel.setIcon(pictureImage);
			    picturePanel.add(pictureLabel);
				
				
			 monsterLabelHP.setText(" Killed ");
		}
		 
		 textArea.setText("ohh... You defeated that Monster? \n Great! You are true Hero.\n\n Welcome to our Town!"
				 +"\n <><><><><><><><><><><><><><><><>"
				 +"  \n                            <Aniket Madhe>\n     ");
		    choice1Button.setText(" 1. ");
			choice2Button.setText(" 2. ");
			choice3Button.setText(" 3. ");
			choice4Button.setText(" 4. ");
		   
	 }
	 
			
public class choiceButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
		
			 yourChoice= event.getActionCommand();
			 
			 switch(position) {
			 case"townGate":
				 switch(yourChoice) {
				 case"C1": 
					 if(inventory==1) {
						 talkGuardEnd(); 
					 }
					 else {
						 talkGuard(); 
					 } break;
					
			     case"C2": attackGuard(); break;
				 case"C3": crossRoad();  break;
				  } break;
			 case"talkGuard":
				 switch(yourChoice) {
				 case"C1": gameScreen(); break;
				 case"C2": break;
				 case"C3": break;
				 case"C4": break;
				 } break;
			 case"attackGuard":
				 switch(yourChoice) {
				 case"C1": gameScreen(); break;
				 } break;
			 case"crossRoad":
				 switch(yourChoice) {
				 case"C1": gameScreen(); break;
				 case"C2": RiverSide(); break;
				 case"C3": Forest(); break;
				 case"C4": DemonCave(); break;
				 } break;
			 case"RiverSide":
				 switch(yourChoice) {
				 case"C1": Drink(); break;
				 case"C2": crossRoad(); break;
				 } break;
			 case"Drink":
				 switch(yourChoice) {
				 case"C1": RiverSide(); break;
			    } break;
			 case"Forest":
				 switch(yourChoice) {
				 case"C1": MysteryBox(); break;
				 case"C2": crossRoad(); break;
				 } break;
			 case"MysteryBox":
				 switch(yourChoice) {
				 case"C1": crossRoad(); break;
				 } break;
			 case"DemonCave":
				 switch(yourChoice) {
				 case"C1": Fight(); break;
				 case"C2": crossRoad(); break;
				 } break;
			 case"Fight":
				 switch(yourChoice) {
				 case"C2": DemonCave(); break;
				 case"C1": playerAttack(); break;
				 } break;
			 case"playerAttack":
				 switch(yourChoice) {
				 case"C1": monsterAttack(); break;
				 
				 } break;
			 case"monsterAttack":
				 switch(yourChoice) {
				 case"C1": Fight(); break;
				 } break;
			 case"win": 
				 switch(yourChoice) {
				 case"C1": pickUp(); break;
				 } break;
			 case"pickUp":
				 switch(yourChoice) {
				 case"C1": crossRoad(); break;
				 } break;
			 case"Lost":
				 switch(yourChoice) {
				 case"C1": gameScreen(); break;
				 } break;

				 
			 } 
			
		}
	}
	
}
