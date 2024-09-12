import javax.swing.JOptionPane;
class Gui_option_pane{
    public static void main(String args[]){
        String name = JOptionPane.showInputDialog("Enter your name:");
        JOptionPane.showInternalMessageDialog(null,"Hello "+name+". Hope you are having a nice day!");
    }
}