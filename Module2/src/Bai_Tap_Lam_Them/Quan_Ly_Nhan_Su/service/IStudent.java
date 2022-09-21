package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service;

import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model.Student;

import java.io.IOException;

public interface IStudent {
    void addStudent() throws IOException;

    void displayAllStudent() throws IOException;
    void removeStudent() throws IOException;
    void search();
    void sortStudent() throws IOException;
    void editStudent() throws IOException;
}
