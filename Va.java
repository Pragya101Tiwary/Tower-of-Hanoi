import java.util.*;
import javax.swing.*;
import java.applet.*;

public class Va
{
	public static MainClass main;
	public static JLabel info2 = new JLabel("<html><body style='font-size: 25px;'>Discs: <b>3</b></body></html>");
	public static JButton up = new JButton();
	public static JButton down = new JButton();
	public static JButton restart = new JButton("Restart");
	public static JButton toggle_play = new JButton("Play");
	public static boolean play = false;
	public static JLabel info3 = new JLabel("<html><body style='font-size: 25px;'>Moves: <b>0</b></body></html>");
	public static JLabel info5 = new JLabel("<html><body style='font-size: 30px; color: #ff531a;'>Yaayy!!&nbsp;&nbsp;You did it!!</body></html>");
	public static JLabel info4 = new JLabel("<html><body style='font-size: 16px;'><b>Minimum moves: 7</b></body></html>");
	public static AudioClip yay, song;
	
	public static MLabel[] vbars = new MLabel[3];
	public static int nod = 3, nom = 0;
	public static int[] diskw = {250, 220, 190, 160, 130, 100, 70, 40};
	public static MButton[] disks = new MButton[8];
	public static int[] vbarx = {170, 490, 810};
	public static boolean blinking = false;
	public static MButton pdisk, cdisk;
	public static Stack <MButton> t0stack = new Stack<MButton>();
	public static Stack <MButton> t1stack = new Stack<MButton>();
	public static Stack <MButton> t2stack = new Stack<MButton>();
	public static ArrayList <Stack <MButton>> list = new ArrayList<Stack<MButton>>();
	public static Stack <MButton> sourceList, destList;
	public static MLabel cstack;
	public static void exp(int msec)
		{
		   try
		   {
			Thread.sleep(msec);
		   }
		   catch(Exception ex){}
		}
}