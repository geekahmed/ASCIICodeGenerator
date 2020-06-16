import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class AsciiCode extends Application {

    private TextArea textfield_sentence, textfield_decimal, textfield_hexa, textfield_binary;
    private RadioButton oddparity_radiobutton, evenparity_radiobutton;

    @Override
    public void start(Stage primaryStage) {

        // Creating a Pane and setting properties to it related to the layout.
        Pane primary_pane = new Pane();
        primary_pane.setMinHeight(Double.NEGATIVE_INFINITY);
        primary_pane.setMinWidth(Double.NEGATIVE_INFINITY);
        primary_pane.setMaxHeight(Double.NEGATIVE_INFINITY);
        primary_pane.setMaxWidth(Double.NEGATIVE_INFINITY);
        primary_pane.setPrefHeight(400.0);
        primary_pane.setPrefWidth(600.0);

        // Creating title label
        Label label_title = new Label();
        label_title.setLayoutX(83.0);
        label_title.setLayoutY(14.0);
        label_title.setText("ASCII CODE GENERATOR PROGRAM");
        label_title.setTextFill(Color.valueOf("#0d086e"));
        label_title.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 22.0));

        Label text_label = new Label();
        text_label.setLayoutX(14.0);
        text_label.setLayoutY(61.0);
        text_label.setText("Enter Text");
        text_label.setTextFill(Color.valueOf("#c69a09"));
        text_label.setFont(Font.font("System", FontWeight.BOLD,  13.0));


        textfield_sentence = new TextArea();
        textfield_sentence.setLayoutX(95.0);
        textfield_sentence.setLayoutY(52.0);
        textfield_sentence.setPrefHeight(102.0);
        textfield_sentence.setPrefWidth(491.0);
        textfield_sentence.setWrapText(true);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setLayoutX(139.0);
        hbox.setLayoutY(171.0);
        hbox.setSpacing(15.0);
        hbox.setPadding(new Insets(10, 10, 10, 10));

        Button button_convert = new Button();
        button_convert.setAlignment(Pos.CENTER);
        button_convert.setMnemonicParsing(false);
        button_convert.setText("Convert");
        button_convert.setTextAlignment(TextAlignment.CENTER);
        button_convert.setTextFill(Color.valueOf("#150db2"));
        button_convert.setFont(Font.font("System", FontWeight.BOLD,  14.0));
        button_convert.setPadding(new Insets(10, 10, 10, 10));

        Button button_reset = new Button();
        button_reset.setAlignment(Pos.CENTER);
        button_reset.setMnemonicParsing(false);
        button_reset.setText("Reset");
        button_reset.setTextAlignment(TextAlignment.CENTER);
        button_reset.setTextFill(Color.valueOf("#ad3232"));
        button_reset.setFont(Font.font("System", FontWeight.BOLD,  14.0));
        button_reset.setPadding(new Insets(10, 10, 10, 10));

        evenparity_radiobutton = new RadioButton();
        oddparity_radiobutton = new RadioButton();
        evenparity_radiobutton.setMnemonicParsing(false);
        evenparity_radiobutton.setText("Even Parity");
        oddparity_radiobutton.setMnemonicParsing(false);
        oddparity_radiobutton.setText("Odd Parity");
        ToggleGroup toggleGroup = new ToggleGroup();
        oddparity_radiobutton.setToggleGroup(toggleGroup);
        evenparity_radiobutton.setToggleGroup(toggleGroup);
        hbox.getChildren().addAll(button_convert, button_reset, oddparity_radiobutton, evenparity_radiobutton);


        Label label_decimal = new Label();
        label_decimal.setLayoutX(17.0);
        label_decimal.setLayoutY(229.0);
        label_decimal.setText("Decimal Conversion");

        Label label_hexadecimal = new Label();
        label_hexadecimal.setLayoutX(378.0);
        label_hexadecimal.setLayoutY(229.0);
        label_hexadecimal.setText("Hexadecimal Conversion");

        textfield_decimal = new TextArea();
        textfield_decimal.setLayoutX(17.0);
        textfield_decimal.setLayoutY(245.0);
        textfield_decimal.setPrefHeight(147.0);
        textfield_decimal.setPrefWidth(208.0);
        textfield_decimal.setWrapText(true);
        textfield_decimal.setEditable(false);

        textfield_hexa = new TextArea();
        textfield_hexa.setLayoutX(378.0);
        textfield_hexa.setLayoutY(245.0);
        textfield_hexa.setPrefHeight(147.0);
        textfield_hexa.setPrefWidth(208.0);
        textfield_hexa.setWrapText(true);
        textfield_hexa.setEditable(false);

        textfield_binary = new TextArea();
        textfield_binary.setLayoutX(239.0);
        textfield_binary.setLayoutY(244.0);
        textfield_binary.setPrefHeight(147.0);
        textfield_binary.setPrefWidth(122.0);
        textfield_binary.setWrapText(true);
        textfield_binary.setEditable(false);

        Label label_binary = new Label();
        label_binary.setLayoutX(239.0);
        label_binary.setLayoutY(229.0);
        label_binary.setText("Binary");

        primary_pane.getChildren().addAll(label_binary, label_title, text_label, textfield_sentence, hbox, label_decimal, textfield_decimal, label_hexadecimal, textfield_hexa, textfield_binary);

        button_reset.setOnAction(e -> {
            textfield_sentence.setText("");
            textfield_hexa.setText("");
            textfield_decimal.setText("");
            textfield_binary.setText("");
        });

        button_convert.setOnAction(e -> {
            String input = textfield_sentence.getText();
            if (!oddparity_radiobutton.isSelected() && !evenparity_radiobutton.isSelected()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Parity Selection Error");
                alert.setContentText("Please Select Parity");
                alert.showAndWait();
            } else {
                String userParity = "";
                if (evenparity_radiobutton.isSelected())
                    userParity = "even";
                else if (oddparity_radiobutton.isSelected())
                    userParity = "odd";

                text_converter(input, userParity);
            }


        });

        primaryStage.setTitle("ASCII Code Generator");
        primaryStage.setScene(new Scene(primary_pane));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }



    /*
        Apply the conversion between different systems and display it on the screen.
     */
    private void text_converter(String input, String userParity) {
        StringBuilder sbHexa = new StringBuilder();
        StringBuilder sbDecimal = new StringBuilder();
        StringBuilder sbBinary = new StringBuilder();
        for (int i = 0 ; i < input.length() ; i++){
            String binaryChar = char_to_binary(input.charAt(i));
            String newAscii = ascii_generator(binaryChar,userParity);
            sbHexa.append("0X").append(Integer.toString(Integer.parseInt(newAscii, 2), 16)).append(" ");
            sbDecimal.append(Integer.toString(Integer.parseInt(newAscii, 2), 10)).append(" ");
            sbBinary.append(newAscii).append(" ");
        }
        String s = sbHexa.toString();
        String decimal = sbDecimal.toString();
        textfield_hexa.setText(s);
        textfield_decimal.setText(decimal);
        textfield_binary.setText(sbBinary.toString());
    }

    // generate the new ascii binary string from the given binary representation.
    public static String ascii_generator(String binary, String parity){
        String newString = null;
        // checks the parity of the binary string.
        boolean parityCheck = parity_checker(binary);
        /*
            if it is even parity it checks the request of the user
            if the user needs odd parity it converts it to odd
            else it keeps it even.
            the same logic in the odd parity
         */
        if (parity.equals("even")){
            if (parityCheck){
                newString = binary;
            } else {
                newString = '1' + binary;
            }

        } else if (parity.equals("odd")){

            if (!parityCheck){
                newString = binary;
            } else {
                newString = '1' + binary;
            }

        }

        return newString;
    }

    // Convert character to binary result is string.
    public static String char_to_binary(char ch){
        return Integer.toBinaryString((int) ch);
    }
    // check the parity of the binary string ( counting number of ones ).
    // true even parity
    // false odd parity
    public static boolean parity_checker(String binary){
        int parity = 0 ;
        for (int i = 0 ; i< binary.length();i++){
            if (binary.charAt(i) == '1')
                parity++;
        }
        return (parity % 2 == 0);
    }
}
