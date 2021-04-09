package edu.rogachova.things;

import java.util.Objects;

public class Paper
{
    private String message;
    private String name;

    public Paper(String name,String message){
        this.name = name;
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public String getName(){
        return name;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void writeMessage(Pencil pencil, String message){
        System.out.println("Взял " + pencil.getName() + " и написал: " + message);
        this.setMessage(message);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Paper)) return false;
        Paper paper = (Paper) o;
        return Objects.equals(getMessage(), paper.getMessage());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getMessage());
    }

    @Override
    public String toString()
    {
        return "Paper{" +
                "message='" + message + '\'' +
                '}';
    }
}
