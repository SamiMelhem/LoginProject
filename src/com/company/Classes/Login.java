package com.company.Classes;
import static java.lang.System.out;
import java.util.Scanner;
public class Login
{
    private String[] usernames, emails, passwords;
    private String username, password;
    private Scanner s;
    private boolean newAccount;
    public Login(){
        usernames = new String[0];
        emails = new String[0];
        passwords = new String[0];
        username = "";
        password = "";
        s = new Scanner(System.in);
        newAccount = false;
        out.println("Login");
    }

    public void setUsernames(String[] u){
        usernames = u;
    }

    public void setEmails(String[] e){
        emails = e;
    }

    public void setPasswords(String[] p){
        passwords = p;
    }

    public boolean getNewAccount(){
        return newAccount;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void collectUsername(){
        boolean[] moveOn = {false,false,false};
        String[] inputs = {"",""};
        while(!moveOn[0]){
            out.print("Username: ");
            inputs[0] = s.nextLine();
            if(usernames.length != 0)
                for(String username: usernames)
                    if(inputs[0].equals(username))
                        moveOn[1] = true;
            if(!moveOn[1]){
                out.println("Incorrect Username! Try Again or Create an Account!");
                while(!moveOn[2]){
                    out.print("Do you want to create an account (yes or no)? ");
                    inputs[1] = s.nextLine();
                    if(inputs[1].equals("yes") || inputs[1].equals("no"))
                        moveOn[2] = true;
                    else
                        out.println("Invalid Input! Try Again!");
                }
                if(inputs[1].equals("yes")){
                    newAccount = true;
                    moveOn[0] = true;
                }
            }
            else
                moveOn[0] = true;
        }
        if(!newAccount)
            username = inputs[0];
    }

    public void collectPassword(){
        boolean moveOn = false;
        while(!moveOn){
            out.print("Password: ");
            String input = s.nextLine();
            boolean correct = false;
            if(passwords.length != 0)
                for(String password: passwords)
                    if(input.equals(password))
                        correct = true;
            if(!correct)
                out.println("Incorrect Password! Try Again!"); // use the users email to reset a password
            else{
                moveOn = true;
                password = input;
            }
        }
    }
}

