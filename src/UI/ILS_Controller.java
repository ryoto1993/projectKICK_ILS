package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class ILS_Controller {
    @FXML
    ToggleButton att_btn_a, att_btn_b, att_btn_c, att_btn_d, att_btn_e, att_btn_f;
    @FXML
    Label att_lbl_a, att_lbl_b, att_lbl_c, att_lbl_d, att_lbl_e, att_lbl_f;
    @FXML
    Button dill_btn_a, dill_btn_b, dill_btn_c, dill_btn_d, dill_btn_e, dill_btn_f;
    @FXML
    Button uill_btn_a, uill_btn_b, uill_btn_c, uill_btn_d, uill_btn_e, uill_btn_f;
    @FXML
    Label ill_lbl_a, ill_lbl_b, ill_lbl_c, ill_lbl_d, ill_lbl_e, ill_lbl_f;
    @FXML
    Label till_lbl_a, till_lbl_b, till_lbl_c, till_lbl_d, till_lbl_e, till_lbl_f;

    // 在離席更新
    public void changeAttendance() {
        // ToDo: 在離席を更新するメソッド呼び出し
        if(att_btn_a.isSelected()) {att_lbl_a.setText("在席");} else {att_lbl_a.setText("離席");}
        if(att_btn_b.isSelected()) {att_lbl_b.setText("在席");} else {att_lbl_b.setText("離席");}
        if(att_btn_c.isSelected()) {att_lbl_c.setText("在席");} else {att_lbl_c.setText("離席");}
        if(att_btn_d.isSelected()) {att_lbl_d.setText("在席");} else {att_lbl_d.setText("離席");}
        if(att_btn_e.isSelected()) {att_lbl_e.setText("在席");} else {att_lbl_e.setText("離席");}
        if(att_btn_f.isSelected()) {att_lbl_f.setText("在席");} else {att_lbl_f.setText("離席");}
    }

    // ディジタル照度センサによる在離席更新
    public void changeAttendanceBySensor() {

    }

    // 目標照度設定
    public void changeTargetIlluminance(ActionEvent event) {
        // ToDo: 目標照度を更新するメソッド呼び出し
        if(event.getSource() == dill_btn_a) {till_lbl_a.setText(String.valueOf(Integer.parseInt(till_lbl_a.getText())-50));}
        if(event.getSource() == dill_btn_b) {till_lbl_b.setText(String.valueOf(Integer.parseInt(till_lbl_b.getText())-50));}
        if(event.getSource() == dill_btn_c) {till_lbl_c.setText(String.valueOf(Integer.parseInt(till_lbl_c.getText())-50));}
        if(event.getSource() == dill_btn_d) {till_lbl_d.setText(String.valueOf(Integer.parseInt(till_lbl_d.getText())-50));}
        if(event.getSource() == dill_btn_e) {till_lbl_e.setText(String.valueOf(Integer.parseInt(till_lbl_e.getText())-50));}
        if(event.getSource() == dill_btn_f) {till_lbl_f.setText(String.valueOf(Integer.parseInt(till_lbl_f.getText())-50));}

        if(event.getSource() == uill_btn_a) {till_lbl_a.setText(String.valueOf(Integer.parseInt(till_lbl_a.getText())+50));}
        if(event.getSource() == uill_btn_b) {till_lbl_b.setText(String.valueOf(Integer.parseInt(till_lbl_b.getText())+50));}
        if(event.getSource() == uill_btn_c) {till_lbl_c.setText(String.valueOf(Integer.parseInt(till_lbl_c.getText())+50));}
        if(event.getSource() == uill_btn_d) {till_lbl_d.setText(String.valueOf(Integer.parseInt(till_lbl_d.getText())+50));}
        if(event.getSource() == uill_btn_e) {till_lbl_e.setText(String.valueOf(Integer.parseInt(till_lbl_e.getText())+50));}
        if(event.getSource() == uill_btn_f) {till_lbl_f.setText(String.valueOf(Integer.parseInt(till_lbl_f.getText())+50));}
    }

    // ディジタル照度センサによる目標照度更新
    public void changeTargetIlluminanceBySensor() {

    }
}