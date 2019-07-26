import javax.swing.*;
import java.awt.event.*;
public class TowerListener extends MouseAdapter
{
	public void mouseClicked(MouseEvent evt)
	{
		Va.cstack = (MLabel)evt.getSource();
		if(!Va.blinking)
			return;
		int ctn = Va.cstack.tower;
		if(Va.cdisk.tn == ctn)
			return;
		Va.destList = Va.list.get(ctn);
		if(Va.destList.isEmpty() || Va.cdisk.dn > Va.destList.peek().dn)
			move(ctn);
		else
			return;
	}
	private void move(int ctn)
	{
		int x = (Va.vbarx[ctn]+10)-(Va.diskw[Va.cdisk.dn])/2;
		Va.destList.push(Va.sourceList.pop());
		Va.cdisk.setLocation(x, 550-(Va.destList.size()*30));
		Va.blinking = false;
		Va.cdisk.setVisible(true);
		Va.cdisk.tn = ctn;
		Va.nom++;
		Va.info3.setText("<html><body style='font-size: 25px;'>Moves: <b>" + Va.nom + "</b></body></html>");
		if(Va.t2stack.size() == Va.nod)
		{
			Va.yay.play();
			Va.info5.setVisible(true);
		}
	}
}