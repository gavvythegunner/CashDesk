/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashdesk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import mysqlwrapper.ConnectionInfo;
import mysqlwrapper.Database;
import mysqlwrapper.SQLResultsHandler;
import mysqlwrapper.Settings;

/**
 *
 * @author gavin
 */
public class MonitorThread implements ActionListener  {

    private javax.swing.JLabel newMemberCount;  
    private CashDeskMainWindow mainWindow = null;
    private final String getNewMembers = "CALL newlyJoinedToday();";
       
    
    private void checkNewMembers() throws IOException, SQLException, InstantiationException, IllegalAccessException 
    {                    
        try {
            ConnectionInfo ci = new ConnectionInfo(Settings.getInstance().getDefaultUser());

            Database db = new Database(ci);
            ResultSet res = db.PerformQuery(getNewMembers);
            List<Object[]> data = SQLResultsHandler.GetResults(res);
            db.close();
            
            if(data.isEmpty()) // no new members right now
            {
                newMemberCount.setText("0");
            }else{
                Integer i = (int)data.size();
                newMemberCount.setText(i.toString());
            }
        } 
        
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(MonitorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

   public JLabel getNewMemberCount() {
        return newMemberCount;
    }

    public void setNewMemberCount(JLabel newMemberCount) {
        this.newMemberCount = newMemberCount;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
            checkNewMembers();
            checkCurrentLoggedIn();
            getTrnasactionHistories();
                 
        }
        
        catch (IOException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MonitorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    private void checkCurrentLoggedIn() 
    {
        mainWindow.GetLoggedIn();
    }
    
     public CashDeskMainWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(CashDeskMainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    private void getTrnasactionHistories() 
    {
//        mainWindow.fetchTransactions();
    }
}
