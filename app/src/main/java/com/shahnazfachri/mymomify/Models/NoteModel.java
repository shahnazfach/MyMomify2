package com.shahnazfachri.mymomify.Models;

public class NoteModel {
    private int noteID;
    private String noteTitle;
    private String noteContent;
    private String noteDate;

    public NoteModel(int noteID, String noteTitle, String noteContent, String noteDate) {
        this.noteID = noteID;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.noteDate = noteDate;
    }

    public NoteModel(int noteID, String noteTitle, String noteContent) {
        this.noteID = noteID;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    public NoteModel(String noteTitle, String noteContent, String noteDate) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.noteDate = noteDate;
    }

    public int getNoteID() {
        return noteID;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public String getNoteDate() {
        return noteDate;
    }

}
