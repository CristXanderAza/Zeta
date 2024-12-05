package UI.PublicacionesComponent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ScrollPerfil extends JPanel {

    private static final long serialVersionUID = 1L;

    public ScrollPerfil() {
        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        contentPanel.setLayout(new BorderLayout()); 
        /*
        TargetExplorer targetExplorer = new TargetExplorer();
        contentPanel.setLayout(new GridLayout(0, 1, 10, 10)); 
        contentPanel.add(new TargetExplorer());
        contentPanel.add(new TargetExplorer());
        contentPanel.add(new TargetExplorer());
        contentPanel.add(new TargetExplorer());
        contentPanel.add(new TargetExplorer());
        contentPanel.add(new TargetExplorer());
        */
        JScrollPane scrollPane = new JScrollPane(contentPanel);

        add(scrollPane, BorderLayout.CENTER);
    }
}
