package artstudio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

public class ArtStudio extends JFrame {

    DrawingPanel drawingJPanel;
    Color backGroundColor = Color.WHITE;
    private static ImageIcon New_icon = new ImageIcon("images/new_1.png");
    private static ImageIcon open_icon = new ImageIcon("images/load_1.png");
    private static ImageIcon save_icon = new ImageIcon("images/save_1.png");
    private static ImageIcon undo_icon = new ImageIcon("images/undo_1.png");
    private static ImageIcon redo_icon = new ImageIcon("images/redo_1.png");
    private static ImageIcon pencil_icon = new ImageIcon("images/pencil_1.png");
    private static ImageIcon line_icon = new ImageIcon("images/line_1.png");

    private ArtStudio() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int w = (int) tk.getScreenSize().getWidth();
        int h = (int) tk.getScreenSize().getHeight();
        setSize(w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Art Studio");

        JMenuBar menus = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu tools = new JMenu("Tools");
        JMenu help = new JMenu("Help");
        JMenuItem New = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem redo = new JMenuItem("Redo");
        JMenuItem pencil = new JMenuItem("Pencil");
        JMenuItem line = new JMenuItem("Line");
        JMenuItem about = new JMenuItem("About");
        file.add(New);
        file.add(open);
        file.add(new JSeparator());
        file.add(save);
        file.add(saveAs);
        file.add(new JSeparator());
        file.add(exit);
        edit.add(undo);
        edit.add(redo);
        tools.add(pencil);
        tools.add(line);
        help.add(about);
        menus.add(file);
        menus.add(edit);
        menus.add(tools);
        menus.add(help);
        setJMenuBar(menus);

        JPanel toolbarJpanel = new JPanel();
        JToolBar toolBar1 = new JToolBar();
        JToolBar toolBar2 = new JToolBar();
        JToolBar toolBar3 = new JToolBar();
        JToolBar toolBar4 = new JToolBar();
        JToolBar toolBar5 = new JToolBar();
        JButton New_button = new JButton();
        New_button.setIcon(New_icon);
        New_button.setText("New");

        JButton open_toolbar = new JButton();
        open_toolbar.setIcon(open_icon);
        open_toolbar.setText("Open");

        JButton save_toolbar = new JButton();
        save_toolbar.setIcon(save_icon);
        save_toolbar.setText("Save");

        JButton undo_toolbar = new JButton();
        undo_toolbar.setIcon(undo_icon);
        undo_toolbar.setText("Undo");

        JButton redo_toolbar = new JButton();
        redo_toolbar.setIcon(redo_icon);
        redo_toolbar.setText("Redo");

        JButton pencil_toolbar = new JButton();
        pencil_toolbar.setIcon(pencil_icon);
        pencil_toolbar.setText("Pencil");
        pencil_toolbar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawingJPanel.setType(DrawingPanel.Type.PENCIL);
            }
        });

        JButton line_toolbar = new JButton();
        line_toolbar.setIcon(line_icon);
        line_toolbar.setText("Line");
        line_toolbar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawingJPanel.setType(DrawingPanel.Type.LINE);
            }
        });
        
        JButton circle_toolbar = new JButton();
        circle_toolbar.setText("Circle");
        circle_toolbar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawingJPanel.setType(DrawingPanel.Type.CIRCLE);
                }
        });

        Integer[] choice = new Integer[20];
        for (int i = 1; i < 21; i++) {
            choice[i - 1] = i;
        }
        final JComboBox lineWidth = new JComboBox(choice);
        lineWidth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int size = (int) lineWidth.getSelectedItem();
                System.out.println(size);
                drawingJPanel.setSize(size);
            }
        });

        JTextArea lineWidthArea = new JTextArea("Line Width");
        lineWidthArea.setBackground(toolbarJpanel.getBackground());

        JButton white = new JButton("White");
        white.setSize(30, 30);
        white.setBackground(Color.WHITE);
        white.addActionListener(myActionListener(Color.WHITE));

        JButton red = new JButton("Red");
        red.setSize(30, 30);
        red.setBackground(Color.RED);
        red.addActionListener(myActionListener(Color.RED));

        JButton green = new JButton("Green");
        green.setSize(30, 30);
        green.setBackground(Color.GREEN);
        green.addActionListener(myActionListener(Color.GREEN));

        JButton black = new JButton("Black");
        black.setSize(30, 30);
        black.setBackground(Color.BLACK);
        black.addActionListener(myActionListener(Color.BLACK));

        Color[] backgroundColors = new Color[10];

        backgroundColors[0] = Color.BLUE;
        backgroundColors[1] = Color.BLACK;
        backgroundColors[2] = Color.DARK_GRAY;
        backgroundColors[3] = Color.GREEN;
        backgroundColors[4] = Color.ORANGE;
        backgroundColors[5] = Color.WHITE;
        backgroundColors[6] = Color.RED;
        backgroundColors[7] = Color.PINK;
        backgroundColors[8] = Color.CYAN;
        backgroundColors[9] = Color.MAGENTA;
        final JComboBox background = new JComboBox(backgroundColors);
        background.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                backGroundColor = (Color) background.getSelectedItem();
                drawingJPanel.setBackground(backGroundColor);

            }
        });
        
        JTextArea textArea2 = new JTextArea("Background Color");
        //textArea2.setBackground(toolbarJpanel.getBackground());

        toolBar1.add(New_button);
        toolBar1.add(open_toolbar);
        toolBar1.add(save_toolbar);

        toolBar2.add(undo_toolbar);
        toolBar2.add(redo_toolbar);
        toolBar2.add(pencil_toolbar);
        toolBar2.add(line_toolbar);
        toolBar2.add(circle_toolbar);

        toolBar3.add(lineWidth);
        toolBar3.add(lineWidthArea);

        toolBar4.add(white);
        toolBar4.add(red);
        toolBar4.add(green);
        toolBar4.add(black);

        toolBar5.add(background);
        //toolBar5.add(textArea2);

        toolbarJpanel.add(toolBar1);
        toolbarJpanel.add(toolBar2);
        toolbarJpanel.add(toolBar3);
        toolbarJpanel.add(toolBar4);
        toolbarJpanel.add(toolBar5);
        add(toolbarJpanel, BorderLayout.NORTH);

        drawingJPanel = new DrawingPanel();

        drawingJPanel.setBackground(backGroundColor);
        drawingJPanel.setOpaque(true);

        add(drawingJPanel, BorderLayout.CENTER);
        drawingJPanel.setVisible(true);

        setVisible(true);

    }

    private ActionListener myActionListener(final Color color) {
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawingJPanel.setColor(color);
                System.out.println(color.toString());
            }
        };
        return actionListener;
    }

    public static void main(String[] args) {
        new ArtStudio();
        System.out.println("ghjk");
    }

}
