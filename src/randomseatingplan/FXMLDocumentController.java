/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomseatingplan;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Pashatania
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField jumlah;

    @FXML
    private List<Button> buttonListFull;

    @FXML
    private List<Button> buttonListHalf;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String jml = jumlah.getText();
        int j;
        if (jml.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input kosong!");
        } else {
            if (checkInput(jml) == false) {
                JOptionPane.showMessageDialog(null, "Input salah! Hanya menerima angka!");
            } else {
                j = Integer.parseInt(jml);
                if (j > 40 || j < 1) {
                    JOptionPane.showMessageDialog(null, "Input angka antara 1-40");
                } else {
                    acak(j);
                }
            }
        }
    }

    @FXML
    private boolean checkInput(String str) {
        boolean status = false;
        if (!str.isEmpty()) {
            for (char c : str.toCharArray()) {
                if (status = Character.isDigit(c)) {
                }
            }
        }
        return status;
    }

    @FXML
    private void acak(int bil) {
        int bilAkhir = bil;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= bilAkhir; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int count = 0;
        if (bil > 20) {
            for (Button button : buttonListFull) {
                button.setText(list.get(count) + "");
                list.remove(count);
            }
        } else {
            for (Button button : buttonListHalf) {
                button.setText(list.get(count) + "");
                list.remove(count);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
