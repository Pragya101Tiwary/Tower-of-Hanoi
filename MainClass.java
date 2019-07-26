import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.util.Random;

class MainClass extends JFrame
{
	JLabel bgla = new JLabel(new ImageIcon(getClass().getResource("images/back.jpg")));
	JPanel btpa[] = new JPanel[4];
	JLabel info1 = new JLabel("<html><body><center><div style = 'font-size:15px; color: #012d73;'><font style = 'font-size:18px; color:black;'>Instructions: </font>Move all the discs to the third tower in the same order. No bigger disc can be stacked over smaller discs. One disc can be moved at a time.</div><center></body></html>");
	JLabel[] hbars = new JLabel[3];
	ButtonListener btl = new ButtonListener();
	DiskMover disk_listener = new DiskMover();
	TowerListener tower_listener = new TowerListener();
	
	public MainClass()
	{
	super("TOWER  OF  HANOI");
	Va.main = this;
	setSize(1000,840);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	setIconImage((new ImageIcon(getClass().getResource("images/back.jpg"))).getImage());
	bgla.setLayout(null);
	add(bgla);
	setStaticInfo();
	ImageIcon ic_up = new ImageIcon(getClass().getResource("images/up.jpg"));
	Va.up.setIcon(ic_up);
	Va.up.addActionListener(btl);
	btpa[0].add(Va.up);
	ImageIcon ic_down = new ImageIcon(getClass().getResource("images/down.jpg"));
	Va.down.setIcon(ic_down);
	Va.down.addActionListener(btl);
	btpa[1].add(Va.down);
	Va.restart.addActionListener(btl);
	btpa[2].add(Va.restart);
	Va.toggle_play.addActionListener(btl);
	btpa[3].add(Va.toggle_play);
	addDisks();
	addBars();
	Va.list.add(Va.t0stack);
	Va.list.add(Va.t1stack);
	Va.list.add(Va.t2stack);
	Va.yay = java.applet.Applet.newAudioClip(getClass().getResource("sounds/yay.wav"));
	Va.song = java.applet.Applet.newAudioClip(getClass().getResource("sounds/song.wav"));
	setVisible(true);
	}
   
   private void setStaticInfo()
   {
		for(int i=0; i<4; i++)
		{
		   btpa[i] = new JPanel();
		   btpa[i].setLayout(null);
		   bgla.add(btpa[i]);
		}
		btpa[0].setBounds(190, 110, 50, 50);
		btpa[1].setBounds(250, 110, 50, 50);
		btpa[2].setBounds(730, 110, 170, 50);
		btpa[3].setBounds(40, 710, 130, 50);
		
		Va.toggle_play.setFont(new Font("elephant",Font.PLAIN,20));
		Va.toggle_play.setBounds(0, 0, 130, 50);
		
		info1.setBounds(30, 30, 940, 50);
		bgla.add(info1);
		
		Va.info2.setBounds(40, 110, 150, 50);
		bgla.add(Va.info2);
		
		Va.up.setBounds(0,0,50,50);
		Va.down.setBounds(0,0,50,50);
		
		Va.info3.setBounds(430, 110, 190, 50);
		bgla.add(Va.info3);
		
		Va.restart.setFont(new Font("elephant",Font.PLAIN,25));
		Va.restart.setBounds(0, 0, 170, 50);

		Va.info5.setBounds(320, 620, 380, 55);
		Va.info5.setVisible(false);
		bgla.add(Va.info5);
		
		Va.info4.setBounds(740, 720, 250, 40);
		bgla.add(Va.info4);
   }
   
   private void addDisks()
   {
		Random rand = new Random();
		int[][] rgb = {{255, 56, 46},{23, 255, 224},{255, 77, 219},{255, 191, 41},{41, 105, 255},{255, 56, 73},{159, 255, 41},{146, 56, 255}};
 
		for(int i=0; i<8; i++)
		{
		   int r = rgb[i][0];
		   int g = rgb[i][1];
		   int b = rgb[i][2];
		   Color randomColor = new Color(r, g, b);
		   Border orange = BorderFactory.createLineBorder(randomColor, 20, true);
		   Va.disks[i] = new MButton(0, i, -1);
		   Va.disks[i].setBorder(orange);
		   Va.disks[i].addActionListener(disk_listener);
		   bgla.add(Va.disks[i]);
		}
		int y = 550;
		for(int i=8-Va.nod; i<8; i++)
		{
			int x = 180-Va.diskw[i]/2;
			Va.disks[i].setBounds(x, y-=30, Va.diskw[i], 30);
			Va.t0stack.push(Va.disks[i]);
		}
   }
   
   private void addBars()
   {
	   	Border gray = BorderFactory.createLineBorder(Color.gray, 18, true);
	   	Border black = BorderFactory.createLineBorder(Color.black, 22, true);
		int x = -280;
		for(int i=0; i<3; i++)
		{
			hbars[i] = new JLabel();
			hbars[i].setBorder(black);
			hbars[i].setBounds(x+=320, 550, 280, 35);
			bgla.add(hbars[i]);
			Va.vbars[i] = new MLabel(i);
			Va.vbars[i].setBorder(gray);
			Va.vbars[i].setBounds(Va.vbarx[i], 265, 20, 295);
			Va.vbars[i].addMouseListener(tower_listener);
			bgla.add(Va.vbars[i]);
		}
   }
   
   public static void main(String[] args)
   {
	   new MainClass();
   }
}