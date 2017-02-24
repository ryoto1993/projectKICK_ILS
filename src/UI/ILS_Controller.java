package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class ILS_Controller {
    @FXML
    ToggleButton att_btn_a, att_btn_b, att_btn_c, att_btn_d, att_btn_e, att_btn_f;
    @FXML
    Label att_lbl_a, att_lbl_b, att_lbl_c, att_lbl_d, att_lbl_e, att_lbl_f;

    // 在離席更新
    public void changeAttendance(ActionEvent event) {
        if(event.getSource() == att_btn_a) System.out.println("aho");
        if(att_btn_a.isSelected()) {
            att_lbl_a.setText("在席");
        } else {
            att_lbl_a.setText("離席");
        }

        if(att_btn_b.isSelected()) {
            att_lbl_b.setText("在席");
        } else {
            att_lbl_b.setText("離席");
        }

        if(att_btn_c.isSelected()) {
            att_lbl_c.setText("在席");
        } else {
            att_lbl_c.setText("離席");
        }

        if(att_btn_d.isSelected()) {
            att_lbl_d.setText("在席");
        } else {
            att_lbl_d.setText("離席");
        }

        if(att_btn_e.isSelected()) {
            att_lbl_e.setText("在席");
        } else {
            att_lbl_e.setText("離席");
        }

        if(att_btn_f.isSelected()) {
            att_lbl_f.setText("在席");
        } else {
            att_lbl_f.setText("離席");
        }

    }

    // ディジタル照度センサによる在離席更新
    public void changeAttendanceBySensor() {

    }
}