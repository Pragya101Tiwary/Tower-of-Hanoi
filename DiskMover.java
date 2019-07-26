import java.awt.event.*;
import javax.swing.*;
public class DiskMover implements ActionListener
{
   public void actionPerformed(ActionEvent evt)
   {
	Va.pdisk = (MButton)evt.getSource();
	if(check())
	{ 
	   Va.cdisk = Va.pdisk;
	   new Blink().start();
	}
   }
   private boolean check()
	{
	   if(Va.cdisk!=null && Va.pdisk==Va.cdisk && Va.blinking)
		return false;
	   Va.sourceList = Va.list.get(Va.pdisk.tn);
	   MButton tempPeek = Va.sourceList.peek();
	   if(Va.pdisk != tempPeek)
		return false;
	   if(Va.cdisk != null && tempPeek.tn != Va.cdisk.tn)
	   {
		Va.cdisk.setVisible(true);
		Va.blinking = false;
		return true;
	   }
	   if(!Va.blinking)
		return true;
	   return false;
	}
}