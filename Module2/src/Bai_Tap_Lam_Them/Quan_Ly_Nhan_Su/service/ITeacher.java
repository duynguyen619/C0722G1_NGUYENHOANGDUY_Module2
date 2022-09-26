package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service;

import java.io.IOException;

public interface ITeacher {
    void addTeacher() throws IOException ;

    void removeTeacher() throws IOException;

    void displayAllTeacher() throws IOException;

    void search();
    void editTeacher() throws IOException ;
}
