package edu.eci.escuelaing.arep;

import java.util.ArrayList;
import java.util.List;
import static spark.Spark.*;

public class Service2 {

    public static void main(String[] args){
        port(5001);

        get("/hello", (req,res) -> "Hello to use the service 1, please use /palindromo");

        get("/mathService", (req, res) -> {
            String s = req.queryString().split("=")[1];
            return "{ \"operation\" : \"esPalindromo \", \n"+
                    " \"input\" : \"" + s + "\", \n" +
                    " \"output\" : \" " + answer(s) + " \"}";
        });
    }

    private static String answer(String input) {
        String changeWord = new StringBuilder(input).reverse().toString();
        if (changeWord.equals(input)) {
            return "Si es Palindromo";
        } else {
            return "No es Palindromo";
        }
    }
}
