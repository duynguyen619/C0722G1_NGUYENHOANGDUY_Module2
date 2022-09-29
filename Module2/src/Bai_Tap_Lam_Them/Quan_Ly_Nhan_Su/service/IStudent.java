package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service;

import java.io.IOException;

public interface IStudent {
    void addStudent() throws IOException;
    void displayAllStudent();
    void removeStudent() throws IOException;
    void search();
    void editStudent() throws IOException;
}
