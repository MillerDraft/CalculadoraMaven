import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ModernCal extends Calculator{
    private BackEnd logic;

    public JButton decButton, sRootButton, percentButton, negButton;
    private Font font = new Font("Arial", Font.ITALIC, 20);

    public ModernCal() {
        super();
        // logic = new BackEnd();
        logic = new BackEnd();
    }

    @Override
    public void setFrame() {
        super.setFrame();
        frame.setTitle("Modern Calculator");

        // Set location at Center left of the screen
        frame.setLocation(0, screenSize.height / 2 - frame.getHeight() / 2);

    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void setTextField() {
        super.setTextField();
    }

    @Override
    public void setPanel() {
        panel = new JPanel();
        panel.setBounds(50, 180, 300, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        panel.add(percentButton);
        panel.add(squButton);
        panel.add(sRootButton);
        panel.add(divButton);

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);

        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);

        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);

        panel.add(negButton);
        panel.add(numberButton[0]);
        panel.add(decButton);
        panel.add(equButton);

    }

    @Override
    public void addComponentsToFrame() {
        super.addComponentsToFrame();
    }

    @Override
    public void setButtons() {
        numberButton = new JButton[10];
        functionButton = new JButton[12];

        // Function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");

        negButton = new JButton("+/-");
        delButton = new JButton("←"); //  alt 27
        clrButton = new JButton("C");
        squButton = new JButton("×²"); // Alt 0215 + Alt 0178
        sRootButton = new JButton("²√×"); // Alt 0178 + Alt 251 + Atl 0215
        percentButton = new JButton("%");
        decButton = new JButton(".");

        // Adding buttons to Array
        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = equButton;
        functionButton[5] = decButton;
        functionButton[6] = negButton;
        functionButton[7] = delButton;
        functionButton[8] = clrButton;
        functionButton[9] = squButton;
        functionButton[10] = sRootButton;
        functionButton[11] = percentButton;
        // receive notification when the button in selected,
        // setting button font and focusable status
        for (int i = 0; i < 12; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(font);
            functionButton[i].setFocusable(false);
        }
        // Position of this button on the frame
        delButton.setBounds(250, 110, 100, 50);
        clrButton.setBounds(50, 110, 100, 50);
        clrButton.setBackground(Color.PINK);
        // Create number buttons and receive notification when the button in selected,
        // setting button font and focusable status
        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(font);
            numberButton[i].setFocusable(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object button = e.getSource();
        for (int i = 0; i < 10; i++){
            if (button == numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (button == decButton){
            if (textField.getText().isEmpty()){
                textField.setText("0.");
            }
            if (!textField.getText().contains(".")){
                textField.setText(textField.getText().concat("."));
            }

        }

        else if (button == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        }

        else if (button == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        }

        else if (button == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        }

        else if (button == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        }

        else if (button == equButton){
            num2 = Double.parseDouble(textField.getText());

            result = logic.handleOperation(operator, num1, num2);

            int temp = (int)Math.floor(result);

            if (result == Math.floor(result)){
                textField.setText(String.valueOf(temp));
            }

            else {
                textField.setText(String.valueOf(result));
            }

        }

        else if (button == clrButton){
            textField.setText("");
            result = 0;
            num1 = 0;
            num2 = 0;
        }

        else if (button == delButton){
            String str = textField.getText();
            textField.setText(str.substring(0, str.length() - 1));
        }

        else if (button == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

        else if (button == squButton){
            num1 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(num1 * num1));
        }

        else if (button == sRootButton){
            num1 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.sqrt(num1)));
        }

        else if (button == percentButton){
            num1 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(num1 / 100));
        }
    }


}


