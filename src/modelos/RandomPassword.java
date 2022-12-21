/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPassword {
    
    //create a random password
    public static String generateRandomPassword(int len){
        //create ASCII Range - alphanumeric
      final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
      SecureRandom random = new SecureRandom();
      return IntStream.range(0, len)
	.map(i -> random.nextInt(chars.length()))
	.mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex)))
	.collect(Collectors.joining());
    }
    
}
