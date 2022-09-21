package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.view;

import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.controller.PersonnelController;

import java.io.IOException;

public class View {
    public static void main(String[] args) throws IOException {
        PersonnelController personnelController =new PersonnelController();
        personnelController.menuManagement();
    }
}
