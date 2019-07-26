import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent evt)
	{
		JButton bc = (JButton)evt.getSource();
		if(bc == Va.up)
		{
		   if(Va.nod == 8)
				return;
		   Va.nod++;
		   reset();
		}
		else if(bc == Va.down)
		{
		   if(Va.nod == 3)
				return;
		   Va.nod--;
		   reset();
		}
		else if(bc == Va.restart)
		{
			reset();
		}
		else if(bc == Va.toggle_play)
		{
			if(!Va.play){
				Va.toggle_play.setText("Pause");
				Va.song.play();
				Va.play = !Va.play;
			}else{
				
				Va.toggle_play.setText("Play");
				Va.song.stop();
				Va.play = !Va.play;
			}
		}
	}
	private void reset()
	{
		Va.t0stack.clear();
		Va.t1stack.clear();
		Va.t2stack.clear();
		for(int i=0; i<8; i++)
		{
			Va.main.bgla.remove(Va.disks[i]);
		}
		for(int i=0; i<3; i++)
		{
			Va.main.bgla.remove(Va.vbars[i]);
		}
		int y = 550;
		for(int i=8-Va.nod; i<8; i++)
		{
			int x = 180-Va.diskw[i]/2;
			Va.disks[i].setBounds(x, y-=30, Va.diskw[i], 30);
			Va.disks[i].tn = 0;
			Va.main.bgla.add(Va.disks[i]);
			Va.t0stack.push(Va.disks[i]);
		}
		for(int i=0; i<3; i++)
		{
			Va.main.bgla.add(Va.vbars[i]);
		}
		Va.main.repaint();
		Va.nom = 0;
		Va.info3.setText("<html><body style='font-size: 25px;'>Moves: <b>0</b></body></html>");
		Va.info5.setVisible(false);
		Va.blinking = false;
		if(Va.cdisk!=null)
			Va.cdisk.setVisible(true);
		Va.cdisk = null;
		Va.cstack = null;
		int m = (int)(java.lang.Math.pow(2,Va.nod))-1;
		Va.info2.setText("<html><body style='font-size: 25px;'>Discs: <b>" + Va.nod + "</b></body></html>");
		Va.info4.setText("<html><body style='font-size: 16px;'><b>Minimum moves: " + m + "</b></body></html>");		
	}
}