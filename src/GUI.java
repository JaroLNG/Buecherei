import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class GUI {

    //Swing components
    public JFrame frame;
    public JButton book_add;
    public JButton book_return;
    public JButton book_give;
    public JButton book_list;
    public JButton book_info;
    public JButton add_confirm;
    public JPanel panel;
    public JPanel rightpanel;
    public JPanel leftpanel;
    public JPanel book_addpanel;
    public JPanel book_ausleihpanel;
    public JPanel book_ruckgabepanel;
    public JPanel toppanel;
    public JPanel bottompanel;
    public JTextField book_add_name;
    public JTextField book_add_author;
    public JTextField book_add_year;
    public JTextField book_add_genre;
    public JTextField book_return_Id;
    public JTextField book_give_Id;
    public JTextField book_give_to;

    Color lightBlue = new Color(54, 168, 255);
    Color extralightBlue = new Color(100, 194, 255);


    Main service_backend = new Main();

    public GUI(){

        frame = new JFrame();
        panel = new JPanel();
        rightpanel = new JPanel();
        leftpanel = new JPanel();
        book_addpanel = new JPanel();
        toppanel = new JPanel();
        book_ruckgabepanel = new JPanel();
        book_ausleihpanel = new JPanel();
        bottompanel = new JPanel();
        book_add = new JButton("Buch hinzufügen");
        book_list = new JButton("Buchliste");
        book_give = new JButton("Buchausleihe");
        book_return = new JButton("Buchrückgabe");
        book_add_name = new JTextField();
        book_add_author = new JTextField();
        book_add_year = new JTextField();
        book_add_genre = new JTextField();
        book_give_Id = new JTextField();
        book_give_to = new JTextField();
        book_return_Id = new JTextField();


        book_add_name.setPreferredSize(new Dimension(100, 20));
        book_add_author.setPreferredSize(new Dimension(100, 20));
        book_give_to.setPreferredSize(new Dimension(100, 20));
        book_return_Id.setPreferredSize(new Dimension(100, 20));


        book_add.addActionListener(new page_add());
        JButton book_add_confirm = new JButton("Hinzufügen");
        book_add_confirm.addActionListener(new AddBook());

        book_give.addActionListener(new buch_ausleihe());
        JButton book_give_confirm = new JButton("Ausleihen");
        book_give_confirm.addActionListener(new Ausleihe());

        book_return.addActionListener(new buch_ruckgabe());
        JButton book_return_confirm = new JButton("Zurückgeben");
        book_return_confirm.addActionListener(new Ruckgabe());



        panel.setLayout(new BorderLayout());
        book_addpanel.setLayout(new GridLayout(5, 2));
        book_ruckgabepanel.setLayout(new GridLayout(2, 2));
        book_ausleihpanel.setLayout(new GridLayout(3, 2));
        leftpanel.add(book_add);
        leftpanel.add(new JLabel(" "));
        leftpanel.add(book_list);
        leftpanel.add(new JLabel(" "));
        leftpanel.add(book_give);
        leftpanel.add(new JLabel(" "));
        leftpanel.add(book_return);
        leftpanel.add(new JLabel(" "));
        rightpanel.add(new JLabel(" "));
        book_addpanel.add(new JLabel("Name:"));
        book_addpanel.add(book_add_name);
        book_addpanel.add(new JLabel("Autor:"));
        book_addpanel.add(book_add_author);
        book_addpanel.add(new JLabel("Erscheinungsjahr:"));
        book_addpanel.add(book_add_year);
        book_addpanel.add(new JLabel("Genre:"));
        book_addpanel.add(book_add_genre);
        book_addpanel.add(new JLabel(" "));
        book_addpanel.add(book_add_confirm);
        book_addpanel.setVisible(false);
        book_ruckgabepanel.add(new JLabel("ID:"));
        book_ruckgabepanel.add(book_return_Id);
        book_ruckgabepanel.add(new JLabel(" "));
        book_ruckgabepanel.add(book_return_confirm);
        book_ruckgabepanel.setVisible(false);
        book_ausleihpanel.add(new JLabel("ID:"));
        book_ausleihpanel.add(book_give_Id);
        book_ausleihpanel.add(new JLabel("Ausleihen an:"));
        book_ausleihpanel.add(book_give_to);
        book_ausleihpanel.add(new JLabel(" "));
        book_ausleihpanel.add(book_give_confirm);
        book_ruckgabepanel.setVisible(false);
        book_ruckgabepanel.setBackground(extralightBlue);
        book_addpanel.setBackground(extralightBlue);
        book_ausleihpanel.setBackground(extralightBlue);

        //JLabel scalebottom = new JLabel(" ");
        //scalebottom.setPreferredSize(new Dimension(50, 0));
        //bottompanel.add(scalebottom);




        leftpanel.setLayout(new GridLayout(4,2));
        leftpanel.setBackground(lightBlue);

        rightpanel.setBackground(extralightBlue);

        book_add.setBackground(extralightBlue);
        book_list.setBackground(extralightBlue);
        book_give.setBackground(extralightBlue);
        book_return.setBackground(extralightBlue);

        book_add.setBorderPainted(false);
        book_list.setBorderPainted(false);
        book_give.setBorderPainted(false);
        book_return.setBorderPainted(false);

        book_add.setFocusPainted(false);
        book_list.setFocusPainted(false);
        book_give.setFocusPainted(false);
        book_return.setFocusPainted(false);

        book_add.setToolTipText("Füge ein Buch hinzu");
        book_list.setToolTipText("Eine Liste der Bücher");
        book_give.setToolTipText("Ein Buch ausleihen");
        book_return.setToolTipText("Buch zurückgeben");


        panel.setBackground(extralightBlue);
        panel.add(rightpanel, BorderLayout.EAST);
        panel.add(leftpanel, BorderLayout.WEST);
        panel.add(toppanel, BorderLayout.BEFORE_FIRST_LINE);
        panel.add(bottompanel, BorderLayout.AFTER_LAST_LINE);


        frame.setPreferredSize(new Dimension(480, 230));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setTitle("Bücherei");
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();


    }

    class page_add implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            book_ausleihpanel.setVisible(false);
            book_ruckgabepanel.setVisible(false);
            panel.add(book_addpanel, BorderLayout.CENTER);
            book_addpanel.setVisible(true);

        }
    }

    class buch_ruckgabe implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.add(book_ruckgabepanel, BorderLayout.CENTER);
            book_ausleihpanel.setVisible(false);
            book_addpanel.setVisible(false);
            book_ruckgabepanel.setVisible(true);
        }
    }

    class buch_ausleihe implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.add(book_ausleihpanel, BorderLayout.CENTER);
            book_ausleihpanel.setVisible(true);
            book_addpanel.setVisible(false);
            book_ruckgabepanel.setVisible(false);
        }
    }

    class AddBook implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            service_backend.neuesBuch(book_add_name.getText(), book_add_author.getText(), book_add_year.getText(), book_add_genre.getText());
        }
    }

    class Ausleihe implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int idnum = Integer.parseInt(book_give_Id.getText());
            service_backend.buchliste[idnum].ausleihen(book_give_to.getText());
        }
    }

    class Ruckgabe implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int idnum = Integer.parseInt(book_return_Id.getText());
            service_backend.buchliste[idnum].ruckgabe();
        }
    }

}
